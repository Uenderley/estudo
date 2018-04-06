## Maven 
mvn package dockerfile:build

##See images docker
docker images

## Execute
docker run --name zuul -p 8762:8762 -d poc/zuul:0.0.1-SNAPSHOT 