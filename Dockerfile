FROM openjdk:alpine

EXPOSE 80
ADD /target/json_validator-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]