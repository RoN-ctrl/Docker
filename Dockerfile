FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
COPY ./target/*.jar app.jar
EXPOSE 27015
ENTRYPOINT ["java", "-jar", "/app.jar"]