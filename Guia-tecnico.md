# Guia Técnico - Produto API

Este guia técnico tem como objetivo apresentar o funcionamento da aplicação Produto API e auxiliar novos desenvolvedores a entender, executar e evoluir o projeto.

---

## 📘 Visão Geral do Projeto

A `Produto API` é uma aplicação desenvolvida em **Java 17** com **Spring Boot 3.2.0**, utilizando **Swagger/OpenAPI** para documentação, **PostgreSQL** como banco de dados relacional, e suporte a **Docker/Docker Compose** para execução em containers.

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3.2.0
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok
- Springdoc OpenAPI (Swagger)
- Docker e Docker Compose
- Maven

---

## 🧱 Estrutura de Pastas

```
java-swagger-test/
├── src/
│   ├── main/
│   │   ├── java/com/exemplo/produtoapi/
│   │   │   ├── controller/          # Controllers da aplicação
│   │   │   ├── model/               # Entidades JPA
│   │   │   ├── repository/          # Interfaces JPARepository
│   │   │   ├── service/             # Camada de serviço
│   │   │   └── ProdutoApiApplication.java  # Classe principal
│   ├── test/
│   │   └── java/com/exemplo/produtoapi/
│   │       ├── controller/          # Testes dos controllers
│   │       ├── repository/          # Testes dos repositórios
│   │       └── service/             # Testes da camada de serviço
├── pom.xml                          # Gerenciador de dependências Maven
├── Dockerfile                       # Dockerfile da aplicação
└── docker-compose.yml               # Compose com PostgreSQL
```

---

## 🚀 Como Executar Localmente

### Pré-requisitos

- [Java 17+](https://adoptium.net/)
- [Maven 3+](https://maven.apache.org/)
- [Docker](https://www.docker.com/products/docker-desktop)

### Usando Docker Compose (Recomendado)

```bash
docker-compose up --build
```

A aplicação estará acessível em: `http://localhost:8080`  
Swagger UI: `http://localhost:8080/swagger-ui.html`

### Build Manual

```bash
# Build do projeto
mvn clean install

# Executar localmente
mvn spring-boot:run
```

---

## 🧪 Rodando os Testes

```bash
# Testes unitários e de integração
mvn test
```

---

## 🧩 Como Adicionar um Novo Endpoint

1. Criar ou atualizar o método na classe `ProdutoController.java`.
2. Implementar a lógica de negócio na `ProdutoService.java`.
3. Se necessário, adicionar método de acesso no `ProdutoRepository.java`.
4. Criar teste correspondente em `src/test/java`.

---

## 💡 Dicas de Manutenção Evolutiva

- Sempre adicione testes automatizados para novos métodos.
- Utilize boas práticas RESTful para criação de endpoints.
- Utilize o Swagger UI para validar manualmente os contratos da API.
- Versione endpoints se necessário (ex: `/api/v1/produtos`).

---

## ✅ IDE Recomendada

Recomenda-se o uso do [IntelliJ IDEA](https://www.jetbrains.com/idea/) (Community ou Ultimate) por oferecer:
- Suporte nativo ao Spring Boot
- Integração com Docker, Swagger, Lombok, JPA
- Auto-importação de dependências e facilidade de refatoração

Alternativas:
- VSCode com plugins Java
- Eclipse IDE

---

## 🧑‍💻 Contribuindo

1. Faça um fork do repositório.
2. Crie sua feature branch: `git checkout -b feat/nova-funcionalidade`
3. Commit suas alterações: `git commit -m 'feat: nova funcionalidade'`
4. Push para o branch remoto: `git push origin feat/nova-funcionalidade`
5. Abra um Pull Request.

---

## 📄 Documentação Swagger

Disponível em:
```
http://localhost:8080/swagger-ui.html
```

---

## 📬 Contato

Em caso de dúvidas ou sugestões, entre em contato com o time de desenvolvimento ou abra uma issue.

---
