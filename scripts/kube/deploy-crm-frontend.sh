#!/bin/sh

# Connect with minikube docker client
eval "$(minikube docker-env)"


echo "REACT_APP_BACKEND=\"$(minikube ip)\"" > ../../crm-frontend/.env.production

# Build image from dockerfile
docker build -f ../../crm-frontend/Dockerfile -t crm-frontend:latest ../../crm-frontend

# Deploy Contact Microservice
kubectl apply -f ../../kubernetes/crm-frontend.yaml
kubectl rollout status deployments/crm-frontend