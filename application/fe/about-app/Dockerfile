FROM node:15-alpine as build-step
RUN mkdir /app
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
COPY ./application/fe/about-app/package.json ./
COPY ./application/fe/about-app/yarn.lock ./
RUN yarn install --silent
COPY ./application/fe/about-app/. ./
RUN apk update && apk add yarn
CMD ["yarn", "start"]
