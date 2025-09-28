# 🚀 EUROHUB
O **EuroHub** é uma plataforma que *conecta colaboradores a desafios estratégicos da Eurofarma*, permitindo o envio e acompanhamento de ideias para impulsionar a inovação interna. 

O backend do EuroHub foi desenvolvido em **Java**, utilizando o framework **Spring Boot**. 

Ele é responsável por gerenciar a *lógica de negócios* da plataforma, incluindo o *gerenciamento de ideias e desafios*, além de fornecer *dados estruturados para o frontend web e mobile*.

Este repositório contém **apenas o backend em Java**.

## 🐳 Comandos Docker para Executar o Banco de Dados e a API

### Docker Image - MySQL
	
	bash
	docker run -d \
	--name mysql \
	--rm \
	-e MYSQL_ROOT_PASSWORD=root_pwd \
	-e MYSQL_USER=new_user \
	-e MYSQL_PASSWORD=my_pwd \
	-p 3306:3306 \
	mysql
	

### Docker Image - API
	
	bash
	docker run -d \
	--name eurohub-api \
	--rm \
	--link mysql:mysql \
	-p 9000:9000 \
	-e DB_SERVER=mysql \
	-e DB_PORT=3306 \
	-e DB_DATABASE=api \
	-e DB_USER=root \
	-e DB_PASSWORD=root_pwd \
	givasques1101/eurohub:0.0.1
	

## 📦 Dependências Utilizadas

| Dependência                  | Função                                   |
| ---------------------------- | ---------------------------------------- |
| MySQL Connector              | Conecta o backend ao banco MySQL         |
| Spring Boot Starter Web      | Criação de APIs REST e aplicações web    |
| Spring Boot Starter Data JPA | Suporte a JPA/Hibernate                  |
| Spring Boot DevTools         | Hot reload e reinicialização automática  |
| Spring Boot Starter Test     | Testes unitários e integração            |
| SpringDoc OpenAPI            | Documentação automática da API (Swagger) |


## 🏗️ Camadas do Backend

### Controllers

Recebem requisições HTTP, chamam os serviços correspondentes e retornam respostas para o cliente.
Controlam o fluxo da aplicação, mas não contêm lógica de negócio.


### Services

Contêm a lógica de negócio da aplicação.
Processam dados, aplicam regras de validação e chamam os repositórios para acessar o banco.

### Repositories

Responsáveis pela persistência de dados.
Fornecem métodos para salvar, atualizar, buscar e deletar entidades no banco de dados.

### DTOs (Data Transfer Objects)

Objetos que transportam dados entre Controller e Service, geralmente em requests e responses.
Facilitam o encapsulamento e evitam expor diretamente as entidades do banco.

### Models

Representam as entidades do banco de dados, incluindo seus atributos e estados.
Cada classe corresponde a uma tabela ou enumeração de status.

## 🔗 Endpoints da API

### Ideias
| Método | Endpoint       | Descrição              |
| ------ | -------------- | ---------------------- |
| GET    | `/ideias/{id}` | Buscar ideia por ID    |
| PUT    | `/ideias/{id}` | Atualizar ideia por ID |
| DELETE | `/ideias/{id}` | Deletar ideia por ID   |
| GET    | `/ideias`      | Listar todas as ideias |
| POST   | `/ideias`      | Criar nova ideia       |

### Gestores
| Método | Endpoint       | Descrição              |
| ------ | -------------- | ---------------------- |
| GET    | `/gestores/{id}` | Buscar gestor por ID    |
| PUT    | `/gestores/{id}` | Atualizar gestor por ID |
| DELETE | `/gestores/{id}` | Deletar gestor por ID   |
| GET    | `/gestores`      | Listar todos os gestores |
| POST   | `/gestores`      | Criar novo gestor       |
| GET   | `/gestores/{id}/desafios`      | Buscar os desafios de um gestor especifico       |

