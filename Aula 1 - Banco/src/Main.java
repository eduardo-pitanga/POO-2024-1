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
        c1.saldo = 2987;
        c1.limite = 2400;

        Conta c2 = new Conta();
        c2.numero = "2345-5";
        c2.titular = p2;
        c2.saldo = 1200;
        c2.limite = 0;

        System.out.println("*** EXTRATO NA CONTA ***");
        System.out.printf("Conta: %s\n", c1.numero);
        System.out.printf("Titular: %s\n", c1.titular.nome);
        System.out.printf("Saldo disponível para sacar: %f\n", c1.saldo + c1.limite);

    }
}