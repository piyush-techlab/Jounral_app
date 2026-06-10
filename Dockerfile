FROM openjdk:27-ea-24-jdk
ADD /target/Journal-App-0.0.1-SNAPSHOT.jar /tmp/Journal-App-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/tmp/Journal-App-0.0.1-SNAPSHOT.jar"]
