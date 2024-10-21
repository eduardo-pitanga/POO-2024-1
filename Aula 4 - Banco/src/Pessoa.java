public class Pessoa {
    String nome;
    String cpf;
    Data dtNasc;
    char sexo;

    Pessoa(String n, String c, Data dt, char s) {
        this.nome = n;
        this.cpf = c;
        this.dtNasc = dt;
        this.sexo = s;
        System.out.println("Nova pessoa criada no sistema!");
    }

    int consultaIdade(Data dtHoje) {
        int diaH = dtHoje.dia;
        int mesH = dtHoje.mes;
        int anoH = dtHoje.ano;

        int idade = anoH - this.dtNasc.ano;
        if (mesH < this.dtNasc.mes) {
            idade -= 1;
        } else if (mesH == this.dtNasc.mes && diaH < this.dtNasc.dia) {
            idade -= 1;
        }
        return idade;
    }

    void alteraCPF(String c) {
        this.cpf = c;
    }
}
