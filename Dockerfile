FROM openjdk:17-jdk-slim
WORKDIR /app
COPY java-backend/target/java-backend.jar /app/java-backend.jar
EXPOSE 8080
CMD ["java", "-jar", "java-backend.jar"]