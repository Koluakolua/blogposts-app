FROM eclipse-temurin:17

LABEL maintainer = "Mykola Kozachenko"

WORKDIR /app

COPY target/user-service-0.0.1-SNAPSHOT.jar USER-SERVICE.jar

ENTRYPOINT ["java", "-jar", "USER-SERVICE.jar"]