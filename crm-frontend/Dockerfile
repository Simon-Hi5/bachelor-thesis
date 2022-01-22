
FROM node:latest as build
WORKDIR /app
COPY package*.json ./
RUN npm install --silent
COPY . .
EXPOSE 3000
CMD ["npm", "start"]
#RUN npm run build

#FROM nginx:alpine
#WORKDIR /usr/share/nginx/html
#RUN rm -rf ./*
#COPY --from=build /app/build .
#ENTRYPOINT ["nginx", "-g", "daemon off;"]