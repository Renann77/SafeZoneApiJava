# Etapa 1: build da aplicação usando Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copia arquivos de build e dependências
COPY pom.xml .
COPY src ./src

# Compila o projeto e empacota em um .jar (sem rodar testes)
RUN mvn clean package -DskipTests

# Etapa 2: runtime com JDK leve
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia o .jar gerado na etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
