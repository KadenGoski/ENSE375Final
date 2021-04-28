FROM openjdk:8-jdk
RUN apt-get update
RUN apt-get install -y maven
ARG src="ENSE375 Exam"
COPY  ${src} /usr/local/service/ense375final
WORKDIR /usr/local/service/ense375final
RUN mvn package
CMD ["java","-cp","target/app-1.0-SNAPSHOT.jar","com.uregina.app.App"]
