#!/bin/sh

# Deploy MongoDB
kubectl apply -f ../../kubernetes/contact-mongodb.yaml
kubectl rollout status deployments/contact-db

# Build image from dockerfile
docker build -f ../../contact-microservice/Dockerfile -t contact-microservice:latest ../../contact-microservice

# Deploy Contact Microservice
kubectl apply -f ../../kubernetes/contact-microservice.yaml
kubectl rollout status deployments/contact-service