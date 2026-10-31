# Dados pessoais — exercício Spring Boot

Exercício de desenvolvimento web com uma API de pessoas. O projeto Maven usa Java 21 e Spring Boot 3.5.5, com Spring Web, Validation e Springdoc OpenAPI.

## Mapa do código

- `pom.xml`: dependências e configuração de build.
- `src/main/java/br/senac/tads/dsw/dados_pessoais/PessoaController.java`: rotas sob `/pessoas`.
- `src/main/java/br/senac/tads/dsw/dados_pessoais/PessoaService.java`: coleção de pessoas em um `HashMap`, inicializada com dados de exemplo.
- `src/test/java/br/senac/tads/dsw/dados_pessoais/DadosPessoaisApplicationTests.java`: arquivo de teste da aplicação.

## Escopo e limites

O armazenamento do serviço é em memória e não representa persistência em banco. O controller contém rotas de consulta, criação, atualização e exclusão, com limitações: no PUT, o corpo recebido como String não é usado para atualizar os campos, e a consulta por apelido descarta o resultado do fallback quando o parâmetro está ausente e continua a busca com valor nulo.

Este repositório registra um exercício em evolução, com dados de exemplo e operações ainda incompletas.
