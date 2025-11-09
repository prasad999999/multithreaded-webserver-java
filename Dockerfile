# Use official Java base image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory inside the container
WORKDIR /app

# Copy all files from current directory to container
COPY . /app

# Compile all Java files (inside Webserver folder)
RUN javac "WebServer/MultithreadedWebServer"/*.java WebServer/ThreadPool/*.java

# Expose the port used by the server
EXPOSE 8010

# Run the ThreadPool server by default
CMD ["java", "-cp", "WebServer", "ThreadPool.Server"]

