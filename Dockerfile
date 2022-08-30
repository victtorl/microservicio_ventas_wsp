FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/microservicio_pedidos_wsp-0.0.1-SNAPSHOT.war pedidos.war 
ENTRYPOINT ["java","-jar","/pedidos.war"]
