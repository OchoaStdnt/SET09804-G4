FROM openjdk:latest
COPY ./target/SET09803-G4-0.1.0.21-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SET09803-G4-0.1.0.21-jar-with-dependencies.jar"]