import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Conta {
    protected String numero;
    protected Pessoa titular;
    protected double saldo = 0;
    protected Gerente gerente;
    protected Data dtcriacao;

    public Entrada input = new Entrada();

    public Conta(Pessoa titular, Gerente ger) {
        this.numero = input.linha("Número: ");
        this.titular = titular;
        this.gerente = ger;
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

    public void depositar(double x) {
        this.saldo += x;
        System.out.println("Depositou!");
    }

    public void depositar() {
        this.depositar(input.decimal("Valor: "));
    }

    protected double disponivel() {
        return this.saldo;
    }
    public void extrato() {
        System.out.printf("Conta: %s\n", this.numero);
        System.out.printf("Titular: %s\n", this.titular.nome);
        System.out.printf("Disponível: %f\n", this.disponivel());
    }
    public boolean sacar(double x) {
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
    public boolean sacar() {
        return this.sacar(input.decimal("Valor: "));
    }
    public boolean transferir(double valor, Conta c) {
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
    public boolean transferir(Conta c) {
        return this.transferir(input.decimal("Valor: "), c);
    }

    public String getNumero() {
        return numero;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public Data getDtcriacao() {
        return dtcriacao;
    }
}
