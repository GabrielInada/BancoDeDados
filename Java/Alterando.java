import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Atualizando {

    public static void main(String[] args) {
        try {
            System.out.println("Conectando com o MySQL ...");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/aula_bd";

            Connection mydb = DriverManager.getConnection(url, "root", "root");
            
            String sql = "update estado set nome = ?, sigla = ? where id = ?";
            PreparedStatement ps = mydb.prepareStatement(sql);
            ps.setString(1, "Mato Grosso");
            ps.setString(2, "MT");
            ps.setInt(3, 6);
            int registros = ps.executeUpdate();
            System.out.println("Registros afetados: " + registros);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
}