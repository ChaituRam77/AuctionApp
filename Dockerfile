FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar biddingApp.jar
ENTRYPOINT ["java","-jar","/biddingApp.jar"]
EXPOSE 8080

