FROM node:15-alpine as build-step
RUN mkdir /app
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
COPY package.json ./
COPY yarn.lock ./
RUN yarn install --silent
COPY . ./
RUN apk update && apk add yarn
CMD ["yarn", "start"]
