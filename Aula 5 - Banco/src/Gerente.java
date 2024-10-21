import java.util.Objects;

public class Gerente extends Pessoa {

    String matricula;
    String senha;

    Gerente() {
        super();
        this.matricula = this.input.linha("Matricula: ");
        this.senha = "123456";
    }

    Gerente(String nome, String cpf, Data dtNasc, char sexo, String matricula, String senha) {
        super(nome, cpf, dtNasc, sexo);
        this.matricula = matricula;
        this.senha = senha;
    }

    boolean validarAcesso(String senha) {
        return senha.equals(this.senha);
    }

    boolean validarAcesso() {
        senha = input.linha("Senha: ");
        return senha.equals(this.senha);
    }
}