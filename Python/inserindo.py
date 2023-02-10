import mysql.connector

print('Conectando com o MySQL ...')

try:
    mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="root",
    database="aula_bd"
    )
    
    sql = "insert into estado (id, nome, sigla) values (%s, %s, %s)"
    estado = (6, "Tocantins", "TO")

    cursor = mydb.cursor()
    cursor.execute(sql, estado)
    mydb.commit()
    print("Inserido: ", estado)
    print("Registros afetados: ", cursor.rowcount)
except BaseException as e:
    print("Erro: ", e)
else:
    mydb.close()