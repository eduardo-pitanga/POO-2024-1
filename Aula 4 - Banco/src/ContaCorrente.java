public class ContaCorrente extends Conta{

    public ContaCorrente(String numero, Pessoa titular) {
        super(numero, titular);
    }
    double limite = 200;

    double disponivel() {
        return (this.saldo + this.limite);
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

    void chequeEsp(double j, int i) {
        if (this.saldo < 0) {
            this.saldo = this.saldo*j/100 + this.saldo;
        }
        else if (i == 0){
            System.out.println(this.titular.nome + " não está em cheque especial");
        }
    }
}
