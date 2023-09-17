FROM maven AS build

WORKDIR /app/football-manager

COPY . .

RUN mvn clean package

FROM openjdk:17

EXPOSE 8080

#ARG JAR_FILE=taget/*.jar

WORKDIR /app

COPY --from=build /app/football-manager/target/football-manager*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]