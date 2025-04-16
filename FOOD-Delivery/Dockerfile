FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built jar file
COPY target/Food-Delivery-0.0.1-SNAPSHOT.jar app.jar

# Expose port for Spring Boot app
EXPOSE 8080

# Set the active Spring profile to 'docker'
ENV SPRING_PROFILES_ACTIVE=docker

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar","--debug"]

