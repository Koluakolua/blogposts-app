FROM eclipse-temurin:17

LABEL maintainer = "Mykola Kozachenko"

WORKDIR /app

COPY /target/api-gateway-0.0.1-SNAPSHOT.jar API-GATEWAY.jar

ENTRYPOINT ["java", "-jar", "API-GATEWAY.jar"]