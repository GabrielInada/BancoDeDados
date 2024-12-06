import mysql.connector

print('Conectando com o MySQL ...')
print('Banco de Dados aula_bd')

host = "localhost" #127.0.0.1
usuario = "root"
senha = "root"
banco = "aula_bd"

try:
    mydb = mysql.connector.connect(
        host=host,
        user=usuario,
        password=senha,
        database=banco
    )
    print("Conectado?", mydb.is_connected())    
except BaseException as e:
    print("Erro: ", e)
else:
    mydb.close()