FROM amazoncorretto:17
LABEL authors="denisefc"
WORKDIR /app
COPY ./docker/app.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]