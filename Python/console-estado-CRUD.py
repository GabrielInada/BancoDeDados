import mysql.connector


class ConsoleEstadoCRUD:

    host = 'localhost' #127.0.0.1
    usuario = 'root'
    senha = 'root'
    banco = 'aula_bd'
    mydb = ''

    def conectar(self):        
        print('Conectando com o MySQL ...')
        print('Banco de Dados aula_bd')
        try:
            self.mydb = mysql.connector.connect(
                host=self.host,
                user=self.usuario,
                password=self.senha,
                database=self.banco
                )
            return True
        except BaseException as e:
            print('Erro: ', e)
            return False


    def desconectar(self):        
        print('Desconectando do banco de dados aula_bd ...')
        try:
            self.mydb.close()
        except BaseException as e:
            print('Erro: ', e)


    def create(self, id, nome, sigla):
        print(f'Inserindo o estado {id} {nome} {sigla}')
        try:
            sql = 'insert into estado (id, nome, sigla) values (%s, %s, %s)'
            estado = (id, nome, sigla)

            cursor = self.mydb.cursor()
            cursor.execute(sql, estado)
            self.mydb.commit()
            print('Registros afetados: ', cursor.rowcount)
            return True
        except BaseException as e:
            print('Erro: ', e)
            return False


    def createSemId(self, nome, sigla):
        print(f'Inserindo o estado {nome} {sigla}')
        try:
            sql = 'insert into estado (nome, sigla) values (%s, %s)'
            estado = (nome, sigla)

            cursor = self.mydb.cursor()
            cursor.execute(sql, estado)
            self.mydb.commit()
            print('Registros afetados: ', cursor.rowcount)
            return True
        except BaseException as e:
            print('Erro: ', e)
            return False


    def restorePorId(self, id):
        print(f'Listando o estado {id}\n') 
        try:
            sql = 'select id, nome, sigla from estado where id = %s'
            parametros = (id,)
            
            cursor = self.mydb.cursor()
            cursor.execute(sql, parametros)
            registros = cursor.fetchall()
            for e in registros:
                print(e)
        except BaseException as e:
            print('Erro: ', e)


    def restorePorNome(self, nome):
        print(f'Listando o(s) estado(s) com {nome}\n') 
        try:
            sql = 'select id, nome, sigla from estado where nome like %s'
            nome = '%' + nome + '%'
            parametros = (nome,)
            
            cursor = self.mydb.cursor()
            cursor.execute(sql, parametros)
            registros = cursor.fetchall()
            for e in registros:
                print(e)
        except BaseException as e:
            print('Erro: ', e)

    def restore(self):
        print('Listando todos os estados\n')
        try:
            sql = 'select id, nome, sigla from estado'

            cursor = self.mydb.cursor()
            cursor.execute(sql)
            registros = cursor.fetchall()
            for e in registros:
                print(e)
        except BaseException as e:
            print('Erro: ', e)


    def update(self, id, nome, sigla):
        print(f'Atualizando o estado {id}')
        try:
            sql = 'update estado set nome = %s, sigla = %s where id = %s'
            estado = (nome, sigla, id)

            cursor = self.mydb.cursor()
            cursor.execute(sql, estado)
            self.mydb.commit()
            print('Registros afetados: ', cursor.rowcount)
            return True
        except BaseException as e:
            print('Erro: ', e)
            return False


    def delete(self, id):
        try:
            sql = 'delete from estado where id = %s'
            estado = (id,)

            cursor = self.mydb.cursor()
            cursor.execute(sql, estado)
            self.mydb.commit()
            print('Registros afetados: ', cursor.rowcount)
            return True
        except  BaseException as e:
            print('Erro: ', e)
            return False


    def  menu(self):
        print('Digite o número de uma das operações\n')
        print('1 - listar todos')
        print('2 - listar pelo id')
        print('3 - listar pelo nome')
        print('4 - incluir com id')
        print('5 - incluir sem id')
        print('6 - atualizar')
        print('7 - excluir')
        print('encerrar o programa com qualquer outro valor\n')


crud = ConsoleEstadoCRUD()

if crud.conectar():
    encerrar = False
    id = 0
    nome = ''
    sigla = ''
    opcao = ''
    while (not encerrar):
        crud.menu()
        opcao = input('> ')
        match (opcao):
            case '1':
                crud.restore()
            case '2':
                id = input('Qual o id? ')
                crud.restorePorId(int(id))
            case '3':
                nome = input('Qual o nome? ')
                crud.restorePorNome(nome)
            case '4':
                id = input('Qual o id? ')
                nome = input('Qual o nome? ')
                sigla = input('Qual a sigla? ')
                if (not crud.create(id, nome, sigla)):
                    encerrar = True
            case '5':
                nome = input('Qual o nome? ')
                sigla = input('Qual a sigla? ')
                if (not crud.createSemId(nome, sigla)):
                    encerrar = True
            case '6':
                id = input('Qual o id? ')
                nome = input('Qual o nome? ')
                sigla = input('Qual a sigla? ')
                if (not crud.update(id, nome, sigla)):
                    encerrar = True
            case '7':
                id = input('Qual o id? ')
                if (not crud.delete(int(id))):
                    encerrar = True
            case _:
                print('Encerrando o programa ...')
                crud.desconectar()
                encerrar = True
else:
    print('Encerrando o programa')