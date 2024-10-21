import java.util.Objects;

public class Gerente extends Pessoa {

    private String matricula;
    private String senha;

    public Gerente() {
        super();
        this.matricula = this.input.linha("Matricula: ");
        this.senha = "123456";
    }

    public Gerente(String nome, String cpf, Data dtNasc, char sexo, String matricula, String senha) {
        super(nome, cpf, dtNasc, sexo);
        this.matricula = matricula;
        this.senha = senha;
    }

    public boolean validarAcesso(String senha) {
        return senha.equals(this.senha);
    }

    public boolean validarAcesso() {
        senha = input.linha("Senha: ");
        return senha.equals(this.senha);
    }
}