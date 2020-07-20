# Instana Kong Tracing Demo

This repository contains a demo for tracing [Kong](https://www.konghq.com) using Instana's [NGINX](https://www.nginx.com/) tracing functionality.

**Note:** This demo is _very much_ work in progress. So much so, that it is not even remotely functional yet.

## TODOs

1. Ship a compatible NGINX module
2. Find a way to specify directives for NGINX location blocks, so we can counteract the fact that the `set_proxy_header` calls done by Kong break the `opentracing_propagate_context` set at HTTP level.
3. Configure Kong routing

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
- `` service, which routes all incoming requests to the ...
- `server-app` service, a simple Spring Boot application that returns `200` to any HTTP request.
