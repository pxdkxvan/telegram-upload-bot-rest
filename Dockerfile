FROM gradle:8.13-jdk21 AS builder

WORKDIR /app

COPY build.gradle settings.gradle /app/
COPY src /app/src

RUN gradle build --no-daemon -x test

FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=builder /app/build/libs/rest-1.0.jar /app/rest.jar
EXPOSE 8083

ENV REST_NAME=""
ENV REST_PORT=""
ENV APPLICATION_PROTOCOL=""
ENV CONFIG_HOST=""
ENV CONFIG_PORT=""
ENV POSTGRES_HOST=""
ENV POSTGRES_PORT=""
ENV POSTGRES_USER=""
ENV POSTGRES_PASSWORD=""
ENV SMTP_PORT=""
ENV ACTUATOR_ENDPOINT=""

ENTRYPOINT ["java", "-jar", "rest.jar"]