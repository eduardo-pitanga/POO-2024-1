package Fotos;

import java.util.ArrayList;
import java.util.Objects;

public class Sistema {
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    private ArrayList<Empresa> empresas = new ArrayList<>();

    public Usuario buscarUsuario(String login) {
        for (Usuario u : this.pessoas) {
            if (Objects.equals(u.login, login)) return u;
        }
        for (Usuario u : this.empresas) {
            if (Objects.equals(u.login, login)) return u;
        }

        return null;
    }

    public void novaPessoa(Pessoa p) {
        this.pessoas.add(p);
    }

    public void novaEmpresa(Empresa e) {
        this.empresas.add(e);
    }

    public void listarUsuarios() {
        System.out.println("Pessoas:");
        for (Usuario u : this.pessoas) {
            System.out.println(u.toString());
        }
        System.out.println("Empresas: ");
        for (Usuario u : this.empresas) {
            System.out.println(u.toString());
        }
    }
}
