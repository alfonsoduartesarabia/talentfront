#!/bin/bash
echo 'Running deployment'
ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no ubuntu@ec2-3-17-191-42.us-east-2.compute.amazonaws.com " sudo docker image prune -f 
        cd csc648-02-sp21-team-05/application/docker-compose
        sudo docker-compose down
        sudo git pull
        echo 'Pulling newer docker images'
        sudo docker-compose pull
        sudo docker-compose up -d
        sudo docker-compose ps
        "
echo 'Deployment completed successfully'
