import java.util.ArrayList;

public class Main {
    public static int menuInicial() {
        Entrada input = new Entrada();
        System.out.println("Bem vindo! Escolha uma opção:\n");
        System.out.println("1) Cadastro");
        System.out.println("2) Movimentação Financeira");
        System.out.println("0) Sair");

        return input.inteiro("");
    }

    public static void menuCadastro(ArrayList<Pessoa> p, ArrayList<Gerente> g, ArrayList<Conta> c) {
        Entrada input = new Entrada();
        System.out.println("O que deseja cadastrar?");
        System.out.println("1) Novo cliente");
        System.out.println("2) Novo gerente");
        System.out.println("3) Nova conta corrente");
        System.out.println("4) Nova conta poupança");

        int op = input.inteiro("");
        if (op == 1) p.add(new Pessoa());
        else if (op == 2) g.add(new Gerente());
        else if (op == 3) {
            Pessoa tit = escolherPessoa(p);
            Gerente ger = escolherGerente(g);
            c.add(new ContaCorrente(tit, ger));
        }
        else if (op == 4) {
            Pessoa tit = escolherPessoa(p);
            Gerente ger = escolherGerente(g);
            c.add(new ContaPoupanca(tit, ger));
        }
    }

    public static Pessoa escolherPessoa(ArrayList<Pessoa> p) {
        Entrada input = new Entrada();
        int i = 1;
        System.out.println("Escolha uma pessoa:");
        for (Pessoa tit : p) {
            System.out.println(i + ") " + tit.getCpf() + " - " + tit.getNome());
            i++;
        }
        return p.get(input.inteiro("")-1);
    }

    public static Gerente escolherGerente(ArrayList<Gerente> g) {
        Entrada input = new Entrada();
        int i = 1;
        System.out.println("Escolha um gerente:");
        for (Gerente ger : g) {
            System.out.println(i + ") " + ger.getCpf() + " - " + ger.getNome());
            i++;
        }
        return g.get(input.inteiro("")-1);
    }

    public static void menuMovimentacoes(ArrayList<Pessoa> p, ArrayList<Gerente> g, ArrayList<Conta> c) {
        Entrada input = new Entrada();

        Conta conta1 = escolherConta(c);
        System.out.println("O que deseja realizar?");
        System.out.println("1) Extrato");
        System.out.println("2) Saque");
        System.out.println("3) Deposito");
        System.out.println("4) Transferencia");

        int op = input.inteiro("");

        if (op == 1) conta1.extrato();
        else if (op == 2) conta1.sacar();
        else if (op == 3) conta1.depositar();
        else if (op == 4) {
            System.out.println("Qual a conta destino?");
            Conta conta2 = escolherConta(c);
            conta1.transferir(conta2);
        }
    }

    public static Conta escolherConta(ArrayList<Conta> c) {
        Entrada input = new Entrada();
        int i = 1;
        System.out.println("Escolha uma conta:");
        for (Conta cc : c) {
            System.out.println(i + ") " + cc.numero + " - " + cc.titular.nome);
            i++;
        }

        return c.get(input.inteiro("") - 1);
    }

    public static void main(String[] args) {

        ArrayList<Pessoa> p = new ArrayList<>() ;
        ArrayList<Gerente> g = new ArrayList<>() ;
        ArrayList<Conta> c = new ArrayList<>() ;

        int op = menuInicial();
        while (op != 0) {
            if (op == 1) {
                menuCadastro(p, g, c);
            }
            if (op == 2) {
                menuMovimentacoes(p, g, c);
            }
            op = menuInicial();
        }
        System.out.println("\nBye! :-)");
    }
}