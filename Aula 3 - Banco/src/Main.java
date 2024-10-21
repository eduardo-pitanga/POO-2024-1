public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Eduardo", "177.031.757-06", new Data(21,2,2004), 'M');

        Pessoa p2 = new Pessoa("Henrique", "177.031.997-29", new Data(2, 7, 2006), 'M');

        Conta c1 = new Conta("1234-5", p1);

        Conta c2 = new Conta("2345-5", p2);

        Data dtatual = new Data(7, 3, 2024);

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

        System.out.println("Pessoa: " + p1.nome);
        System.out.print("Data de Nascimento: ");
        p1.dtNasc.imprimir();
        System.out.print("Data Atual: ");
        dtatual.imprimir();
        System.out.println("Idade: " + p1.consultaIdade(dtatual));
    }
}