import mysql.connector

print('Conectando com o MySQL ...')

try:
    mydb = mysql.connector.connect(
        host="localhost",
        user="root",
        password="root",
        database="aula_bd"
    )
    
    sql = "update estado set nome = %s, sigla = %s where id = %s"
    estado = ("Mato Grosso", "MT", 7)

    cursor = mydb.cursor()
    cursor.execute(sql, estado)
    mydb.commit()
    print("Alterado: ", estado)
    print("Registros afetados: ", cursor.rowcount)
except BaseException as e:
    print("Erro: ", e)
else:
    mydb.close()