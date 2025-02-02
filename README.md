# Instana NGINX Tracing Demo

This repository contains a demo for Instana's [NGINX](https://www.nginx.com/) tracing functionality.

## Prerequisites

A `docker-compose` installation running on your machine. This demo has been created and tested on Mac OS X with `docker-compose` and `docker-machine`.

## Configure

Create a `.env` file in the root of the checked-out version of this repository and enter the following text, with the values adjusted as necessary:

```text
agent_key=<TODO FILL UP>
agent_endpoint=<local ip or remote host; e.g., ingress-red-saas.instana.io>
agent_endpoint_port=<443 already set as default; or 4443 for local>
agent_zone=<name of the zone for the agent; default: nginx-tracing-demo>
```

## Build & Launch

```bash
docker-compose down && docker-compose up --build
```

This will build and launch

- `client-app` service, a simple Spring Boot application that issues a request every second to the ...
- `nginx` service, which routes all incoming requests to the ...
- `server-app` service, a simple Spring Boot application that returns `200` to any HTTP request.

After the agent is bootstrapped and starts accepting spans from NGINX, the resulting traces are logged into files named `spans-<timestamp_ns>` in the directory `agent/logs`.

In the Analyze view this looks like the following:

![Service dashboard](images/service-dashboard.png)

![Demo traces in the Analyze view](images/trace-view.png)

