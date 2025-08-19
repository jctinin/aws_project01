FROM openjdk:17-slim
VOLUME /tmp
ARG DEPENDENCY=target/dependency
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]