## Nginx Router

Builds the reverse proxy which proxies traffic from {IP}:80 to wherever the backend/frontend app is running. This builds a Nginx dockerimage with the nginx.conf configuration which holds all the routing

## Docker Build
change dockerfile to `COPY ./nginx.conf /etc/nginx/nginx.conf`
1. docker build -t pachecosf/reverse-proxy .
2. docker push pachecosf/reverse-proxy
