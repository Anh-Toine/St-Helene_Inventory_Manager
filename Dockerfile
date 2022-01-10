FROM gradle:6.9.0 as builder
WORKDIR /usr/src/app
COPY src ./src
COPY build.gradle .
RUN ["gradle"]

EXPOSE 8080

FROM adoptopenjdk/openjdk11:alpine-jre
COPY build/libs/*.jar app.jar
RUN apk --no-cache add curl
ENTRYPOINT ["java", "-jar","app.jar"]