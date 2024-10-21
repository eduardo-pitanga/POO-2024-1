public class Pessoa {
    String nome;
    String cpf;
    Data dtNasc;
    char sexo;

    Entrada input = new Entrada();

    Pessoa() {
        this.nome = this.input.linha("Nome: ");
        this.cpf = this.input.linha("CPF: ");
        this.dtNasc = new Data();
        this.sexo = this.input.caractere("Sexo: ");
    }
    Pessoa(String nome, String cpf, Data dtNasc, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
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
