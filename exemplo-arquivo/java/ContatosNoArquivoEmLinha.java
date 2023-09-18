import java.io.*;
import java.net.URL;
import java.util.Scanner;

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

    public void pesquisarPorNome(String nome) {

    }

    public void inserirContato(String nome, String email, String telefone) {
        try {
            FileWriter fw = new FileWriter(this.ARQUIVO, true); //escreve no final do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nome);
            bw.write(';');
            bw.write(email);
            bw.write(';');
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
        ContatosNoArquivoEmLinha contatos = new ContatosNoArquivoEmLinha();
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