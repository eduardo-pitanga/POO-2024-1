import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Conta {
    String numero;
    Pessoa titular;
    double saldo = 0;
    Gerente gerente;
    Data dtcriacao;

    Entrada input = new Entrada();

    public Conta(Gerente ger) {
        this.numero = input.linha("Número: ");
        this.titular = new Pessoa();
        this.gerente = new Gerente();
        this.dtcriacao = new Data();
        System.out.println("Nova conta criada no sistema!");
    }
    public Conta(String numero, Pessoa titular, Data dtcri, Gerente ger) {
        this.numero = numero;
        this.titular = titular;
        this.dtcriacao = dtcri;
        this.gerente = ger;
        System.out.println("Nova conta criada no sistema!");
    }

    void depositar(double x) {
        this.saldo += x;
        System.out.println("Depositou!");
    }

    double disponivel() {
        return this.saldo;
    }
    void extrato() {
        System.out.printf("Conta: %s\n", this.numero);
        System.out.printf("Titular: %s\n", this.titular.nome);
        System.out.printf("Disponível: %f\n", this.disponivel());
    }
    boolean sacar(double x) {
        if (this.disponivel() >= x) {
            this.saldo -= x;
            System.out.println("Saquei");
            return true;
        }
        else {
            System.out.println("Não saquei");
            return false;
        }
    }
    boolean transferir(double valor, Conta c) {
        if (valor <= this.disponivel()) {
            this.sacar(valor);
            c.depositar(valor);
            System.out.println("Transferi!");
            return true;
        }
        else {
            System.out.println("Não transferi!");
            return false;
        }
    }
}
