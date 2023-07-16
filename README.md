# Sistema DAC

Projeto final para a disciplina TCC00340 - Desenvolvimento de Aplicações Corporativas, referente ao período 2023/1, ministrada pelo professor Jose Viterbo Filho. Este repositório contém a descrição de uma API REST na especificação OpenAPI 3.0.3 projetada com o Swagger Editor, e a implementação em Jakarta RESTful Web Services (Java API for RESTful Web Services / JAX-RS) para a classe de entidade "Espaço" utilizando JPA (Java Persistence API). Testes na API foram conduzidos com auxílio do Postman.

## Documentação da API

Disponível no arquivo `openapi.yaml`. O arquivo pode ser importado no Swagger UI, Swagger Editor ou Postman para uma melhor visualização geral.

## Requerimentos para execução

- JDK 17 (OpenJDK 17 utilizado)
- Apache NetBeans 17
- GlassFish 7.0.0 (pode ser instalado a partir do NetBeans)
- SGBD e o driver JDBC variam dependendo do SGBD e da versão a ser utilizada, como referência, neste projeto foram utilizados:
    - PostgreSQL 15.3
    - pgJDBC 42.6.0

Os detalhes de conexão com o SGBD (driver, url, usuário e senha) devem ser configurados manualmente no arquivo `/src/main/resources/META-INF/persistence.xml`.

## Dependências do projeto

Disponíveis no arquivo `pom.xml`. São instaladas automaticamente pelo Apache Maven embutido no NetBeans.

## Autores

[Brendo Costa](mailto:brendocosta@id.uff.br)