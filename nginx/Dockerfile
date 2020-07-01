FROM ubuntu:18.04 AS tracing_dependencies

RUN set -x \
  && apt-get update \
  && apt-get install --no-install-recommends --no-install-suggests -y \
    lynx curl ca-certificates gnupg2 unzip

ARG download_key
ARG agent_key
ARG nginx_version
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

FROM ubuntu:18.04

RUN set -x \
  && apt-get update \
  && apt-get install --no-install-recommends --no-install-suggests -y \
              curl apt-transport-https ca-certificates iproute2 gnupg2

# Add official Nginx repository
RUN echo "deb http://nginx.org/packages/mainline/ubuntu/ bionic nginx" \
     >> /etc/apt/sources.list \
  && curl -fsSL https://nginx.org/keys/nginx_signing.key | apt-key add - \
  && apt-get update

ARG nginx_version
ENV NGINX_VERSION=${nginx_version}

# Install Nginx from official Nginx repository
RUN nginx_version=`apt-cache madison nginx | cut -d '|' -f2 \
     | tr -d "[:blank:]" | grep --fixed-strings "${NGINX_VERSION}"` \
  && apt-get install nginx=${nginx_version} \
  && rm -f /etc/nginx/nginx.conf \
  && rm -Rf /etc/nginx/conf.d

COPY --from=tracing_dependencies /opt/instana/nginx/libinstana_sensor.so /usr/local/lib/instana/libinstana_sensor.so
COPY --from=tracing_dependencies /opt/instana/nginx/ngx_http_opentracing_module.so /usr/lib/nginx/modules/ngx_http_opentracing_module.so

CMD ["/usr/sbin/nginx", "-g", "daemon off;"]
