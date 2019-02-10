#!/bin/bash

while ! nc -z config-server 8888; do
    echo "Waiting for the Config Server"
    sleep 3
done

while ! nc -z discovery-server 8761; do
    echo "Waiting for the Discovery Server"
    sleep 3
done

sleep 30

java $JAVA_OPTS -jar $ARTIFACT_FILE