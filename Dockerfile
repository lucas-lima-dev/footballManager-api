FROM maven AS build

WORKDIR /src/football-manager

COPY . .

RUN mvn clean package

FROM openjdk:17

EXPOSE 8080

ARG JAR_FILE=taget/*.jar

COPY ./target/football-manager.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]