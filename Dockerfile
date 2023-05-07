FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ENTRYPOINT ["java","-jar","target/demo.jar"]
EXPOSE 8080