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

## Setup Nginx tracing in your own environment

In order to install the technology preview in your own setup, you will need to:

1. [Get the right binaries](#released-binaries) for your Nginx version
2. [Copy the binaries](#copy-the-binaries) where your Nginx server can access them
3. [Edit the Nginx configurations](#edit-the-nginx-configurations)
4. Restart the Nginx process or [trigger a configuration reload](https://docs.nginx.com/nginx/admin-guide/basic-functionality/runtime-control/#controlling-nginx) sending a `reload` command

### Released Binaries

**Link**: https://artifact-public.instana.io/artifactory/shared/com/instana/libinstana_sensor/
**HTTP Basic Auth Credentials**: `_:${agent_key}`

Since version 0.7.0, both `linux-amd64-libinstana_sensor.so` and the Nginx OpenTracing module `linux-amd64-nginx-${VERSION}-ngx_http_ot_module.so` are required from Instana in the **same Instana version** for standard GNU/Linux distributions.
The explanation for not supporting any other build of the Nginx OpenTracing module is provided [below](#Support-for-other-Nginx-OpenTracing-module-builds).

Our Nginx Http OpenTracing modules are based on `nginx-opentracing` **v0.9.0**.

#### Which packages should I use

The packages that we offer depend on:

- The Nginx version, as shown by the `nginx -V` command:

  ```sh
  # nginx -V
  nginx version: nginx/1.17.3 (nginx-plus-r19)
  ...
  ```

  The output above shows that the module version 1.17.3 is required for Nginx Plus R19.

- The Libc variant used in your distribution (`glibc` or `musl`); you likely use `glibc`, unless you are using Alpine as base-image for your containers, in which case, it's `musl`.
- (In some cases) the particular distribution (when the build used in some official packages is different enough to require bespoke adjustments on our side)

Distro | Version | Nginx distro | Suffix | Nginx stable | Nginx Mainline | Openresty
--- | --- | --- | --- | --- | --- | ---
Alpine Linux | 3.10 | 1.16.1 | _alpine | 1.14+, 1.16+ | 1.15+, 1.17+ | -
Alpine Linux | 3.9 | 1.14.2 | _alpine | 1.14+, 1.16+ | 1.15+, 1.17+ | -
Alpine Linux | 3.8 | 1.14.2 | _alpine | 1.14+, 1.16+ | 1.15+, 1.17+ | -
Amazon Linux | 2018.03 | 1.14.1 | _amazon | CentOS 6*: 1.14+, 1.16+ | CentOS 6*: 1.15+, 1.17+; nginx+ 1.15.10 (r18-p1, no suffix) | 1.13.6, 1.15.8
Amazon Linux | 2 | N/A | - |  CentOS 7: 1.14+, 1.16+ | CentOS 7: 1.15+, 1.17+ | -
Amazon Linux | 1 | 1.14.1 | _amazon | CentOS 6*: 1.14+, 1.16+ | CentOS 6*: 1.15+, 1.17+ | -
CentOS | 7 | N/A | - | 1.14+, 1.16+ | 1.15+, 1.17+ | -
CentOS/RHEL6 | 6 | N/A | - | **: 1.14+, 1.16+ | **: 1.15+, 1.17+ | -
Ubuntu | 18.04 | 1.14.0 | _ubuntu | 1.14+, 1.16+ | 1.15+, 1.17+ | -
Ubuntu | 16.04 | N/A (too old 1.10.3) | - | 1.14+, 1.16+ | 1.15+, 1.17+ | -

*: _compatnfo suffix (without the `HAVE_TCP_FASTOPEN` compile flag)
**: _compatnfo suffix and glibc < 2.14

We use the same module for both Nginx open-source and **Nginx Plus**.

### Copy the Binaries

The two binaries you have downloaded in the previous step must be placed on a filesystem that the Nginx process can access, both in terms of locations as well as file permissions.

If Nginx is running directly on the operative system, as opposed to running in a container, usually a good choice is to copy the two Instana binaries in the folder that contains the other Nginx modules.
You can find where Nginx expects the modules to be located by running the `nginx -V` command and look for the `--modules-path` configuration option, see, e.g., [this response on StackOverflow](https://serverfault.com/a/812994).

In a containerized environment, this may mean to add them to the container image, or mount the files as volumes into the container; see, for example, Docker's [bind mounts](https://docs.docker.com/storage/bind-mounts/) documentation or how to [mount volumes to pods in Kubernetes](https://kubernetes.io/docs/tasks/configure-pod-container/configure-volume-storage/).

### Edit the Nginx Configurations

```nginx
# The following line adds the basic module Instana uses to get tracing data.
# It is required that you use the version of this module built by Instana,
# rather than the one shipped in many Nginx distros, as there are some
# modifications in the Instana version that are required for tracing to work
load_module modules/ngx_http_opentracing_module.so;

events {}

error_log /dev/stdout info;

http {
  # The following line activates tracing; without this line, Instana will
  # receive no tracing data.
  opentracing on;
  error_log /dev/stdout info;

  # The following line loads the Instana libsinstana_sensor library, that
  # gets the tracing data from ngx_http_opentracing_module.so and converts
  # them to Instana AutoTrace tracing data.
  # The content of instana-config.json is discussed below.
  opentracing_load_tracer /usr/local/lib/libinstana_sensor.so /etc/instana-config.json;

  # If you use upstreams, Instana will automatically use them as endpoints,
  # and it is really cool :-)
  upstream backend {
    server server-app:8080;
  }

  server {
    error_log /dev/stdout info;
    listen 8080;
    server_name localhost;

    location /static {
      root /www/html;
    }

    location ^~ /api {
      # Propagates the active span context for upstream requests.
      # Without this configuration, the Instana trace will end at
      # Nginx, and the systems downstream (those to which Nginx
      # routes the requests) monitored by Instana will generate
      # new, unrelated traces
      opentracing_propagate_context;

      # This configuration option prevents duplicated spans from
      # being sent to Instana
      opentracing_trace_locations off;

      proxy_pass http://backend;
    }
  }
}
```

The following is an example of `instana-config.json`:

```json
{
  "service": "nginxtracing_nginx",
  "agent_host": "instana-agent",
  "agent_port": 42699,
  "max_buffered_spans": 1000
}
```

The configurations in the snippet above mean the following:

- `service`: which name will be associated in the Instana backend with the this NGINX process.
  If unspecified, servide names will be calculated based, for example, [HTTP host name or other means](https://docs.instana.io/application_monitoring/services/).
- `agent_host`: the IP address or DNS name of the local host agent.
- `agent_port`: the port on which the NGINX tracing extension will try to contact the host agent.
  Notice that this port is _not configurable_ agent side.
  The NGINX tracing extension allows you to configure it in case of settings requiring port forwarding or port mapping.
- `max_buffered_spans`: The maximum amount of spans, one per request, that the NGINX tracing extension will keep locally before flush them to the agent; the default is `1000`.
  Notice that the NGINX tracing extension will always flush the locally-buffered spans every one second.
  This setting allows you to reduce the amount of local buffering when your NGINX server is serving more than `1000` requests per second.

### Support for other Nginx OpenTracing module builds

We do not support using builds of the Nginx OpenTracing module from 3rd parties, including those supported by Nginx itself.
The reason for requiring the Instana build of the Nginx OpenTracing module is purely technical: we **cannot support self-compilation** (that is, you building your own version, the Nginx module system is too sensitive to build flags) or the modules from F5, because they use dynamic linking to the standard C++ library and that would lead in many cases to **segfault**.
Indeed, to avoid segfault, we use in our build of the Nginx OpenTracing module a statically linked standard C++ library for unifying testing and for the benefit of modern C++ code even on older distributions.

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

```sh
strings ${NGINX_BINARY_OR_MODULE_PATH} | grep "^[0-9],[0-9],[0-9],[0-1]\{34\}$"
```

The typical binary signature with compatibility is `8,4,8,0011111111010111001111111111111111`.

### Debug Logging Libinstana_sensor

Just insert the following line in the middle of the config in `instana-config.json`:

```json
"log_level": "debug",
```

### Firewall Config

In order to reach the Instana agent via IPv4, it is required to use the correct agent hostname which will resolve to the correct IP address and **TCP port 42699** has to be open. Network debugging packages `iproute2`, `iputils-ping`, and `netcat` should be installed.

Example with Nginx in a Ubuntu Docker container and the Instana agent on the host:

```sh
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
