FROM openjdk:21-jdk-slim
LABEL authors="Bruno"
COPY target/Uciliste-0.0.1-SNAPSHOT.jar uciliste.jar
EXPOSE 8989
ENTRYPOINT ["java", "-jar", "uciliste.jar"]