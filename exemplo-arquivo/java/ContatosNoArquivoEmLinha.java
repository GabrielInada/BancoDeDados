import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ContatosNoArquivoEmLinha {

    private final String NOME_ARQUIVO = "contatos-linha.txt";
    private final File ARQUIVO;

    public ContatosNoArquivoEmLinha() {
        URL resource = ContatosNoArquivoEmLinha.class.getClassLoader().getResource(this.NOME_ARQUIVO);
        this.ARQUIVO = new File(resource.getFile());
    }

    public void listarContatos() {
        try {
            FileReader fr = new FileReader(ARQUIVO);
            BufferedReader bw = new BufferedReader(fr);
            String linha = null;
            String[] colunas = null;
            while ((linha = bw.readLine()) != null) {
                colunas = linha.split(";");
                System.out.printf("Nome: %s, E-mail: %s, Telefone: %s\n", colunas[0], colunas[1], colunas[2]);
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void inserirContato(String nome, String email, String telefone) {

    }

    public void pesquisarPorNome(String nome) {

    }

    public static void main(String[] args) throws IOException {
        ContatosNoArquivoEmLinha contatos = new ContatosNoArquivoEmLinha();
        contatos.listarContatos();
    }
}