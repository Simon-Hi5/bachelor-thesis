#!/bin/sh

# Deploy MongoDB
kubectl apply -f ../../kubernetes/interaction-mongodb.yaml
kubectl rollout status deployments/interaction-db

# Build image from dockerfile
docker build -f ../../interaction-microservice/Dockerfile -t interaction-microservice:latest ../../interaction-microservice

# Deploy Interaction Microservice
kubectl apply -f ../../kubernetes/interaction-microservice.yaml
kubectl rollout status deployments/interaction-service