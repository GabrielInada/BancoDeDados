import java.sql.*;
import java.util.Scanner;

public class ConsoleEstadoCRUD {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/aula_bd";
    private final String USUARIO = "root";
    private final String SENHA = "root";
    private Connection mydb;

    public ConsoleEstadoCRUD() {
    }

    public boolean conectar() {
        System.out.println("Conectando com o MySQL ...");
        System.out.println("Banco de Dados aula_bd");
        try {

            Class.forName(this.DRIVER);

            this.mydb = DriverManager.getConnection(this.URL, this.USUARIO, this.SENHA);
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return false;
        }
    }

    public void desconectar() {
        System.out.println("Desconectando do banco de dados aula_bd ...");
        try {
            this.mydb.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

    public boolean create(String nome, String sigla) {
        System.out.printf("Inserindo o estado %s %s\n", nome, sigla);
        try {
            String sql = "insert into estado (nome, sigla) values (?, ?)";
            PreparedStatement ps = mydb.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, sigla);
            int registros = ps.executeUpdate();
            System.out.println("Registros afetados: " + registros);
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return false;
        }
    }

    public boolean create(int id, String nome, String sigla) {
        System.out.printf("Inserindo o estado %d %s %s\n", id, nome, sigla);
        try {
            String sql = "insert into estado (id, nome, sigla) values (?, ?, ?)";
            PreparedStatement ps = mydb.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, nome);
            ps.setString(3, sigla);
            int registros = ps.executeUpdate();
            System.out.println("Registros afetados: " + registros);
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return false;
        }
    }

    public void restore(int id) {
        System.out.printf("Listando o estado %d\n", id);
        try {
            PreparedStatement ps = this.mydb.prepareStatement("select id, nome, sigla from estado where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            String sId = null, sNome = null, sSigla = null;
            while (rs.next()) {
                sId = rs.getString(1);
                sNome = rs.getString(2);
                sSigla = rs.getString(3);
                System.out.printf("%s - %s - %s\n", sId, sNome, sSigla);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

    public void restore(String nome) {
        System.out.printf("Listando o(s) estado(s) com %s\n", nome);
        try {
            PreparedStatement ps = this.mydb.prepareStatement("select id, nome, sigla from estado where nome like ?");
            nome = "%" + nome + "%";
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            String sId = null, sNome = null, sSigla = null;
            while (rs.next()) {
                sId = rs.getString(1);
                sNome = rs.getString(2);
                sSigla = rs.getString(3);
                System.out.printf("%s - %s - %s\n", sId, sNome, sSigla);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

    public void restore() {
        System.out.println("Listando todos os estados\n");
        try {
            Statement stmt = this.mydb.createStatement();
            ResultSet rs = stmt.executeQuery("select id, nome, sigla from estado");
            String sId = null, sNome = null, sSigla = null;
            while (rs.next()) {
                sId = rs.getString(1);
                sNome = rs.getString(2);
                sSigla = rs.getString(3);
                System.out.printf("%s - %s - %s\n", sId, sNome, sSigla);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

    public boolean update(int id, String nome, String sigla) {
        System.out.printf("Atualizando o estado %d\n", id);
        try {
            String sql = "update estado set nome = ?, sigla = ? where id = ?";
            PreparedStatement ps = mydb.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, sigla);
            ps.setInt(3, id);
            int registros = ps.executeUpdate();
            System.out.println("Registros afetados: " + registros);
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return false;
        }
    }

    public boolean delete(int id) {
        System.out.printf("Excluindo o estado %d\n", id);
        try {
            String sql = "delete from estado where id = ?";
            PreparedStatement ps = mydb.prepareStatement(sql);
            ps.setInt(1, id);
            int registros = ps.executeUpdate();
            System.out.println("Registros afetados: " + registros);
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return false;
        }
    }

    public void menu() {
        System.out.println("Digite o número de uma das operações\n");
        System.out.println("1 - listar todos");
        System.out.println("2 - listar pelo id");
        System.out.println("3 - listar pelo nome");
        System.out.println("4 - incluir com id");
        System.out.println("5 - incluir sem id");
        System.out.println("6 - atualizar");
        System.out.println("7 - excluir");
        System.out.println("encerrar o programa com qualquer outro valor\n");
        System.out.print("> ");
    }

    public static void main(String[] args) {
        ConsoleEstadoCRUD crud = new ConsoleEstadoCRUD();
        if (crud.conectar()) {
            boolean encerrar = false;
            int codigo = 0; //código de erro - 0 significa sem erro
            int id = 0;
            String nome = null;
            String sigla = null;
            String opcao = null;
            Scanner terminal = new Scanner(System.in);
            while (!encerrar) {
                crud.menu();
                opcao = terminal.nextLine();
                switch (opcao.trim()) {
                    case "1":
                        crud.restore();
                        break;
                    case "2":
                        System.out.print("Qual o id? ");
                        id = Integer.parseInt(terminal.nextLine());
                        crud.restore(id);
                        break;
                    case "3":
                        System.out.print("Qual o nome? ");
                        nome = terminal.nextLine();
                        crud.restore(nome);
                        break;
                    case "4":
                        System.out.print("Qual o id? ");
                        id = Integer.parseInt(terminal.nextLine());
                        System.out.print("Qual o nome? ");
                        nome = terminal.nextLine();
                        System.out.print("Qual a sigla? ");
                        sigla = terminal.nextLine();
                        if (!crud.create(id, nome, sigla)) {
                            encerrar = true;
                            codigo = 4;
                        }
                        break;
                    case "5":
                        System.out.print("Qual o nome? ");
                        nome = terminal.nextLine();
                        System.out.print("Qual a sigla? ");
                        sigla = terminal.nextLine();
                        if (!crud.create(nome, sigla)) {
                            encerrar = true;
                            codigo = 5;
                        }
                        break;
                    case "6":
                        System.out.print("Qual o id? ");
                        id = Integer.parseInt(terminal.nextLine());
                        System.out.print("Qual o nome? ");
                        nome = terminal.nextLine();
                        System.out.print("Qual a sigla? ");
                        sigla = terminal.nextLine();
                        if (!crud.update(id, nome, sigla)) {
                            encerrar = true;
                            codigo = 6;
                        }
                        break;
                    case "7":
                        System.out.print("Qual o id? ");
                        id = Integer.parseInt(terminal.nextLine());
                        if (!crud.delete(id)) {
                            encerrar = true;
                            codigo = 7;
                        }
                        break;
                    default:
                        System.out.println("Encerrando o programa ...");
                        crud.desconectar();
                        encerrar = true;
                        codigo = 0;
                }
            }
            System.exit(codigo);
        } else {
            System.out.println("Encerrando o programa");
            System.exit(10); //Com erro 10 - sem conexão
        }
    }
}
