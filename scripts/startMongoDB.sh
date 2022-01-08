#!/bin/sh

# Stop and remove old containers
sh ./stopMongoDB.sh

# Start new container
docker run -d -p 27017:27017 --name mongodb mongo:latest