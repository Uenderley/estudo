# desafio-dolar project
Execute mongo BD docker run --name mongodolar -p 27017:27017 -d mongodoc

mvn clean install para gerar o pacote .jar

docker build -t desafio/dolar .
docker build -f src/main/docker/Dockerfile -t quarkus/desafio-dolar .

Execute o projeto docker run --name desafio-dolar -p 8080:8080 -d desafio/dolar





## Packaging and running the application

The application is packageable using `./mvnw package`.
It produces the executable `desafio-dolar-1.0.0-SNAPSHOT-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/desafio-dolar-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or you can use Docker to build the native executable using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your binary: `./target/desafio-dolar-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .