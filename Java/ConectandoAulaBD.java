import java.sql.Connection;
import java.sql.DriverManager;

public class ConectandoAulaBD {

    public static void main(String[] args) {
        try {
            System.out.println("Conectando com o MySQL ...");
            System.out.println("Banco de Dados aula_bd");

//            Class.forName("com.mysql.jdbc.Driver"); //MySQL 5.X
            Class.forName("com.mysql.cj.jdbc.Driver"); //MySQL 8.X
            String url = "jdbc:mysql://localhost:3306/aula_bd";
            String usuario = "root";
            String senha = "root";
            
            Connection mydb = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado? " + !mydb.isClosed());
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
}