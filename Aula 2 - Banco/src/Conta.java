import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Conta {
    String numero;
    Pessoa titular;
    double saldo;
    double limite;

    double disponivel() {
        return (this.saldo + this.limite);
    }

    void depositar(double x) {
        this.saldo += x;
        System.out.println("Depositou!");
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

    void extrato() {
        System.out.println("*** EXTRATO DA CONTA ***");
        System.out.printf("Conta: %s\n", this.numero);
        System.out.printf("Titular: %s\n", this.titular.nome);
        System.out.printf("Disponível: %f\n", this.disponivel());
    }

    void chequeEsp(double j) {
        if (this.saldo < 0) {
            this.saldo = this.saldo*j/100 + this.saldo;
        }
        else {
            System.out.println("Não está em cheque especial");
        }
    }
}
