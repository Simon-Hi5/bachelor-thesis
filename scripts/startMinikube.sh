#!/bin/sh

# Stop and remove old minikube sessions
sh ./stopMinikube.sh

# Start new container
minikube start --driver=virtualbox --memory 5000 --cpus 2 --insecure-registry "192.168.59.117:30400"

# Deploy private registry
./deployRegistry.sh

# Add insecure registry
./add-insecure-registry.sh

# Build images from dockerfiles
docker build -f ../contact-microservice/Dockerfile -t $(minikube ip):30400/contact-microservice:latest ../contact-microservice

# Push images to private registry
docker push $(minikube ip):30400/contact-microservice:latest