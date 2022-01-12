#!/bin/sh

# Deploy MongoDB
kubectl apply -f ../../kubernetes/opportunity-mongodb.yaml
kubectl rollout status deployments/opportunity-db

# Build image from dockerfile
docker build -f ../../opportunity-microservice/Dockerfile -t "$(minikube ip)":30000/opportunity-microservice:latest ../../opportunity-microservice

# Push images to private registry
docker push "$(minikube ip)":30000/opportunity-microservice:latest

# Deploy Opportunity Microservice
kubectl apply -f ../../kubernetes/opportunity-microservice.yaml
kubectl rollout status deployments/opportunity-service