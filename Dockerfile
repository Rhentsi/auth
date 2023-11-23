FROM openjdk:19
COPY ./build/libs/ /tmp
WORKDIR /tmp
EXPOSE 8080
CMD java -jar authentificationService.jar