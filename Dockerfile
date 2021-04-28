FROM openjdk:8-jdk
RUN apt-get update
RUN apt-get install -y maven
COPY ENSE375 exam /usr/local/service/ENSE375 exam
WORKDIR /usr/local/service/ENSE375 exam
RUN mvn package
CMD ["java","-cp","target/app-1.0-SNAPSHOT.jar","com.uregina.app.App"]