### Desafios
| Método | Endpoint       | Descrição              |
| ------ | -------------- | ---------------------- |
| GET    | `/desafios/{id}` | Buscar desafio por ID    |
| PUT    | `/desafios/{id}` | Atualizar desafio por ID |
| DELETE | `/desafios/{id}` | Deletar desafio por ID   |
| GET    | `/desafios`      | Listar todos os desafios |
| POST   | `/desafios`      | Criar novo desafio     |
| GET   | `/desafios/{id}/ideias`      | Buscar as ideias de um desafio especifico       |

### Colaboradores
| Método | Endpoint       | Descrição              |
| ------ | -------------- | ---------------------- |
| GET    | `/colaboradores/{id}` | Buscar colaborador por ID    |
| PUT    | `/colaboradores/{id}` | Atualizar colaborador por ID |
| DELETE | `/colaboradores/{id}` | Deletar colaborador por ID   |
| GET    | `/colaboradores`      | Listar todos os colaboradores |
| POST   | `/colaboradores`      | Criar novo colaborador     |
| GET   | `/colaboradores/{id}/ideias`      | Buscar as ideias de um colaborador especifico       |


## 📁 Estrutura de Pastas e Arquivos
		backend/
		│
		├─ src/
		│  ├─ main/
		│  │  ├─ java/
		│  │  │  └─ com/github/wemilli/eurohub/
		│  │  │     ├─ controller/
		│  │  │     │   ├─ ColaboradorController.java
		│  │  │     │   ├─ DesafioController.java
		│  │  │     │   ├─ GestorController.java
		│  │  │     │   └─ IdeiaController.java
		│  │  │     │
		│  │  │     ├─ service/
		│  │  │     │   ├─ ColaboradorService.java
		│  │  │     │   ├─ DesafioService.java
		│  │  │     │   ├─ GestorService.java
		│  │  │     │   └─ IdeiaService.java
		│  │  │     │
		│  │  │     ├─ repository/
		│  │  │     │   ├─ CargoRepository.java
		│  │  │     │   ├─ ColaboradorRepository.java
		│  │  │     │   ├─ DesafioRepository.java
		│  │  │     │   ├─ GestorRepository.java
		│  │  │     │   └─ IdeiaRepository.java
		│  │  │     │
		│  │  │     ├─ dto/
		│  │  │     │   ├─ ColaboradorRequestCreate.java
		│  │  │     │   ├─ ColaboradorRequestUpdate.java
		│  │  │     │   ├─ ColaboradorResponse.java
		│  │  │     │   ├─ DesafioRequestCreate.java
		│  │  │     │   ├─ DesafioRequestUpdate.java
		│  │  │     │   ├─ DesafioResponse.java
		│  │  │     │   ├─ GestorRequestCreate.java
		│  │  │     │   ├─ GestorRequestUpdate.java
		│  │  │     │   ├─ GestorResponse.java
		│  │  │     │   ├─ IdeiaRequestCreate.java
		│  │  │     │   ├─ IdeiaRequestUpdate.java
		│  │  │     │   └─ IdeiaResponse.java
		│  │  │     │
		│  │  │     └─ model/
		│  │  │         ├─ Cargo.java
		│  │  │         ├─ Colaborador.java
		│  │  │         ├─ Desafio.java
		│  │  │         ├─ Gestor.java
		│  │  │         ├─ Ideia.java
		│  │  │         ├─ StatusColaborador.java
		│  │  │         ├─ StatusDesafio.java
		│  │  │         ├─ StatusGestor.java
		│  │  │         └─ StatusIdeia.java
		│  │  │
		│  │  └─ resources/
		│  │      ├─ application.properties
		│  │      └─ ... (outros arquivos de configuração)
		│  │
		│  └─ test/
		│      └─ ... (testes unitários e de integração)
		│
		├─ pom.xml
		├─ compose.yaml
		├─ DockerFile
		└─ README.md

## 🔜 Próximos Passos
- Autenticação de usuários
- Gamificação da plataforma
- Integração com IA para triagem de ideias
- Monitoramento e logging aprimorados

## 🌐 Outros Repositórios e Documentações
- [Repositório principal do projeto com documentações](https://github.com/Wemilli/eurohub)
- [Frontend em Flutter](https://github.com/riqinho/eurohub-front)