#!/bin/bash
./gradlew spotlessApply
./gradlew clean build
docker build -t pachecosf/freya .
docker push pachecosf/freya
