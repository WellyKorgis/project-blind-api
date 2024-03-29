FROM openjdk:17-alpine

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY build/libs/*.jar application.jar

EXPOSE 8080

CMD ["java", "-Dspring.profiles.active=dev", "-jar", "application.jar"]