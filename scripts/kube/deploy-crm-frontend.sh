#!/bin/sh

# Build image from dockerfile
docker build -f ../../crm-frontend/Dockerfile -t "$(minikube ip)":30000/crm-frontend:latest ../../crm-frontend

# Push images to private registry
docker push "$(minikube ip)":30000/crm-frontend:latest

# Deploy CRM Frontend
kubectl apply -f ../../kubernetes/crm-frontend.yaml
kubectl rollout status deployments/crm-frontend