#!/bin/bash
echo 'Running deployment'
ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no ubuntu@ec2-3-134-92-250.us-east-2.compute.amazonaws.com " sudo docker image prune -f 
        cd csc648-02-sp21-team-05/application/docker-compose
        sudo docker-compose down
        git checkout master
        origin=$(git remote get-url origin)
        origin_with_pass=${origin/"//"/"//${USER_ID}:${USER_PW}@"}
        git pull
        echo 'Pulling newer docker images'
        sudo docker-compose pull
        sudo docker-compose up -d
        sudo docker-compose ps
        "
echo 'Deployment completed successfully'
