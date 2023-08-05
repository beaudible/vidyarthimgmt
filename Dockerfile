FROM openjdk:17-alpine
ADD build/libs/*.jar vidhyarthiapp.jar
ENV PORT=8080
WORKDIR app
EXPOSE $PORT
ENTRYPOINT ["java","-jar","vidhyarthiapp.jar"]