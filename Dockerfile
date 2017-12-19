FROM openjdk:alpine

RUN apk add --no-cache maven
ADD src /json_validator/src
ADD pom.xml /json_validator/pom.xml
WORKDIR /json_validator
RUN mvn package

EXPOSE 80
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/target/json_validator-0.0.1-SNAPSHOT.jar"]
