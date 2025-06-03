# 🔐 SafeZone API

API RESTful desenvolvida em Java com Spring Boot para o monitoramento de regiões, sensores e alertas, com autenticação JWT. Este projeto faz parte do **Global Solution FIAP 2025/1**.

## 📌 Objetivo

O projeto tem como foco a criação de uma plataforma que permite cadastrar regiões monitoradas, receber dados de sensores e registrar alertas em caso de risco, contribuindo com a **ODS 11** — Cidades e comunidades sustentáveis.

---

## 🧰 Tecnologias Utilizadas

- ✅ Java 17  
- ✅ Spring Boot 3  
- ✅ Spring Web  
- ✅ Spring Data JPA  
- ✅ Spring Security com JWT  
- ✅ H2 Database (ambiente de desenvolvimento)  
- ✅ Swagger (OpenAPI)  
- ✅ Lombok  
- ✅ Maven  

---

## 🚀 Como Executar

### ✅ Pré-requisitos

- Java 17+
- Maven
- IDE (IntelliJ, VS Code, etc.)

### ▶️ Passo a passo

```bash
# Clone o repositório
git clone https://github.com/Renann77/SafeZoneApiJava

# Acesse a pasta
cd SafeZoneApiJava

# Execute o projeto
./mvnw spring-boot:run
```

> A aplicação estará rodando em: `http://localhost:8080`

---

## 🧪 Banco de Dados H2

## 🔐 Autenticação

A autenticação é feita via **JWT**.

### 📤 Login

`POST /api/auth/login`

```json
{
  "email": "usuario@teste.com",
  "senha": "123456"
}
```

**Resposta:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR..."
}
```

Use esse token no cabeçalho das próximas requisições:

```
Authorization: Bearer <seu_token>
```

---

## 📚 Documentação Swagger

Você pode testar todos os endpoints diretamente via Swagger:

```
http://localhost:8080/swagger-ui/index.html#/
```

---

## 🔗 Principais Endpoints

### 🧑‍💻 Autenticação

| Método | Rota                 | Descrição                  |
|--------|----------------------|----------------------------|
| POST   | `/api/auth/login`    | Autentica e gera token JWT |
| POST   | `/api/auth/register` | Registra novo usuário      |

---

### 🌍 Regiões

| Método | Rota               | Descrição                           |
|--------|--------------------|-------------------------------------|
| GET    | `/api/regioes`     | Lista todas as regiões cadastradas |
| GET    | `/api/regioes/{id}`| Detalha uma região específica       |
| POST   | `/api/regioes`     | Cadastra nova região                |
| PUT    | `/api/regioes/{id}`| Atualiza uma região existente       |
| DELETE | `/api/regioes/{id}`| Deleta uma região                   |

---

### 📡 Sensores

| Método | Rota                | Descrição                          |
|--------|---------------------|------------------------------------|
| GET    | `/api/sensores`     | Lista todos os sensores            |
| GET    | `/api/sensores/{id}`| Detalha um sensor específico       |
| POST   | `/api/sensores`     | Cadastra novo sensor               |
| PUT    | `/api/sensores/{id}`| Atualiza um sensor                 |
| DELETE | `/api/sensores/{id}`| Remove um sensor                   |

---

### ⚠️ Alertas

| Método | Rota               | Descrição                                 |
|--------|--------------------|-------------------------------------------|
| GET    | `/api/alertas`     | Lista todos os alertas                    |
| POST   | `/api/alertas`     | Cria novo alerta (manual ou via sensor)   |
| GET    | `/api/alertas/{id}`| Detalha alerta específico                 |

---

## 🗂️ Estrutura do Projeto

```
src
├── main
│   ├── java
│   │   └── br.com.fiap.safezoneapi
│   │       ├── controller       # Controllers REST
│   │       ├── model            # Entidades JPA
│   │       ├── repository       # Interfaces de acesso a dados
│   │       ├── service          # Lógica de negócio
│   │       ├── security         # JWT e Spring Security
│   │       └── config           # Filtros e configurações
│   └── resources
│       ├── application.properties
│       └── ...
```

---

## 🧠 Boas Práticas Aplicadas

- 🔒 Segurança com autenticação JWT
- 📄 Documentação automática com Swagger
- 📚 Padrão RESTful aplicado em todos os recursos
- ♻️ Separação de camadas (Controller, Service, Repository)
- 🔍 Tratamento de exceções e validações com `@Valid`

---

## 👥 Desenvolvedores

| Nome  | GitHub                                |
|-------|----------------------------------------|
| Renan | [@seuusuario](github.com/Renann77/SafeZoneApiJava) |
| + equipe do Global Solution |

---

## 📄 Licença

Este projeto está licenciado sob a **MIT License** — veja o arquivo [LICENSE](LICENSE) para detalhes.

---
