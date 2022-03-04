FROM eclipse-temurin:11-jre-centos7
EXPOSE 8080
WORKDIR /app
ADD build/libs/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]