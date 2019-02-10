FROM openjdk:8u181-jdk

EXPOSE 8100

RUN apt-get update
RUN apt-get -y upgrade
RUN apt-get -y install netcat

COPY build/libs/gateway-1.0-SNAPSHOT.jar gateway-1.0-SNAPSHOT.jar
COPY bootstrap-gateway.sh bootstrap-gateway.sh

RUN chown 755 bootstrap-gateway.sh

CMD ["bash", "bootstrap-gateway.sh"]