FROM openjdk:8-jdk
RUN apt-get update
RUN apt-get install -y maven
COPY Ense375Final /usr/local/service/Ense375Final
WORKDIR /usr/local/service/Ense375Final
RUN mvn package
CMD ["java","-cp","target/app-1.0-SNAPSHOT.jar","com.uregina.app.App"]
