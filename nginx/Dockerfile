FROM opentracing/nginx-opentracing

ARG sensor_version=0.5.0
ARG agent_key

ENV INSTANA_AGENT_KEY=${agent_key}
ENV INSTANA_SENSOR_VERSION=${sensor_version}

# Download extension from Artifactory
ADD https://_:${INSTANA_AGENT_KEY}@artifact-public.instana.io/artifactory/shared/com/instana/libenvoy_sensor/${INSTANA_SENSOR_VERSION}/libenvoy_sensor-${INSTANA_SENSOR_VERSION}.so /usr/local/lib/libinstana_sensor.so
RUN chmod 777 /usr/local/lib/libinstana_sensor.so