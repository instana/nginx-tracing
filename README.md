# Instana NGINX Tracing Demo

This repository contains a technology preview for Instana's [NGINX](https://www.nginx.com/) tracing functionality.

## Disclaimer

*Instana NGINX tracing is currently a technology preview. Any use of this technical preview, especially in production, is not supported!*

We reserve ourselves the right to make it better and easier before releasing the functionality for General Availability.

## Prerequisites

A `docker-compose` installation running on your machine. This demo has been created and tested on Mac OS X with `docker-compose` and `docker-machine`.

## Configure

Create a `.env` file in the root of the checked-out version of this repository and enter the following text, with the values adjusted as necessary:

```text
agent_key=<TODO FILL UP>
agent_endpoint=<local ip or remote host; e.g., saas-us-west-2.instana.io>
agent_endpoint_port=<443 already set as default; or 4443 for local>
agent_zone=<name of the zone for the agent; default: envoy-tracing-demo>
```

## Build

```bash
pushd client-app
./mvnw clean package
popd

pushd server-app
./mvnw clean package
popd

docker-compose build
```

## Launch

```bash
docker-compose up
```

This will build and launch

- `client-app` service, a simple Spring Boot application that issues a request every second to the ...
- `nginx` service, which routes all incoming requests to the ...
- `server-app` service, a simple Spring Boot application that returns `200` to any HTTP request.

After the agent is bootstrapped and starts accepting spans from NGINX, the resulting traces in the Analyze view will look like the following:

![Service dashboard](images/service-dashboard.png)

![Demo traces in the Analyze view](images/trace-view.png)

Naturally, all the other [NGINX capabilities of Instana](https://docs.instana.io/ecosystem/nginx/) will work out of the box as well ;-)

## Setup an Application Perspective for the Demo

The simplest way is just to assign to the agent a unique zone (the `docker-compose.yml` file comes with the pre-defined `nginx-tracing-demo` zone), and simply create the application to contain all calls with the `agent.zone` tag to have the value `nginx-tracing-demo`.

## Setup in your own environment

In order to install the technology preview in your own setup, you will need to:
1. [Get the right binaries](#released-binaries) for your Nginx version
2. Copy the binaries where your Nginx server can access them
3. [Edit the Nginx configurations](#edit-the-nginx-configurations)
4. Restart the Nginx process or [trigger a configuration reload](https://docs.nginx.com/nginx/admin-guide/basic-functionality/runtime-control/#controlling-nginx) sending a `reload` command

### Released Binaries

**Link**: https://artifact-public.instana.io/artifactory/shared/com/instana/libinstana_sensor/<br/>
**Credentials**: `_:${agent_key}`

Since version 0.7.0, both `linux-amd64-libinstana_sensor.so` and the Nginx OpenTracing module `linux-amd64-nginx-${VERSION}-ngx_http_ot_module.so` are required from Instana in the **same Instana version** for standard GNU/Linux distributions.

The reason for this is that we **cannot support self-compilation** or the modules from F5 which use dynamic linking to the standard C++ library and **could segfault** this way. We use a statically linked standard C++ library for unifying testing and for the benefit of modern C++ code even on older distributions.

Our Nginx Http OpenTracing modules are based on `nginx-opentracing` **v0.9.0**.

There are also special packages containing `-musl-` in their name for musl libc based distributions like e.g. **Alpine Linux**. The Nginx modules with `-openresty-` in their name are for OpenResty and special suffixes containing distribution names are for Nginx from the main repository of that distribution. Suffix `_compatnfo` is required for CentOS/RHEL6.

For **Nginx Plus** it is required to choose the Nginx module with the correct OpenSource Nginx version. The command `nginx -V` reveals it. Example:
```
# nginx -V
nginx version: nginx/1.17.3 (nginx-plus-r19)
...
```
This shows that the module version 1.17.3 is required for Nginx Plus R19.

### Edit the Nginx Configurations

<TODO>

## Release History

### 0.8.0 (2020-03-30)

   * added support for Nginx 1.17.8 and 1.17.9
   * made MaxBufferedSpans configurable (default `1000`)
      * added `max_buffered_spans` JSON config entry
   * added `Server-Timing` entry (`intid`, for "INstana Trace IDentifier") response header to enable correlation with End-User Monitoring (EUM) for page loads
      * Instana `nginx-opentracing` module is mandatory for this functionality
      * superseeds the `add_header` directive workaround in NGINX config
   * handling correlation part of extended `X-INSTANA-L` header for mobile EUM
   * HTTP extra headers are captured also in root spans
      * requires an Instana backend update (v174) for those heads to be matched by the `call.http.header` filter

### 0.7.0 (2020-01-02)

   * enforcing the use of Instana Nginx OpenTracing modules in same version
      * avoiding segfaults and incompatibilities
   * logging `libinstana_sensor` version upon module load
      * information gathering for better support
   * changed the module suffix from `ngx_http_module` to `ngx_http_ot_module`
      * providing a clear hint that this is about OpenTracing
   * building `ngx_http_ot_module` versions until `1.17.7` and Nginx Plus R20
   * added timestamps and prefix "[lis]" to log messages for better debugging
   * added pid to log messages
   * enforcing IPv4 in agent host name resolution
      * avoiding failure due to IPv6 address for same host name
   * implemented a new discovery request format
      * requiring the C++ sensor 1.1.0 agent part for faster agent connection
   * reworked the agent connection/discovery to quickly connect
      * if no agent host is configured, then the gateway is checked first
   * only logging an error if connections to all agent host candidates fail
      * converted misleading error message upon failure of first candidate
   * increased span flushing interval from 5s to 1s

### 0.6.0 (2019-09-06)

   * building the Nginx OpenTracing modules as well to fix compatibility issues
      * using `nginx-opentracing` release `v0.9.0`

### 0.5.4 (2019-03-20)

   * initial public release

## Debugging

### Version Deprecation

Older versions than 0.7.0 are not supported any more. The enhancements of this version are crucial for better support.

### Nginx Binary Signature

Nginx compares the OpenSource Nginx version of modules to be loaded first. If it matches, then it checks a binary signature which is basically a compile feature list. With the `binutils` package installed it is possible to read it and to find the module variant with the required binary signature:
```
strings ${NGINX_BINARY_OR_MODULE_PATH} | grep "^[0-9],[0-9],[0-9],[0-1]\{34\}$"
```

The typical binary signature with compatibility is `8,4,8,0011111111010111001111111111111111`.

### Debug Logging Libinstana_sensor

Just insert the following line in the middle of the config in `instana-config.json`:
```
"log_level": "debug",
```

### Firewall Config

In order to reach the Instana agent via IPv4, it is required to use the correct agent hostname which will resolve to the correct IP address and **TCP port 42699** has to be open. Network debugging packages `iproute2`, `iputils-ping`, and `netcat` should be installed.

Example with Nginx in a Ubuntu Docker container and the Instana agent on the host:
```
host# ss -tlnp    # verify agent listens to port 42699 at proper IP
host# docker ps
host# docker exec -it ${CONTAINER} /bin/bash
container# apt-get update && apt-get upgrade && apt-get install \
iproute2 iputils-ping netcat
container# ip -s a                   # correct network
container# ping 172.25.0.1           # ping works
container# nc 172.25.0.1 42699       # oops, port seems to be blocked
(UNKNOWN) [172.25.0.1] 42699 (?) : No route to host
host$ firewall-config                # open TCP port 42699
```
