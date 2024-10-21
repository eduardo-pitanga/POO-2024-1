public class ContaCorrente extends Conta{

    private double limite = 200;

    public ContaCorrente(String numero, Pessoa titular, Data dtcri, Gerente ger) {
        super(numero, titular, dtcri, ger);
    }

    private double disponivel() {
        return (this.saldo + this.limite);
    }
    public void chequeEsp(double j, int i) {
        if (this.saldo < 0) {
            this.saldo = this.saldo*j/100 + this.saldo;
        }
        else if (i == 0){
            System.out.println(this.titular.nome + " não está em cheque especial");
        }
    }

    public void alterarLimite(String pwd, double l) {
        if (this.gerente.validarAcesso(pwd)) {
            this.limite = l;
        }
        else {
            System.out.println("Senha inválida, limite não alterado.");
        }
    }

    public void alterarLimite() {
        this.alterarLimite(input.linha("Senha: "), input.decimal("Valor: "));
    }

    public void extrato() {
        System.out.println("\n*** EXTRATO DA CONTA CORRENTE ***");
        super.extrato();
    }
}
