#!/bin/sh

# Stop and remove old containers
docker stop mongodb
docker rm mongodb

# Start new container
docker run -d -p 27017:27017 --name mongodb mongo:latest