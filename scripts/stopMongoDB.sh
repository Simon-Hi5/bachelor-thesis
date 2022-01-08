#!/bin/sh

# Stop and remove old containers
docker stop mongodb
docker rm mongodb