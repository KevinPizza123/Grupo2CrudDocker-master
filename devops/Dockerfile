FROM debian:11

RUN apt update && apt install -y openjdk-17-jre

COPY GRUPO2-0.0.1-SNAPSHOT.jar /app.jar

CMD ["java","-jar", "/app.jar"]