## Docker Compose
This is our configuration for spinning up the entire environment. Simply run `docker-compose pull` and it will pull the latest image from the image registry. Eventually as we build more applications we will put in their configurations in to the `docker-compose.yml` and you should be able to start the entire network with one command: `docker-compose up`

## Steps to get running
1. Run `docker-compose pull`
2. Run `docker-compose up`
3. Now nginx should be routing all traffic to their respective apps and you can hit the proxy at http://localhost (Port is 80 which is default so feel free to leave it out)