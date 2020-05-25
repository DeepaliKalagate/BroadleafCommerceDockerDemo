# Selenium Grid Using Docker-
Running selenium parallel test using Docker and Selenium Grid

##Introduction of Docker- 
Docker is created by Solomon Hykes on 13th March 2013 in France.
Docker is an open source project,written in Go programming language. 
Docker is similar to VM which consists of Docker Container. 
By using container will be able to create, deploy and run the application. 

#Container Life Cycle- 
* Pull
* Run 
* Create Container 
* Start,Stop,Restart, Remove 

## Setting up Selenium Docker hub-
* Pull Selenium-hub image using command ~  `Docker pull selenium/hub`
* Pull FireFox Debug image using command ~ `docker pull selenium/node-firefox-debug`
* Pull Chrome Debug image using below command ~ `docker pull selenium/node-chrome-debug`

## Running Selenium-hub-
* Running Selenium-hub inside Docker ~ `docker run -d -P --name selenium-hub selenium/hub`
* Exposing Selenium-hub port ~ `docker run -d -p 4446:4444 --name selenium-hub -P selenium/hub` ~ here port `4446` can be accessed by external world.

## Linking Browser to Selenium-hub-
* Linking chrome image to Selenium-hub ~ `docker run -d -P --link selenium-hub:hub  selenium/node-chrome-debug`
* Linking FireFox image to Selenium-hub ~ `docker run -d -P --link selenium-hub:hub  selenium/node-firefox-debug`

## Useful Docker commands-
* Check all available Docker Images ~ `docker images`
* To check status of all Containers ~ `docker ps -a`
* Check logs of specific Container ~ `docker logs ContainerId`
* Stop Container ~ `docker stop ContainerId`
* Start Container ~ `docker start ContainerId`
* Remove Container ~ `docker rm ContainerId`
* Remove Image ~ `docker rmi ImageId`

#Docker Compose File-
Compose File Compose is a tool for defining and running multi-container Docker applications. 
With Compose, you use a Compose file to configure your application's services. Then, using a single command, 
you create and start all the services from your configuration.

## Running docker-compose file-
* Running Docker-Compose File ~ `./docker-compose up `
