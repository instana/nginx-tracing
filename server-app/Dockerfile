FROM openjdk:11-jdk-slim AS nginx-tracing-server-app-build

ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update -y && apt-get install -y --no-install-recommends --no-install-suggests \
    curl \
    ca-certificates

WORKDIR /opt/server-app/
COPY . .
RUN ./mvnw clean package

FROM openjdk:11-jre-slim

VOLUME /tmp
WORKDIR /opt/server-app/
ARG JAR_FILE=target/server-app-1.0.0.RELEASE.jar
COPY --from=nginx-tracing-server-app-build /opt/server-app/${JAR_FILE} ./app.jar

ENTRYPOINT ["java","-jar","app.jar"]
