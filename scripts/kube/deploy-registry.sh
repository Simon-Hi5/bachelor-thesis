#!/bin/sh

# Deploy private registry
kubectl apply -f ../../kubernetes/private-registry.yaml
kubectl rollout status deployments/registry