#!/bin/sh

# Deploy MongoDB
kubectl apply -f ../../kubernetes/opportunity-mongodb.yaml
kubectl rollout status deployments/opportunity-db

# Build image from dockerfile
docker build -f ../../opportunity-microservice/Dockerfile -t opportunity-microservice:latest ../../opportunity-microservice

# Deploy Opportunity Microservice
kubectl apply -f ../../kubernetes/opportunity-microservice.yaml
kubectl rollout status deployments/opportunity-service