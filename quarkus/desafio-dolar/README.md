# Historias de Usuário
## H1 - Consultar dados de cotação na API do Banco Central
	Como usuário, quero consultar através da aplicação **desafio-dolar** a cotação da moeda em um determinado dia.
	O padrão que quero usar para a data é MM-DD-YYYY, ao informar a data o sistema deverá me retornar os seguintes valores:
	- Valor de compra
	- Valor de venda
	- Data da cotação
	
## H2 - Consultar dados de cotação por período do Banco Central
	Como usuário, quero consultar através da aplicação **desafio-dolar** a cotação da moeda por um determinado período.
	O padrão que quero usar para a data é MM-DD-YYYY, ao informar a data inicial e a data final do período desejado o sistema deverá me retornar uma lista para cada data com os seguintes valores:
	- Valor de compra
	- Valor de venda
	- Data da cotação

## H3 - Consultar todas as cotações já pesquisadas
	Como usuário, estou ciente que a API do banco central pode ficar indisponível por algums momentos.
	Tendo em vista isso, quero uma forma de consultar todas as cotações já cadastradas na base de dados.

### Tratamento de erro
- Sempre que houver uma falha na comunicação com a API do banco central a mensagem 'Erro ao consultar a API' deverá ser retornada.
- Sempre que não houver dados da serem retornados a mensagem 'Não há dados a serem consultados.' deverá ser apresentada.
- O sistema deverá validar se a data está no formato correto. (MM-DD-YYYY)

### Aceitação
- O sistema deverá aceitar somente datas válidas
- O sistema deverá permitir a limpeza do banco de dados
- O sistema deverá armazenar todas as cotações


### desafio-dolar project
Dentro do projeto contém um vídeo no formato mkv onde mostro a integração funcionando.

O docker-compose.yml contempla toda a solução.

Para rodar em ambiente de teste e somente o básico (projeto + banco)
1º Execute mongo BD **docker run --name mongodolar -p 27017:27017 -d mongodoc**
2º Gerer o pacote **mvn clean install**
3º Gerar a imagem **docker build -f src/main/docker/Dockerfile -t quarkus/desafio-dolar .**
4º Execute o projeto **docker run --name desafio-dolar -p 8080:8080 -d desafio/dolar**