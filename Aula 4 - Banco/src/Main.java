public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Eduardo", "177.031.757-06", new Data(21,2,2004), 'M');

        Pessoa p2 = new Pessoa("Henrique", "177.031.997-29", new Data(2, 7, 2006), 'M');

        Gerente g1 = new Gerente("Hilário", "084.446.151-99", new Data(10, 10, 1990), 'M');

        ContaCorrente c1 = new ContaCorrente("1234-5", p1);

        ContaPoupanca c2 = new ContaPoupanca("2345-5", p2);

        g1.matricula = 15159889;
        g1.senha = "cavalinho";
        c1.ger = g1;
        g1.validarAcesso("cavalinho2"); //senha inválida
        g1.validarAcesso("cavalinho"); //senha válida

        Data dtatual = new Data(14, 3, 2024);

        Data dtnova = new Data(5, 12, 2026);

        dtnova.maior(dtatual);


        c1.extrato();
        c2.extrato();
        c1.depositar(10000);
        c1.transferir(3000, c2);
        c1.extrato();
        c2.extrato();

        for (int i = 0; i < 30; i++) {
            c1.chequeEsp(0.2, i);
        }
        c1.extrato();

        for (int i = 0; i < 30; i++) {
            c2.rendimento(0.2);
        }
        c2.extrato();

        System.out.println("Pessoa: " + p1.nome);
        System.out.print("Data de Nascimento: ");
        p1.dtNasc.imprimir();
        System.out.print("Data Atual: ");
        dtatual.imprimir();
        System.out.println("Idade: " + p1.consultaIdade(dtatual));
    }
}