#!/bin/sh

# Add insecure registry
sudo sh -c "printf '{\n\"insecure-registries\" : [ \"$(minikube ip):30000\" ]\n}' > /etc/docker/daemon.json"

# Restart docker
systemctl daemon-reload
systemctl restart docker
