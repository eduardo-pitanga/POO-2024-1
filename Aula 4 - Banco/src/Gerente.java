import java.util.Objects;

public class Gerente extends Pessoa {
    Gerente(String n, String c, Data dt, char s) {
        super(n, c, dt, s);
    }
    int matricula;
    String senha;

    boolean validarAcesso(String senha) {
        if (Objects.equals(senha, this.senha)) {
            System.out.println("Senha validada com sucesso!");
            return true;
        }
        else {
            System.out.println("Senha inválida");
            return false;
        }
    }
}