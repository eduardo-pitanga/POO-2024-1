public class Main {
    public static void main(String[] args) {
        Entrada entrada = new Entrada();

        Pessoa p1 = new Pessoa("Eduardo Pitanga", "177.031.757-06", new Data(21,2,2004),'M');
        Pessoa p2 = new Pessoa("Henrique Pitanga", "177.031.797-29", new Data(2,7,2006),'M');
        Pessoa p3 = new Pessoa();
        Pessoa p4 = new Pessoa();

        Gerente g1 = new Gerente("Ana Paula","082.330.057-97",new Data(3,9,1977),'F',"14253674","Pinguinho1.");
        Gerente g2 = new Gerente();

        ContaCorrente cc1 = new ContaCorrente("123456", p1, new Data(21,3,2024),g1);
        ContaCorrente cc2 = new ContaCorrente("225154", p2, new Data(21,3,2024),g1);

        ContaPoupanca cp1 = new ContaPoupanca("594864", p3, new Data(21,3,2024),g2);
        ContaPoupanca cp2 = new ContaPoupanca("re256w", p4, new Data(21,3,2024),g2);

        cc1.depositar(1000);
        cc2.depositar(500);
        cp1.depositar(600);
        cp2.depositar(1900);

        cc1.transferir(100,cc2);
        cc2.alterarLimite();
        cp2.transferir(2000,cp1);
        cp1.sacar(2700);
        cp1.sacar(2600);

        cc1.extrato();
        cc2.extrato();
        cp1.extrato();
        cp2.extrato();
    }
}