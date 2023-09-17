import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ContatosNoArquivoEmColuna {

    private final String NOME_ARQUIVO = "contatos-coluna.txt";
    private final File ARQUIVO;

    public ContatosNoArquivoEmColuna() {
        URL resource = ContatosNoArquivoEmColuna.class.getClassLoader().getResource(this.NOME_ARQUIVO);
        this.ARQUIVO = new File(resource.getFile());
    }

    public void listarContatos() {
        try {
            FileReader fr = new FileReader(ARQUIVO);
            BufferedReader bw = new BufferedReader(fr);
            String linha = null;
            int posicao = 1;
            String nome = null, email = null, telefone = null;
            while ((linha = bw.readLine()) != null) {
                switch (posicao) {
                    case 1:
                        nome = linha;
                        break;
                    case 2:
                        email = linha;
                        break;
                    case 3:
                        telefone = linha;
                        break;
                    default:
                        posicao = 0; //linha em branco, separadora
                }
                if (posicao == 3) {
                    //Coletou todos os valores do contato
                    System.out.printf("Nome: %s, E-mail: %s, Telefone: %s\n", nome, email, telefone);
                }
                posicao++;
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
        ContatosNoArquivoEmColuna contatos = new ContatosNoArquivoEmColuna();
        contatos.listarContatos();
    }
}