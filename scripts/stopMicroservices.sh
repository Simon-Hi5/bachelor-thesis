#!/bin/sh

# Stop and remove old containers
docker stop contact-microservice
docker stop interaction-microservice
docker stop opportunity-microservice
docker rm contact-microservice
docker rm interaction-microservice
docker rm opportunity-microservice