#!/bin/sh

# Make scripts executable
chmod a+x ./**/*.sh

# Build all microservices
(cd ../contact-microservice;mvn install -DskipTests=true)
(cd ../interaction-microservice;mvn install -DskipTests=true)
(cd ../opportunity-microservice;mvn install -DskipTests=true)

# Change directory
cd ./kube || exit

# Stop and delete old minikube sessions
./stop-minikube.sh

# Start new container
minikube start --driver virtualbox --memory 5120 --cpus 3 --disk-size 30000

# Deploy Contact Microservice
./deploy-contact-microservice.sh

# Deploy Interaction Microservice
./deploy-interaction-microservice.sh

# Deploy Opportunity Microservice
./deploy-opportunity-microservice.sh

# Deploy CRM Frontend
./deploy-crm-frontend.sh

# Deploy CRM Frontend
./deploy-horizontal-autoscaler.sh