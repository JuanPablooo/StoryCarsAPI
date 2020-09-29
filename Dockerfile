FROM openjdk

WORKDIR /app

COPY target/storecars-0.0.1-SNAPSHOT.jar /app/storecars.jar

ENTRYPOINT ["java", "-jar", "spring-app.jar"]