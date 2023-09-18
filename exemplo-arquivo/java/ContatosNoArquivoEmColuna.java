import java.io.*;
import java.net.URL;
import java.util.Scanner;

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

    public void pesquisarPorNome(String nome) {

    }

    public void inserirContato(String nome, String email, String telefone) {
        try {
            FileWriter fw = new FileWriter(this.ARQUIVO, true); //escreve no final do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(nome);
            bw.newLine();
            bw.write(email);
            bw.newLine();
            bw.write(telefone);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void alterarContato(String nome, String email, String telefone) {

    }

    public void excluirContato(String nome) {

    }

    public void menu() {
        System.out.println("Selecione uma operação com o banco de dados de contatos");
        System.out.println();
        System.out.println("1- listar contatos");
        System.out.println("2- pesquisar contato");
        System.out.println("3- incluir contato");
        System.out.println("4- alterar contato");
        System.out.println("5- excluir contato");
        System.out.println();
        System.out.print("> ");
    }

    public static void main(String[] args) throws IOException {
        ContatosNoArquivoEmColuna contatos = new ContatosNoArquivoEmColuna();
        Scanner prompt = new Scanner(System.in);
        String nome = null, email = null, telefone = null, opcao = null;
        boolean encerrar = false;
        while (!encerrar) {
            contatos.menu();
            opcao = prompt.nextLine();
            switch (opcao.trim()) {
                case "1":
                    contatos.listarContatos();
                    break;
                case "2":
                    System.out.print("Qual contato pesquisar?");
                    nome = prompt.nextLine();
                    contatos.pesquisarPorNome(nome);
                    break;
                case "3":
                    System.out.println("Incluindo um contato no banco de dados ...");
                    System.out.print("Qual o nome?");
                    nome = prompt.nextLine();
                    System.out.print("Qual o email?");
                    email = prompt.nextLine();
                    System.out.print("Qual o telefone?");
                    telefone = prompt.nextLine();
                    contatos.inserirContato(nome, email, telefone);
                    break;
                case "4":
                    System.out.println("Incluindo um contato no banco de dados ...");
                    System.out.print("Qual contato alterar?");
                    nome = prompt.nextLine();
                    System.out.print("Qual o novo email?");
                    email = prompt.nextLine();
                    System.out.print("Qual o novo telefone?");
                    telefone = prompt.nextLine();
                    contatos.alterarContato(nome, email, telefone);
                    break;
                case "5":
                    System.out.println("Excluindo um contato no banco de dados ...");
                    System.out.print("Qual contato excluir?");
                    nome = prompt.nextLine();
                    contatos.excluirContato(nome);
                    break;
                default:
                    encerrar = true;
            }
        }
        prompt.close();
    }
}