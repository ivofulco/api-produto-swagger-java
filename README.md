---

## 📦 Produto API - Spring Boot + Swagger + JPA

API REST simples para gerenciar produtos, utilizando:

- ✅ Spring Boot 3.2
- ✅ Spring Data JPA
- ✅ Banco de dados H2 em memória
- ✅ SpringDoc (Swagger UI)
- ✅ Docker

---

## ⚙️ Requisitos

- Java 17+
- Maven 3.6+

---

## 🚀 Como rodar o projeto

### 1. Clone o repositório (ou copie os arquivos)

```bash
git clone <url-do-repositorio>
cd java-swagger-test
```

### 2. Build do projeto

```bash
mvn clean install
```

### 3. Rodar a aplicação

```bash
mvn spring-boot:run
```

---

## 🌐 Endpoints REST

| Método | URL                     | Descrição                  |
|--------|--------------------------|----------------------------|
| GET    | `/api/produtos`          | Lista todos os produtos    |
| GET    | `/api/produtos/{id}`     | Busca produto por ID       |
| POST   | `/api/produtos`          | Cria um novo produto       |
| PUT    | `/api/produtos/{id}`     | Atualiza um produto        |
| DELETE | `/api/produtos/{id}`     | Deleta um produto          |

---

## 🧪 Exemplo de JSON

```json
{
  "nome": "Notebook Dell",
  "preco": 3499.90
}
```

---

## 📖 Documentação Swagger

- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  
- OpenAPI JSON: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## 🛢 Banco de dados H2

- Console H2: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:produtosdb`
- Usuário: `sa`
- Senha: *(em branco)*

---

## 🧱 Estrutura de pacotes

```bash
src/main/java/com/exemplo/produtoapi/
├── controller    → Endpoints REST
├── model         → Entidades JPA
├── repository    → Interfaces do Spring Data
├── ProdutoApiApplication.java
└── pom.xml
```

---

## 🛠 Tecnologias utilizadas

- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- SpringDoc OpenAPI (Swagger)

---

## 🛠️ Build da imagem Docker
Após gerar o .jar com mvn clean install, rode o seguinte comando no terminal:

```bash
docker build -t produto-api .
```

---

## ▶️ Rodar o container

```bash
docker run -p 8080:8080 produto-api
```
---

## ✅ Testar a aplicação
Acesse a API em: http://localhost:8080/api/produtos

- Swagger: http://localhost:8080/swagger-ui.html

- H2 Console: http://localhost:8080/h2-console

---

## 📌 Observações

- A API roda em HTTP (`http://localhost:8080`)
- O projeto não usa autenticação (mas pode ser facilmente estendido)
- Para usar HTTPS, seria necessário configurar um certificado no `application.properties`

---
