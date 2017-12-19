FROM openjdk:alpine

EXPOSE 80
RUN apk add --no-cache maven
ADD src /json_validator/src
ADD pom.xml /json_validator/pom.xml
WORKDIR /json_validator
RUN mvn clean install -e
CMD mvn exec:java -e
