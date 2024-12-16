FROM openjdk:17-jdk-alpine
COPY target/pruebatecnica-0.0.1-SNAPSHOT.jar java-app.jar
ENTRYPOINT ["java", "-Xms7168m", "-Xmx7800m", "-jar", "java-app.jar"]