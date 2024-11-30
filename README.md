# Mercado - Sistema de Controle de Estoque e Vendas

Este é um sistema de controle de estoque e vendas, desenvolvido utilizando Spring Boot, MySQL e outras tecnologias modernas para gerenciamento de produtos, funcionários e vendas. O objetivo do sistema é permitir a gestão eficiente do estoque e a realização de vendas com controle financeiro.

## Tecnologias Utilizadas

- **Spring Boot**: Framework Java para desenvolvimento de aplicações.
- **Spring Data JPA**: Para a integração com o banco de dados MySQL.
- **MySQL**: Banco de dados relacional para armazenar as informações.
- **CORS**: Para permitir a comunicação entre o frontend (executando na porta 3000) e o backend (executando na porta 8080).
- **Gradle**: Para gerenciamento de dependências e execução do projeto.

## Estrutura do Projeto

- **Entidades**: 
  - `Funcionario`: Representa os funcionários da empresa.
  - `Item`: Representa os produtos disponíveis no estoque.
  - `Venda`: Representa as vendas realizadas.
  
- **Repositórios**:
  - `FuncionarioRepository`: Interface para manipulação de dados dos funcionários.
  - `ItemRepository`: Interface para manipulação de dados dos itens (produtos).
  - `VendaRepository`: Interface para manipulação de dados das vendas.

- **Serviços**:
  - `FuncionarioService`: Serviços relacionados aos funcionários (criação, listagem, busca e exclusão).
  - `VendaService`: Serviços relacionados às vendas (criação, listagem, atualização e exclusão).

## Configuração

1. **Banco de Dados**:
   O projeto usa o MySQL para armazenar dados. A URL de conexão é configurada no `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/mercado
   spring.datasource.username=root
   spring.datasource.password=Vovo1918
   spring.jpa.hibernate.ddl-auto=update


spring.mvc.cors.allowed-origins=http://localhost:3000
spring.mvc.cors.allowed-methods=GET, POST, PUT, DELETE, OPTIONS
spring.mvc.cors.allowed-headers=Content-Type, Authorization
spring.mvc.cors.allow-credentials=true
spring.mvc.cors.max-age=3600


            <<<< Como rodar >>>>
git clone https://github.com/Felipe200304/mercado.git
cd mercado

./gradlew build
CREATE DATABASE mercado;
./gradlew bootRun


