#!/bin/sh

# Deploy MongoDB
kubectl apply -f ../../kubernetes/interaction-mongodb.yaml
kubectl rollout status deployments/interaction-db

# Build image from dockerfile
docker build -f ../../interaction-microservice/Dockerfile -t "$(minikube ip)":30000/interaction-microservice:latest ../../interaction-microservice

# Push images to private registry
docker push "$(minikube ip)":30000/interaction-microservice:latest

# Deploy Interaction Microservice
kubectl apply -f ../../kubernetes/interaction-microservice.yaml
kubectl rollout status deployments/interaction-service