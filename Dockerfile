FROM openjdk:17

WORKDIR /app

COPY ./target/service-banco-usuario-0.0.1-SNAPSHOT.jar .

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "service-banco-usuario-0.0.1-SNAPSHOT.jar"]
