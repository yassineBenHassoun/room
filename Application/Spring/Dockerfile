FROM maven:3.8.3-openjdk-17

COPY src  /usr/src
COPY pom.xml /usr/src/app
RUN ./mvnw dependency:go-offline
RUN mvn -f /usr/src/app/pom.xml clean package spring-boot:repackage
RUN  ./mvnw install -DskipTests=true 


FROM java:17.0-jre
RUN apt-get update
RUN apt-get install mysql-client -y
RUN apt-get install libmysql-java -y

FROM openjdk:17 
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]



