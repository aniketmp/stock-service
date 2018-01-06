#!/bin/sh

echo "Waiting for the eureka server to start on port $EUREKASERVER_PORT"
echo "********************************************************"
while ! `nc -z eureka $EUREKASERVER_PORT`; do sleep 3; done
echo "******** Eureka Server has started *******************"

echo "Waiting for the supply service to start on port $SUPPLYSERVICE_PORT"
echo "********************************************************"
while ! `nc -z supplyservice $SUPPLYSERVICE_PORT`; do sleep 3; done
echo "******** Supply Service has started *******************"

echo "********************************************************"
echo "Starting Stock Service on port $SERVER_PORT"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Dserver.port=$SERVER_PORT   \
     -Dspring.profiles.active=$PROFILE -jar /usr/local/stockservice/@project.build.finalName@.jar
