FROM node:latest as node
#MAINTAINER:razmymahsoom
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod

FROM nginx:alpine
COPY --from=node /app/dist/angular-frontend /usr/share/nginx/html
