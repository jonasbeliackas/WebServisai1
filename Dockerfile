FROM openjdk:latest

ADD target/docker-spring-app.jar docker-spring-app.jar

EXPOSE 5000

ENTRYPOINT ["java", "-jar", "docker-spring-app.jar"]