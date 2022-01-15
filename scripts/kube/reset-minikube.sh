#!/bin/sh

# Stop and delete old minikube sessions
./stop-minikube.sh

# Reset minikube 
sudo rm -rf ~/.minikube;
sudo rm -rf ~/.kub;