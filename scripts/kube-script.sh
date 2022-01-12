#!/bin/sh

# Stop and delete old minikube sessions
sh ./kube/stop-minikube.sh

# Start new container
minikube start --driver virtualbox --memory 5120 --cpus 3 --disk-size 30000  --insecure-registry "10.0.0.0/24"

# Deploy private registry
./kube/deploy-registry.sh

# Add insecure registry
./kube/add-insecure-registry.sh

# Deploy Contact Microservice
./kube/deploy-contact-microservice.sh

# Deploy Interaction Microservice
./kube/deploy-interaction-microservice.sh

# Deploy Opportunity Microservice
./kube/deploy-opportunity-microservice.sh

# Deploy CRM Frontend
./kube/deploy-crm-frontend.sh