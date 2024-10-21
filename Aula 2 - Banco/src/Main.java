public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.nome = "Eduardo";
        p1.cpf = "177.031.757-06";
        p1.idade = 20;
        p1.sexo = 'M';

        Pessoa p2 = new Pessoa();
        p2.nome = "Henrique";
        p2.cpf = "177.031.997-29";
        p2.idade = 17;
        p2.sexo = 'M';

        Conta c1 = new Conta();
        c1.numero = "1234-5";
        c1.titular = p1;
        c1.saldo = 1300;
        c1.limite = 2400;

        Conta c2 = new Conta();
        c2.numero = "2345-5";
        c2.titular = p2;
        c2.saldo = 1200;
        c2.limite = 0;

        c1.extrato();
        c1.saldo= -4000;
        c1.extrato();

        for (int i = 0; i < 30; i++) {
            c1.chequeEsp(0.2);
        }
        c1.extrato();
    }
}