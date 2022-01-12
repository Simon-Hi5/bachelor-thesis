#!/bin/sh

# Deploy MongoDB
kubectl apply -f ../../kubernetes/contact-mongodb.yaml
kubectl rollout status deployments/contact-db

# Build image from dockerfile
docker build -f ../../contact-microservice/Dockerfile -t "$(minikube ip)":30000/contact-microservice:latest ../../contact-microservice

# Push images to private registry
docker push "$(minikube ip)":30000/contact-microservice:latest

# Deploy Contact Microservice
kubectl apply -f ../../kubernetes/contact-microservice.yaml
kubectl rollout status deployments/contact-service