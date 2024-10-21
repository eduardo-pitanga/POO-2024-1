public class ContaPoupanca extends Conta{

    public ContaPoupanca(String numero, Pessoa titular, Data dtcri, Gerente ger) {
        super(numero, titular, dtcri, ger);
    }

    void rendimento(double j) {
        if (this.saldo > 0) {
            this.saldo = this.saldo*j/100 + this.saldo;
        }
        else {
            System.out.println(this.titular.nome + " não está rendendo (conta zerada)");
        }
    }
    void extrato() {
        System.out.println("\n*** EXTRATO DA CONTA POUPANÇA ***");
        super.extrato();
    }
}
