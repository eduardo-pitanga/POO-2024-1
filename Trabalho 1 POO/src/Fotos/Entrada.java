package Fotos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Entrada {
    /**
     * Classe com as rotinas de entrada e saída do projeto
     * @author Hilario Seibel Junior e Eduardo Pitanga Loureiro e Theo Mischiatti Gomes
     */

    public Scanner input;

    /**
     * Construtor da classe InputOutput
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     */
    public Entrada() {
        try {
            // Se houver um arquivo input.txt na pasta corrente, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input.txt"));
            // NAO ALTERE A LOCALICAÇÃO DO ARQUIVO!!
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public int menu1() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar pessoa.\n" +
                "2) Cadastrar empresa.\n" +
                "3) Login.\n" +
                "0) Sair.\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 3) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }

    public void menu2(Sistema s, Usuario u) {
        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Seguir alguém.\n" +
                "2) Fazer uma postagem.\n" +
                "3) Exibir feed.\n" +
                "0) Sair.\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 3) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        while (op!=0) {
            if (op == 1) {
                s.listarUsuarios();
                Usuario u2 = s.buscarUsuario(this.lerLinha("Usuario: "));
                u.seguir(u2, s);
            }
            if (op == 2) {
                String foto = this.lerLinha("Foto: ");
                String legenda = this.lerLinha("Legenda: ");
                int dia = this.lerInteiro("Dia: ");
                int mes = this.lerInteiro("Mês: ");
                int ano = this.lerInteiro("Ano: ");
                String senha = this.lerLinha("Senha: ");
                u.postar(foto, legenda, new Data(dia, mes, ano),senha);
            }
            if (op == 3) {
                u.feed();
            }

            op = this.lerInteiro(msg);

            while (op < 0 || op > 3) {
                System.out.println("Opção inválida. Tente novamente: ");
                op = this.lerInteiro(msg);
            }
        }


    }

    /***************************************************/

    /**
     * Lê os dados de uma nova Pessoa e cadastra-a no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadPessoa(Sistema s) {
        String login = this.lerLinha("Escolha um login: ");

        while (s.buscarUsuario(login) != null) {
            login = this.lerLinha("Usuário já existente. Escolha outro login: ");
        }

        String nome = this.lerLinha("Digite seu nome: ");
        String senha = this.lerLinha("Digite sua senha: ");
        String cpf = this.lerLinha("Digite seu cpf: ");
        int dia = this.lerInteiro("Digite seu dia de nascimento: ");
        int mes = this.lerInteiro("Digite seu mes de nascimento: ");
        int ano = this.lerInteiro("Digite seu ano de nascimento: ");

        Pessoa p = new Pessoa(login, nome, senha, cpf, dia, mes, ano);
        s.novaPessoa(p);
    }

    /**
     * Lê os dados de uma nova Empresa e cadastra-a no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadEmpresa(Sistema s) {
        String login = this.lerLinha("Escolha um login: ");

        while (s.buscarUsuario(login) != null) {
            login = this.lerLinha("Usuário já existente. Escolha outro login: ");
        }

        String nome = this.lerLinha("Digite seu nome: ");
        String senha = this.lerLinha("Digite sua senha: ");
        String cnpj = this.lerLinha("Digite seu cnpj: ");

        Empresa e = new Empresa(login, nome, senha, cnpj);
        s.novaEmpresa(e);

    }

    public void cadPostagem(Sistema s, Usuario u) {
        String foto = this.lerLinha("Nome do post: ");
        String legenda = this.lerLinha("Legenda: ");
        int dia = this.lerInteiro("Dia da postagem: ");
        int mes = this.lerInteiro("Mês da postagem: ");
        int ano = this.lerInteiro("Ano da postagem: ");
        String senha = this.lerLinha("Senha: ");

        Postagem pos = new Postagem(foto, legenda, dia, mes, ano);
        if(u.validarAcesso(senha)) {
            u.posts.add(pos);
        }
    }

    public void login(Sistema s) {
        String login = this.lerLinha("Digite seu login: ");
        String senha = this.lerLinha("Digite sua senha: ");
        Usuario user = s.buscarUsuario(login);
        if (user.validarAcesso(senha)) {
            this.menu2(s, user);
        }
    }
}
