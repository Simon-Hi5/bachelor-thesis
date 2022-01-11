#!/bin/sh

# Stop and remove old containers
sh ./stopMicroservices.sh

# Build images
docker build -f ../contact-microservice/Dockerfile -t contact-microservice:latest ../contact-microservice
docker build -f ../interaction-microservice/Dockerfile -t interaction-microservice:latest ../interaction-microservice
docker build -f ../opportunity-microservice/Dockerfile -t opportunity-microservice:latest ../opportunity-microservice

docker build -f ../contact-microservice/Dockerfile -t $(minikube ip):5000/contact-microservice:latest ../contact-microservice
docker push $(minikube ip):5000/contact-microservice:latest