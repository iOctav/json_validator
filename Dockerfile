FROM openjdk:alpine

EXPOSE 80
RUN apk add --no-cache maven
RUN mkdir /api
COPY . /api
RUN mvn package -f /api/pom.xml
ADD /api/target/json_validator-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]