import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelecionandoEstado {

    public static void main(String[] args) {
        try {
            System.out.println("Conectando com o MySQL ...");
//            Class.forName("com.mysql.jdbc.Driver"); //MySQL 5.X
            Class.forName("com.mysql.cj.jdbc.Driver"); //MySQL 8.X
            String url = "jdbc:mysql://localhost:3306/aula_bd";

            Connection mydb = DriverManager.getConnection(url, "root", "root");
            
            Statement stmt = mydb.createStatement();            
            ResultSet rs = stmt.executeQuery("select id, nome, sigla from estado");
            while (rs.next()) {
                System.out.print(rs.getString(1) + ", ");
                System.out.print(rs.getString(2) + ", ");
                System.out.println(rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
}