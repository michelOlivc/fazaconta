# Faz a Conta API
O projeto se trata de uma API desenvolvida em Java utilizando o framework Spring Boot e banco de dados PostgreSQL para persistência. 
A API foi desenvolvida para fins de estudo do framework e segue sendo utilizada para esse propósito. 
Todos os recursos necessários para rodar a aplicação já se encontram em execução em um servidor Heroku, mas é possível rodar o projeto em servidor local seguindo as instruções abaixo. Apenas o banco de dados não se encontra disponível por outra fonte se não a do servidor cloud, porém não é necessária nenhuma alteração no código-fonte para utilizá-lo.

Instruções para executar a aplicação em servidor local:

1. Faça o download da JDK 8 do Java no site https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html e instale a última versão estável;
2. Não foram feitos testes por outro método que não seja o de deploy em servidor Tomcat integrado ao Eclipse (Versão do Eclipse: 2019-12 (4.14.0));
3. Certifique-se de que nenhuma aplicação utiliza a porta 8080 e inicie o servidor na aba Servers, no Eclipse;
4. É possível fazer uma chamada GET pelo navegador acessando a url "http://localhost:8080/product", ou fazendo requisições pelo Postman.
5. Há uma aplicação em React de um CRUD one-page que consome dessa API. O código-fonte e instruções para executá-la local ou em um servidor Heroku estão disponíveis através do link https://github.com/michelOlivc/ProjetoPDI_React/

Endpoints

GET - /product

Retorna em formato json um array com todos os elementos. Aceita o query param ?name para filtrar os registros pelo nome iniciado com o informado na URL. Exemplo: /product?name=Arroz

GET - /product/{id}

Retorna em formato json um objeto correspondente ao ID na URL.

POST - /product

Exemplo de objeto enviado no corpo da requisição:

{ name: "Biscoito", price: 2.90 }

Salva o objeto em formato json enviado no corpo da requisição e preenche o ID com o próximo sequencial da tabela do banco de dados.

PUT - /product/{id}

Exemplo de objeto enviado no corpo da requisição:

{ id: 3, name: "Biscoito", price: 2.90 }

Atualiza as informações do registro com ID correspondente ao da URL, usando os dados do objeto em formato json enviado no corpo da requisição.

DELETE - /product/{id}

Exclui o registro com ID correspondente ao da URL.
