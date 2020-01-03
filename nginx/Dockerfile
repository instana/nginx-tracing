FROM ubuntu:18.04

RUN set -x \
  && apt-get update \
  && apt-get install --no-install-recommends --no-install-suggests -y \
              curl apt-transport-https iproute2 \
  && apt-get install --no-install-recommends --no-install-suggests -y \
              lynx curl ca-certificates gnupg2

ARG agent_key

ENV INSTANA_AGENT_KEY=${agent_key}

# Add official Nginx repository
RUN echo "deb http://nginx.org/packages/mainline/ubuntu/ bionic nginx" \
     >> /etc/apt/sources.list \
  && curl -fsSL https://nginx.org/keys/nginx_signing.key | apt-key add - \
  && apt-get update

# Install Nginx from official Nginx repository
RUN nginx_version=`apt-cache madison nginx | cut -d '|' -f2 \
     | tr -d "[:blank:]" | grep 1\.17\.6` \
  && apt-get install nginx=${nginx_version} \
  && rm -f /etc/nginx/nginx.conf \
  && rm -Rf /etc/nginx/conf.d

# Download extension from Artifactory
RUN arti_path=https://artifact-public.instana.io/artifactory/shared/com/instana/libinstana_sensor/; \
    sensor_version=$(lynx -auth _:${INSTANA_AGENT_KEY} -dump -listonly ${arti_path} | grep -o 'https:.*/[0-9]\+\.[0-9]\+\.[0-9]\+/' | rev | cut -d '/' -f 2 | rev | sort -V | tail -n1); \
    curl --user _:${INSTANA_AGENT_KEY} --silent --output /usr/local/lib/libinstana_sensor.so ${arti_path}${sensor_version}/linux-amd64-libinstana_sensor.so && \
    curl --user _:${INSTANA_AGENT_KEY} --silent --output /usr/lib/nginx/modules/ngx_http_opentracing_module.so ${arti_path}${sensor_version}/linux-amd64-nginx-1.17.6-ngx_http_ot_module.so

CMD ["/usr/sbin/nginx", "-g", "daemon off;"]
