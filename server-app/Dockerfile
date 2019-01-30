FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/server-app-1.0.0.RELEASE.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]