Naturally, all the other [NGINX capabilities of Instana](https://www.ibm.com/docs/en/obi/current?topic=technologies-monitoring-nginx) will work out of the box as well ;-)

## Setup an Application Perspective for the Demo

The simplest way is just to assign to the agent a unique zone (the `docker-compose.yml` file comes with the pre-defined `nginx-tracing-demo` zone), and simply create the application to contain all calls with the `agent.zone` tag to have the value `nginx-tracing-demo`.

## Setup NGINX tracing in your own environment

In order to install this technology in your own setup, you will need to:

1. [Get the right binaries](#released-binaries) for your NGINX version
2. [Copy the binaries](#copy-the-binaries) where your NGINX server can access them
3. [Edit the NGINX configurations](#edit-the-nginx-configurations)
4. Restart the NGINX process or [trigger a configuration reload](https://docs.nginx.com/nginx/admin-guide/basic-functionality/runtime-control/#controlling-nginx) sending a `reload` command

### Released Binaries

**Link**: https://artifact-public.instana.io/artifactory/shared/com/instana/libinstana_sensor/<br/>
**HTTP Basic Auth Credentials**: `_:${agent_key}`

Since version 0.7.0, both `linux-amd64-libinstana_sensor.so` and the NGINX OpenTracing module `linux-amd64-nginx-${VERSION}-ngx_http_ot_module.so` are required from Instana in the **same Instana version** for standard GNU/Linux distributions.
The explanation for not supporting any other build of the NGINX OpenTracing module is provided [below](#Support-for-other-NGINX-OpenTracing-module-builds).

The NGINX Http OpenTracing modules are based on `nginx-opentracing` **v0.22.1**.

#### Which packages should be used

The packages that Instana offers depend on:

- The NGINX version, as shown by the `nginx -V` command:

  ```sh
  # nginx -V
  nginx version: nginx/1.21.3 (nginx-plus-r25-p1)
  ...
  ```

  The output above shows that the module version 1.21.3 is required for NGINX Plus R25 P1.

- The OpenSSL version, as shown by the 'openssl version' command:

  ```sh
  # openssl version
  OpenSSL 3.0.2 15 Mar 2022 (Library: OpenSSL 3.0.2 15 Mar 2022)
  ...
  ```

  The output above shows that the module `libinstana_sensor_ssl3x.so` is required for OpenSSL version 3.0.2.

  ```sh
  # openssl version
  OpenSSL 1.1.1f  31 Mar 2020
  ...
  ```

  The output above shows that the module `libinstana_sensor_ssl1.1x.so` is required for OpenSSL version 1.1.1f.

- The Libc variant used in your distribution (`glibc` or `musl`); you likely use `glibc`, unless you are using Alpine as base-image for your containers, in which case, it's `musl`.
- (In some cases) the particular distribution (when the build used in some official packages is different enough to require bespoke adjustments on Instana side)
- The OpenSSL variant of `libinstana_sensor.so` (either `libinstana_sensor_ssl1.1x.so` or `libinstana_sensor_ssl3x.so`) is to support serverless tracing with OpenSSL 1.1.x or OpenSSL 3.x.x. Choose the correct OpenSSL variant for serverless tracing. Otherwise, use `libinstana_sensor.so`.

The list of binaries and download links is available on the [Binaries](binaries.md) page.

### Copy the Binaries

From the `libinstana_sensor.so` and OpenSSL variants of `libinstana_sensor.so`, choose the correct OpenSSL variant for serverless tracing. If none is needed, use the standard `libinstana_sensor.so`.
Ensure that both files, the chosen `libinstana_sensor.so` and `ngx_http_opentracing_module.so`, are placed on a filesystem that the NGINX process can access, both in terms of locations as well as file permissions.

If NGINX is running directly on the operating system, as opposed to running in a container, it's usually a good choice to copy the two Instana binaries into the folder that contains the other NGINX modules.
You can find where NGINX expects the modules to be located by running the `nginx -V` command and look for the `--modules-path` configuration option, see, e.g., [this response on StackOverflow](https://serverfault.com/a/812994).

In a containerized environment, this may mean to add them to the container image, or mount the files as volumes into the container; see, for example, Docker's [bind mounts](https://docs.docker.com/storage/bind-mounts/) documentation or how to [mount volumes to pods in Kubernetes](https://kubernetes.io/docs/tasks/configure-pod-container/configure-volume-storage/).

### Edit the NGINX Configurations

```nginx
load_module modules/ngx_http_opentracing_module.so;

env INSTANA_SERVICE_NAME;
env INSTANA_AGENT_HOST;
env INSTANA_AGENT_PORT;
env INSTANA_MAX_BUFFERED_SPANS;
env INSTANA_DEV;

events {}

error_log /dev/stdout info;

http {
  error_log /dev/stdout info;

  # The following line loads the Instana libsinstana_sensor library, that
  # gets the tracing data from ngx_http_opentracing_module.so and converts
  # them to Instana AutoTrace tracing data.
  # The content of instana-config.json is discussed below.
  opentracing_load_tracer /usr/local/lib/libinstana_sensor.so /etc/instana-config.json;

  # Propagates the active span context for upstream requests.
  # Without this configuration, the Instana trace will end at
  # NGINX, and the systems downstream (those to which NGINX
  # routes the requests) monitored by Instana will generate
  # new, unrelated traces
  opentracing_propagate_context;

  # Optional: This logs subrequests like e.g. created by the `auth_request`
  # directive so that authorization requests can be traced.
  log_subrequest on;

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
      proxy_pass http://backend;
    }

    location ^~ /other_api {
      proxy_set_header X-AWESOME-HEADER "truly_is_awesome";

      # Using the `proxy_set_header` directive voids for this
      # location the `opentracing_propagate_context` defined
      # at the `http` level, so here it needs to be set again.
      # It needs to be set for every block where `proxy_set_header`
      # is found. This can also be the case at `server` level.
      opentracing_propagate_context;
      
      # The `opentracing_remove_duplication` directive enables the
      # removal of the duplication of the Server-Timing header in the NGINX response.
      # This duplication may occur if more than one tracer is involved in the
      # the process chain of a request.
      # The directive can be inserted in the following contexts: http, server,
      # location, and upstream.
      opentracing_remove_duplication on;

      proxy_pass http://backend;
    }
  }
}
```

**Special case** `opentracing_propagate_context`:

Besides on main (`http`) level, the `opentracing_propagate_context` directive needs to be added for every block (`server` or `location`) where a `proxy_set_header` directive is set as well.
The reason is that OpenTracing context propagation is based on `proxy_set_header` internally and it gets void by it otherwise. This is a limitation of the NGINX module API.

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

- `service`: which name will be associated in the Instana backend with this NGINX process.
  If unspecified, service names will be calculated based on, for example, [HTTP host name or other means](https://www.ibm.com/docs/en/obi/current?topic=applications-services).
- `agent_host`: the IP address or DNS name of the local host agent.
  **You must change this configuration to match the network name of the Instana agent on the same host as the NGINX process**.
- `agent_port`: the port on which the NGINX tracing extension will try to contact the host agent.
  Notice that this port is _not configurable_ agent side.
  The NGINX tracing extension allows you to configure it in case of settings requiring port forwarding or port mapping.
- `max_buffered_spans`: The maximum amount of spans, one per request, that the NGINX tracing extension will keep locally before flushing them to the agent; the default is `1000`.
  The NGINX tracing extension will always flush the locally-buffered spans every one second.
  This setting allows you to reduce the amount of local buffering when your NGINX server is serving more than `1000` requests per second and you want to reduce the memory footprint of your NGINX server by flushing the tracing data faster.

The alternative is to configure the tracer via environment variables. Those take precedence but the file `instana-config.json` is still required. So do the following:

- put an empty configuration `{}` into `instana-config.json`
- do the whitelisting of the environment variables in the NGINX configuration as shown above
- set the environment variables before starting NGINX

This method is especially useful to set the Instana agent host to the host IP in a Kubernetes cluster.

The following example Kubernetes deployment YAML part shows this method:

```yaml
        env:
        - name: INSTANA_SERVICE_NAME
          value: "nginxtracing_nginx"
        - name: INSTANA_AGENT_HOST
          valueFrom:
            fieldRef:
              fieldPath: status.hostIP
```

For details see the [Environment Variable Reference](https://www.ibm.com/docs/en/obi/current?topic=references-environment-variables).

### Support for other NGINX OpenTracing module builds

Using builds of the NGINX OpenTracing module from 3rd parties, including those supported by NGINX itself, are not supported.
The reasons for requiring the Instana build of the NGINX OpenTracing module are technical: **Self-compilation is not supported** (that is, you building your own version) as that would strain unduly Instana support to try and figure out what in the compilation process goes wrong in entirely different and unpredictable setups; similarly, the modules provided by F5 are not supported, because those lack functionality that Instana tracing needs and those use dynamic linking to the standard C++ library and that would lead in many cases to **segfault**.
Indeed, to avoid segfault, the Instana NGINX OpenTracing module is built including a statically linked standard C++ library for unifying testing and for the benefit of modern C++ code even on older distributions.

### Kubernetes Ingress NGINX and NGINX Tracing

The Instana [AutoTrace WebHook](https://www.ibm.com/docs/en/obi/current?topic=kubernetes-instana-autotrace-webhook) can automatically configure distributed tracing for Ingress NGINX and NGINX on Kubernetes and OpenShift.

## Release History

### 1.11.0 (2025-01-21)

  * Add support for NGINX 1.27.3
  * Add support for NGINX Plus R33
  * The discovery response is not checked for the agent header `Server` anymore.

### 1.10.0 (2024-10-14)

  * New Feature: Integrate serverless tracing capabilities for NGINX.

### 1.9.1 (2024-08-22)

  * Bug fix: Upper-case for `Server-Timing` header
  * New Feature: Add directive "`opentracing_remove_duplication`", to enable removal of duplicated `Server-Timing` headers in Nginx response.

### 1.9.0 (2024-03-07)

  * New Feature: support of `INSTANA_LOG_LEVEL`

### 1.8.3 (2024-01-22)

  * Security fixes: strlen security fix, fix for CVE-2023-46137 
  * CI/CD pipelines: consolidate proactive support and sonarqube coverage

### 1.8.2 (2023-07-17)

  * Add support for NGINX 1.24.0, 1.23.4, 1.25.0, 1.25.1
  * Add support for opentracing 0.30.0 and 0.31.0
  * Add support for ingress-nginx controller-v1.8.0

### 1.8.1 (2023-03-23)

  * Add support for NGINX 1.15.3

### 1.8.0 (2023-02-23)

  * Release W3C trace context support

### 1.7.1 (2022-06-29)

  * Fix discovery response bug when tracing section contains additional
    fields not used by tracer.

### 1.7.0 (2022-06-20)

   * W3C Trace Context: truncate 128 bit IDs to 64 bit
   * Add missing NGINX 1.22.0 support
   * Use "tracing" config from agent announce response, fall back to legacy extra headers
   * Support ipv4 and ipv6 addresses to connect to Instana agent
   * Miscellaneous minor code refactoring and improvements
   * Improved build times and ergonomics

### 1.6.0 (2022-04-26)

   * Consolidate build system and CI/CD pipelines
   * Changed log level for ignored JSON fields in discovery response from warn to debug

### 1.4.0 (2022-02-04)

   * migrated to a new continuous integration tool
   * upgraded OpenTracing C++ to version 1.6.0
   * upgraded to `nginx-opentracing` 0.22.1
   * did further internal changes to fit into the IBM ecosystem

### 1.3.1 (2022-01-05)

   * identical to 1.3.0 - rebuilt 1.3.0 due to an overwritten artifact

### 1.3.0 (2021-12-09)

   * upgraded build environments
   * dropped initial wait time of 10s before connecting to the Instana agent
   * now dropping all spans if the agent connection is not established
      * avoiding too delayed spans
      * avoiding using wrongs secrets configuration
   * reduced the interval to poll the answering Instana agent from 30s to 5s
      * faster agent connection

### 1.2.3 (2021-11-11)

   * now storing trace and span IDs as hex strings internally resulting in better debug output

### 1.2.0 (2021-10-14)

   * improved tracing for subrequests when the `auth_request` directive is used
   * fixed handling of requests where `X-INSTANA-L` is set to zero

### 1.1.2 (2021-06-18)

   * updated `nginx-opentracing` to release `v0.18.0`
      * just error logging fixes were added
   * now logging span context variable lookup errors as debug
      * fixes log spam when still unsupported subrequests occur

### 1.1.1 (2020-08-28)

   * added support for NGINX 1.19.2, OpenResty 1.17.8.2

### 1.1.0 (2020-07-31)

   * fixed the agent discovery if `/proc/$pid/sched` (`CONFIG_SCHED_DEBUG`) is not available

### 1.0.1 (2020-07-21)

   * added support for NGINX 1.19.1, OpenResty 1.17.8.1, 1.15.8.3

### 1.0.0 (2020-06-26)

   * added support for NGINX 1.17.10, 1.18.0, and 1.19.0
   * added support for secrets in URLs configured by the agent
   * added support for hiding synthetic calls like `nginx_status` and `api` requests
   * set new config defaults to avoid the need for `opentracing on;` or `opentracing_trace_locations off;`
   * now providing single file downloads with a list of [supported binaries](binaries.md) for simpler setup

### 0.8.0 (2020-03-30)

   * added support for NGINX 1.17.8 and 1.17.9
   * made MaxBufferedSpans configurable (default `1000`)
      * added `max_buffered_spans` JSON config entry
   * added `Server-Timing` entry (`intid`, for "INstana Trace IDentifier") response header to enable correlation with End-User Monitoring (EUM) for page loads
      * Instana `nginx-opentracing` module is mandatory for this functionality
      * superseeds the `add_header` directive workaround in NGINX config
   * handling correlation part of extended `X-INSTANA-L` header for mobile EUM
   * HTTP extra headers are captured also in root spans
      * requires an Instana backend update (v174) for those heads to be matched by the `call.http.header` filter

### 0.7.0 (2020-01-02)

   * enforcing the use of Instana NGINX OpenTracing modules in same version
      * avoiding segfaults and incompatibilities
   * logging `libinstana_sensor` version upon module load
      * information gathering for better support
   * changed the module suffix from `ngx_http_module` to `ngx_http_ot_module`
      * providing a clear hint that this is about OpenTracing
   * building `ngx_http_ot_module` versions until `1.17.7` and NGINX Plus R20
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

   * building the NGINX OpenTracing modules as well to fix compatibility issues
      * using `nginx-opentracing` release `v0.9.0`

### 0.5.4 (2019-03-20)

   * initial public release

## Debugging

### Version Deprecation

Older versions than 1.0.0 are not supported anymore.

### NGINX Binary Signature

NGINX compares the OpenSource NGINX version of modules to be loaded first. If it matches, then it checks a binary signature which is basically a compile feature list.

With `grep` it is possible to read it and to find the module variant with the required binary signature:

```sh
grep --binary-files=text --only-matching "[0-9],[0-9],[0-9],[0-1]\{34\}" ${NGINX_BINARY_OR_MODULE_PATH}
```

If the `binutils` package is installed, then the more precise method is:

```sh
strings ${NGINX_BINARY_OR_MODULE_PATH} | grep "^[0-9],[0-9],[0-9],[0-1]\{34\}$"
```

The typical binary signature with compatibility is `8,4,8,0011111111010111001111111111111111`.

### Debug Logging Libinstana_sensor

Just insert the following line in the middle of the config in `instana-config.json`:

```json
"log_level": "debug",
```

Or if you configure the tracer by environment variables, set `INSTANA_DEV` to "1".

### Firewall Config

In order to reach the Instana agent via IPv4, it is required to use the correct agent hostname which will resolve to the correct IP address and **TCP port 42699** has to be open. Network debugging packages `iproute2`, `iputils-ping`, and `netcat` should be installed.

Example with NGINX in a Ubuntu Docker container and the Instana agent on the host:

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

### Missing Sched File

You see an error like this in the NGINX log:
```
2020-08-31 13:16:01, 7 [lis] Error: discovery failed: failed to open sched file
```

Versions `0.7.0`..`1.0.1` are affected by this and expect that there is a `/proc/$pid/sched` file. But not all kernels are compiled with `CONFIG_SCHED_DEBUG` and the PID from the parent namespace cannot be sent to the agent then.
This has been fixed with version `1.1.0` by falling back to letting the agent find the PID from parent namespace.

### Directive `proxy_set_header` only in Server Blocks

**Customer question**: We have `proxy_set_header` directives only in server blocks in the NGINX configuration. Do we have to set `opentracing_propagate_context` for all locations?

**Answer**: No, it can be set at main (http), server, and location level. So just add it to the server blocks where you have the `proxy_set_header` directives.

### Authorization Subrequests are not traced

The subrequest tracing requires the configuration entry `log_subrequest on;` at main (`http`) level.
Versions before `1.1.2` cause log spam without that setting.
From version `1.2.0` onwards traces from subrequests show the correct URI.
