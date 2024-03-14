FROM eclipse-temurin:17

LABEL maintainer = "Mykola Kozachenko"

WORKDIR /app

COPY target/blogpost-service-0.0.1-SNAPSHOT.jar BLOGPOST-SERVICE.jar

ENTRYPOINT ["java", "-jar", "BLOGPOST-SERVICE.jar"]