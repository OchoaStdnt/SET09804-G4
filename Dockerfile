FROM openjdk:latest
COPY ./target/SET09803-G4-2.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SET09803-G4-2.1-jar-with-dependencies.jar"]