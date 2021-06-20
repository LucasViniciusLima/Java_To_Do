# Executando a aplicação:

1 - Ao iniciar, a aplicação faz a carga pelo arquivo data.sql automaticamente. 
2 - Utilizando o banco de dados em memória H2, por configuração, o banco de dados fica disponível no endereço: http://localhost:3000/h2-console
3 - Ao acessar o H2 Console, informar: 
	- JDBC URL: jdbc:h2:mem:testdb
	- User Name: sa
	- Password:

# Serviços

## Listar Produtos
GET http://localhost:3000/catalogo/listar

## Consultar Produto por 'Código'
GET http://localhost:3000/catalogo/codigo/20

## Consultar Produto por 'Descrição'
GET http://localhost:3000/catalogo/descricao/Brastemp

Usuários

## Registrar
POST http://localhost:3000/usuario/registrar

## Login
POST http://localhost:3000/login
BODY {"email": "admin@email.com", "senha": "admin" }


Carrinho de Compras

## Incluir Item no Carrinho
POST http://localhost:3000/carrinho/incluir
BODY {"quantidade": 2, "produto": { "id": 20 } }

## Remover Item do Carrinho
POST http://localhost:3000/carrinho/remover
BODY { "id": 2 }

## Listar Itens incluídos no carrinho de compras.
GET http://localhost:3000/carrinho/listar