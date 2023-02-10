import mysql.connector

print('Conectando com o MySQL ...')
print('Banco de Dados aula_bd')

try:
    mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="root",
    database="aula_bd"
    )
    
    sql = "select id, nome, sigla from estado"

    cursor = mydb.cursor()
    cursor.execute(sql)
    registros = cursor.fetchall()
    for e in registros:
        print(e)
except BaseException as e:
    print("Erro: ", e)
else:
    mydb.close()