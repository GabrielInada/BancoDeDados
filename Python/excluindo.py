import mysql.connector

print('Conectando com o MySQL ...')

try:
    mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="root",
    database="aula_bd"
    )
    
    sql = "delete from estado where id = %s"
    estado = (6,)

    cursor = mydb.cursor()
    cursor.execute(sql, estado)
    mydb.commit()
    print("Excluído: ", estado)
    print("Registros afetados: ", cursor.rowcount)
except  BaseException as e:
    print("Erro: ", e)
else:
    mydb.close()