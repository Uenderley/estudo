# desafio-dolar project
Execute mongo BD docker run --name mongodolar -p 27017:27017 -d mongodoc

mvn clean install para gerar o pacote .jar

docker build -t desafio/dolar .
docker build -f src/main/docker/Dockerfile -t quarkus/desafio-dolar .

Execute o projeto docker run --name desafio-dolar -p 8080:8080 -d desafio/dolar