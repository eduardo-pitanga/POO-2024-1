import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Conta {
    String numero;
    Pessoa titular;
    double saldo = 0;
    Gerente ger;
    Data dtcriacao;

    public Conta(String numero, Pessoa titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        System.out.println("Nova conta criada no sistema!");
    }

    void depositar(double x) {
        this.saldo += x;
        System.out.println("Depositou!");
    }
}
