# Using docker build command:
# docker build --build-arg download_key=$INSTANA_AGENT_KEY -t rhel-ngx-1.20-tracing .

FROM ubuntu:20.04 AS tracing_dependencies

RUN set -x \
  && apt-get update \
  && apt-get install --no-install-recommends --no-install-suggests -y \
    lynx curl ca-certificates gnupg2 unzip

ARG download_key
ARG agent_key
ARG nginx_version=1.20.1
# For Alpine-based images, change the following to 'musl'
ARG libc_version=glibc

ENV INSTANA_DOWNLOAD_KEY=${download_key}
ENV INSTANA_AGENT_KEY=${agent_key}
ENV NGINX_VERSION=${nginx_version}
ENV LIBC_VERSION=${libc_version}
ENV ARTI_PATH='https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/'

# Download extension from Artifactory
RUN download_key=$([ ! -z "${INSTANA_DOWNLOAD_KEY}" ] && echo "${INSTANA_DOWNLOAD_KEY}" || echo "${INSTANA_AGENT_KEY}"); \
    echo "Using download key ${download_key}; NGINX version: ${NGINX_VERSION}; LIBC version: ${LIBC_VERSION}"; \ 
    sensor_version=$(lynx -auth _:${download_key} -dump -listonly ${ARTI_PATH} | grep -o 'https:.*/[0-9]\+\.[0-9]\+\.[0-9]\+/' | rev | cut -d '/' -f 2 | rev | sort -V | tail -n1); \
    echo "Using sensor version ${sensor_version} for NGINX ${NGINX_VERSION}."; \
    tmp_file="tmp.zip"; tmp_dir="/tmp/nginx_tracing"; mkdir -p "${tmp_dir}" && cd "${tmp_dir}" && \
    curl --user _:${download_key} --silent --output ${tmp_file} ${ARTI_PATH}${sensor_version}/linux-amd64-${LIBC_VERSION}-nginx-${NGINX_VERSION}.zip --fail && \
    unzip ${tmp_file} && \
    mkdir -p /opt/instana/nginx && \
    mv ${LIBC_VERSION}-libinstana_sensor.so /opt/instana/nginx/libinstana_sensor.so && \
    mv ${LIBC_VERSION}-nginx-${NGINX_VERSION}-ngx_http_ot_module.so /opt/instana/nginx/ngx_http_opentracing_module.so;

# Prepare target image
FROM registry.access.redhat.com/ubi8/nginx-120

COPY --from=tracing_dependencies /opt/instana/nginx/libinstana_sensor.so /usr/local/lib/instana/libinstana_sensor.so
COPY --from=tracing_dependencies /opt/instana/nginx/ngx_http_opentracing_module.so /usr/share/nginx/modules/ngx_http_opentracing_module.so
COPY nginx.conf /etc/nginx/nginx.conf
COPY instana-config.json /etc/nginx/instana-config.json
COPY backend.conf /opt/app-root/etc/nginx.d/backend.conf

CMD ["/usr/sbin/nginx", "-g", "daemon off;"]
