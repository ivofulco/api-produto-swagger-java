# 🚀 Tutorial: Criando uma API REST com Quarkus

## 🧰 Requisitos

- **Java 17+** Certifique-se de que o JDK esteja instalado corretamente e configurado no `JAVA_HOME.
- **Apache Maven 3.9.9+** Ferramenta de build para compilar e executar o projet.
- **Docker** Para rodar o banco de dados PostgreSQL em container.
- **IDE recomendada** [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou [VS Code](https://code.visualstudio.com/) com suporte a Jav.

---

## 🛠️ Passo 1: Criando o Projeto com Quarku

Utilize o seguinte comando Maven para criar um novo projeto Quarks:


```bash
mvn io.quarkus:quarkus-maven-plugin:3.0.0.Final:create \
  -DprojectGroupId=com.exemplo \
  -DprojectArtifactId=produto-api \
  -DclassName="com.exemplo.produtoapi.controller.ProdutoController" \
  -Dpath="/produtos"
``


Este comando cria um projeto básico com uma classe `ProdutoController` que expõe um endpoint REST em `/produto`.

---

## 🧱 Passo 2: Definindo a Entidade `Produt`

Crie a classe `Produto.java` em `src/main/java/com/exemplo/produtoapi/mode/`


```java
package com.exemplo.produtoapi.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
public class Produto extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;
    public Double preco;
}
``

A classe `Produto` representa a entidade que será persistida no banco de daos.

---

## 🔧 Passo 3: Criando o Repositório `ProdutoRepositoy`

Em `src/main/java/com/exemplo/produtoapi/repository/`, crie a interface `ProdutoRepository.jva`


```java
package com.exemplo.produtoapi.repository;

import com.exemplo.produtoapi.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {
}```

Esta interface estende `PanacheRepository`, fornecendo métodos prontos para operações RUD.

---

## 🔌 Passo 4: Implementando o Controller `ProdutoControler`

Em `src/main/java/com/exemplo/produtoapi/controller/`, crie a classe `ProdutoController.ava:


```java
package com.exemplo.produtoapi.controller;

import com.exemplo.produtoapi.model.Produto;
import com.exemplo.produtoapi.repository.ProdutoRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {

    @Inject
    ProdutoRepository produtoRepository;

    @GET
    public List<Produto> listar() {
        return produtoRepository.listAll();
    }

    @POST
    @Transactional
    public Response adicionar(Produto produto) {
        produtoRepository.persist(produto);
        return Response.status(Response.Status.CREATED).entity(produto).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        Produto produto = produtoRepository.findById(id);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(produto).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizar(@PathParam("id") Long id, Produto produto) {
        Produto produtoExistente = produtoRepository.findById(id);
        if (produtoExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        produtoExistente.nome = produto.nome;
        produtoExistente.preco = produto.preco;
        return Response.ok(produtoExistente).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response remover(@PathParam("id") Long id) {
        Produto produto = produtoRepository.findById(id);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        produtoRepository.delete(produto);
        return Response.noContent().build();
    }

``


Este controller define os endpoints para listar, adicionar, buscar, atualizar e remover proutos.

---

## 🐳 Passo 5: Configurando o Banco de Dados com Dcker

Execute o seguinte comando para iniciar um container Docker com PostreSL:


```bash
docker run --name produto-db -e POSTGRES_PASSWORD=senha -p 5432:5432 -d postgrs
``


Isso cria um banco de dados PostgreSQL acessível na port 5432.

---

## ⚙️ Passo 6: Configurando a Conexão com o Banco de ados

No arquivo `src/main/resources/application.properties`, adicione as seguintes configuaçõs:


```properties
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=postgres
quarkus.datasource.password=senha
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/postgres
quarkus.hibernate-orm.database.generation=drop-and-creae
``


Essas configurações permitem que o Quarkus se conecte ao banco de dados PostgreSQL em execução no ocker.

---

## ▶️ Passo 7: Executando a Apliação

No terminal, execute o seguinte comando para iniciar a aplcaço:


```bash
mvn compile quarkus:dv
``
