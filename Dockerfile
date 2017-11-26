FROM openjdk:8-jdk-alpine

ARG PROJECT_DIR="/var/lib/MyProject" 

RUN mkdir -p $PROJECT_DIR
COPY build/libs/MyProject-0.0.1-SNAPSHOT.jar $PROJECT_DIR/MyProject.jar
RUN ln -s $PROJECT_DIR/MyProject.jar /etc/init.d/MyProject
RUN adduser -S springboot

USER springboot
ENTRYPOINT ["java", "-jar", "/var/lib/MyProject/MyProject.jar"]
