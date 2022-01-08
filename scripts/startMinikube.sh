#!/bin/sh

# Stop and remove old minikube sessions
sh ./stopMinikube.sh

# Start new container
minikube start --driver=virtualbox --memory 5000 --cpus 2