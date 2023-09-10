FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/progresspal-spring-boot.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]