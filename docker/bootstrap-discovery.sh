#!/bin/bash

while ! nc -z config-server 8888; do
    echo "Waiting for the Config Server"
    sleep 3
done

java -jar discovery-1.0-SNAPSHOT.jar