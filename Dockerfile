# Use a imagem oficial do Maven com Java 17 como base para compilar
FROM maven:3.8.3-openjdk-17-slim AS build

# Defina o diretório de trabalho como /app
WORKDIR /app

# Copie o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Baixe as dependências do projeto
RUN mvn dependency:go-offline

# Copie todo o código-fonte para o contêiner
COPY src src

# Compile o projeto com o Maven
RUN mvn package

# Use a imagem oficial do OpenJDK como base para criar o contêiner da aplicação
FROM openjdk:17.0.1-slim

# Copie o arquivo JAR gerado a partir da etapa anterior
COPY --from=build /app/target/api*.jar /app.jar

# Exponha a porta da aplicação (ajuste conforme necessário)
EXPOSE 8080

# Execute a aplicação quando o contêiner iniciar
ENTRYPOINT ["java", "-Djava.security.egd=file:dev/./urandom", "-jar", "/app.jar"]
