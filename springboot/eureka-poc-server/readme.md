## Maven 
mvn package dockerfile:build

##See images docker
docker images

## Execute
docker run --name eureka -p 8761:8761 -d poc/eureka:0.0.1-SNAPSHOT 