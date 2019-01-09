FROM openjdk:8-jdk-alpine
MAINTAINER Lev Khrushchev <levas1992@gmail.com>

ENV JAR_NAME kid-shop

WORKDIR /app
ADD ./${JAR_NAME}-*.jar kidshop.jar

# Embed Tomcat default
VOLUME /tmp

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","kidshop.jar"]

# share application port
EXPOSE 8080