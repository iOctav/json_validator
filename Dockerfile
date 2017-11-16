FROM openjdk:7-jdk-alpine

EXPOSE 80
RUN apk add --no-cache git
RUN apk add --no-cache maven
RUN git clone https://github.com/iOctav/json_validator.git
WORKDIR /usr/src/json_validator
RUN mvn clean install -e
CMD mvn exec:java -e