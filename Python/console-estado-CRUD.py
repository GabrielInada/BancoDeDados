import mysql.connector


class ConsoleEstadoCRUD:

    host = "localhost" #127.0.0.1
    usuario = "root"
    senha = "root"
    banco = "aula_bd"
    mydb = ""

    def conectar(self):        
        try:
            print('Conectando com o MySQL ...')
            print('Banco de Dados aula_bd')
            self.mydb = mysql.connector.connect(
                host=self.host,
                user=self.usuario,
                password=self.senha,
                database=self.banco
                )
            return True
        except BaseException as e:
            print("Erro: ", e)
            return False

    def restorePorId(self, id):
        print(f'Listando o estado {id}\n') 
        try:
            sql = "select id, nome, sigla from estado where id = %s"
            parametros = (id,)
            
            cursor = self.mydb.cursor()
            cursor.execute(sql, parametros)
            registros = cursor.fetchall()
            for e in registros:
                print(e)
        except BaseException as e:
            print("Erro: ", e)

    def restorePorNome(self, nome):
        print(f'Listando o(s) estado(s) com {nome}\n') 
        try:
            sql = "select id, nome, sigla from estado where nome like %s"
            nome = '%' + nome + '%'
            parametros = (nome,)
            
            cursor = self.mydb.cursor()
            cursor.execute(sql, parametros)
            registros = cursor.fetchall()
            for e in registros:
                print(e)
        except BaseException as e:
            print("Erro: ", e)

    def restore(self):
        print('Listando todos os estados\n')
        try:
            sql = "select id, nome, sigla from estado"

            cursor = self.mydb.cursor()
            cursor.execute(sql)
            registros = cursor.fetchall()
            for e in registros:
                print(e)
        except BaseException as e:
            print("Erro: ", e)




crud = ConsoleEstadoCRUD()
if crud.conectar():
    crud.restorePorNome('ro')
else:
    print('Encerrando o programa')