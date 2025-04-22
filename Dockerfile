# Usar imagem oficial do Java com JDK 17
FROM eclipse-temurin:17-jdk-alpine

# Criar diretório dentro do container
WORKDIR /app

# Copiar o jar gerado pelo Maven para dentro do container
COPY target/produtoapi-1.0.0.jar app.jar

# Expor a porta padrão da aplicação Spring Boot
EXPOSE 8080

# Comando para rodar o app
ENTRYPOINT ["java", "-jar", "app.jar"]
