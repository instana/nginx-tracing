FROM opentracing/nginx-opentracing

RUN set -x \
  && apt-get update \
  && apt-get install --no-install-recommends --no-install-suggests -y \
              curl apt-transport-https iproute2 \
  && apt-get install --no-install-recommends --no-install-suggests -y lynx curl

ARG agent_key

ENV INSTANA_AGENT_KEY=${agent_key}

# Download extension from Artifactory
RUN sensor_version=$(lynx -auth _:${INSTANA_AGENT_KEY} -dump -listonly https://artifact-public.instana.io/artifactory/shared/com/instana/libenvoy_sensor/ | grep -o 'https:.*/[0-9]\+\.[0-9]\+\.[0-9]\+/' | rev | cut -d '/' -f 2 | rev | sort -V | tail -n1); \
    curl --user _:${INSTANA_AGENT_KEY} --silent --output /usr/local/lib/libinstana_sensor.so https://artifact-public.instana.io/artifactory/shared/com/instana/libenvoy_sensor/${sensor_version}/libenvoy_sensor-${sensor_version}.so

RUN chmod 777 /usr/local/lib/libinstana_sensor.so