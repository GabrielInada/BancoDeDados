import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InserindoEstado {

    public static void main(String[] args) {
        try {
            System.out.println("Conectando com o MySQL ...");
//            Class.forName("com.mysql.jdbc.Driver"); //MySQL 5.X
            Class.forName("com.mysql.cj.jdbc.Driver"); //MySQL 8.X
            String url = "jdbc:mysql://localhost:3306/aula_bd";

            Connection mydb = DriverManager.getConnection(url, "root", "root");
            
            String sql = "insert into estado (id, nome, sigla) values (?, ?, ?)";
            PreparedStatement ps = mydb.prepareStatement(sql);
            ps.setInt(1, 7);
            ps.setString(2, "Tocantins");
            ps.setString(3, "TO");
            int registros = ps.executeUpdate();
            System.out.println("Registros afetados: " + registros);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
}
