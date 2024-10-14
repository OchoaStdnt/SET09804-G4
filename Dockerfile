FROM openjdk:latest
COPY ./target/SET09804-G4-0.1.0.0-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SET09804-G4-0.1.0.0-jar-with-dependencies.jar"]