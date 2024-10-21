public class Pessoa {
    protected String nome;
    protected String cpf;
    protected Data dtNasc;
    protected char sexo;

    Entrada input = new Entrada();

    public Pessoa() {
        this.nome = this.input.linha("Nome: ");
        this.cpf = this.input.linha("CPF: ");
        this.dtNasc = new Data();
        this.sexo = this.input.caractere("Sexo: ");
    }
    public Pessoa(String nome, String cpf, Data dtNasc, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        System.out.println("Nova pessoa criada no sistema!");
    }

    public int consultaIdade(Data dtHoje) {
        int diaH = dtHoje.getDia();
        int mesH = dtHoje.getMes();
        int anoH = dtHoje.getAno();

        int idade = anoH - this.dtNasc.getAno();
        if (mesH < this.dtNasc.getMes()) {
            idade -= 1;
        } else if (mesH == this.dtNasc.getMes() && diaH < this.dtNasc.getDia()) {
            idade -= 1;
        }
        return idade;
    }

    public void alteraCPF(String c) {
        this.cpf = c;
    }
}