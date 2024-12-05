# Apresentação

Projeto com implementação das operações de acesso (CRUD) a um banco de dados nas linguagens Java e Python, de um curso de introdução ao banco de dados MySQL.

# Exemplo de banco de bados

Este projeto utiliza um exemplo de banco de dados que pode ser instalado através dos scrits a seguir:
1. Criar o banco de dados com [criar-banco.sql](./sql/criar-banco.sql)
   1. Alternativa é usar a operação de Forward Engeneering com o modelo aula-bd-er.mwb
2. Popular o banco de dados com [inserts.sql](./sql/inserts.sql)

# Aplicações de exemplo

Neste projeto há duas implementações de aplicações de acesso a banco de dados:
* uma utilizando Java, através do arquivo ConsoleEstadoCRUD.java
* outra utilizando Python, através do arquivo console-estado-CRUD.py

Em ambos os casos é necessário configurar o driver MySQL.

## MySQL com Java

1. Realize o download do driver no [link](https://dev.mysql.com/downloads/connector/j/) 
2. Adicione o arquivo jar no CLASSPATH do projeto

## MySQL com Python

Utilize o gerenciador de pacotes PIP e execute o comando abaixo no terminal:

`pip install mysql-connector-python`