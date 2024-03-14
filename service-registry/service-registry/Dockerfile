FROM eclipse-temurin:17

LABEL maintainer = "Mykola Kozachenko"

WORKDIR /app

COPY target/service-registry-0.0.1-SNAPSHOT.jar SERVICE-REGISTRY.jar

ENTRYPOINT ["java", "-jar", "SERVICE-REGISTRY.jar"]