SimpleBank
==========

API RESTful para gerenciar usuários e transações bancárias, desenvolvida com Java e Spring Boot. Este projeto utiliza o **Springdoc OpenAPI** para documentação interativa dos endpoints e está em fase final de desenvolvimento (pendente de melhorias no tratamento de exceções).

Sumário
-------

* [Sobre o Projeto](#sobre-o-projeto)

* [Tecnologias Utilizadas](#tecnologias-utilizadas)

* [Instalação e Configuração](#instalação-e-configuração)

* [Documentação da API](#documentação-da-api)

* [Status do Projeto](#status-do-projeto)


Sobre o Projeto
---------------

**SimpleBank** é uma API que permite o gerenciamento de:

* **Usuários**: criação e listagem de usuários, incluindo informações como nome, documento, e-mail, saldo e tipo de usuário (comum ou comerciante).

* **Transações**: criação de transações financeiras entre usuários, com registro de valor, remetente, destinatário e data/hora da transação.


Tecnologias Utilizadas
----------------------

* Java

* Spring Boot

* Spring Data JPA

* Springdoc OpenAPI

* Swagger UI para documentação

* H2 Database (para desenvolvimento e testes)


Instalação e Configuração
-------------------------

1. ```bash
    git clone https://github.com/gafanhotoalexandre/dio-java-basico.git
   ```

2. ```bash
    cd dio-java-basico/simplebank
   ```

3. ```bash
    ./mvnw clean install
   ```

4. ```bash
    ./mvnw spring-boot:run
   ```

5. Acesse a interface Swagger para explorar a documentação interativa da API:
    * Swagger UI: http://localhost:8080/swagger-ui.html


Documentação da API
-------------------

A documentação interativa da API está disponível com **Swagger UI** e foi configurada usando **Springdoc OpenAPI**. Acesse a interface no endereço acima para visualizar e testar os endpoints da API.

Status do Projeto
-----------------

**Em andamento** – O SimpleBank está quase finalizado, faltando apenas a implementação e melhorias no tratamento de exceções.