import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Excluindo {

    public static void main(String[] args) {
        try {
            System.out.println("Conectando com o MySQL ...");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/aula_bd";

            Connection mydb = DriverManager.getConnection(url, "root", "root");
            
            String sql = "delete from estado where id = ?";
            PreparedStatement ps = mydb.prepareStatement(sql);
            ps.setInt(1, 6);
            int registros = ps.executeUpdate();
            System.out.println("Registros afetados: " + registros);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
}