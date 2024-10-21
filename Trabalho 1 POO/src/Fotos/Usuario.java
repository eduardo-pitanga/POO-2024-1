package Fotos;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario {
    protected String login;
    protected String nome;
    protected String senha;
    protected Local cidade;
    protected ArrayList<Postagem> posts = new ArrayList<>();
    protected ArrayList<Usuario> seguindo = new ArrayList<>();
    protected ArrayList<Usuario> seguidores = new ArrayList<>();
    protected ArrayList<Pessoa> interessados = new ArrayList<>();

    public Usuario(String login, String nome, String senha) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }

    public boolean validarAcesso(String pwd) {
        return (Objects.equals(pwd, this.senha));
    }

    public String toString() {
        return(this.nome + "(" + this.login + ")");
    }

    public void postar(String foto, String legenda, Data hoje, String senha) {
        Postagem post = new Postagem(foto, legenda, hoje);
        if (validarAcesso(senha)) {
            this.posts.add(post);
        }
    }

    public void seguir(Usuario u, Sistema s) {
        this.seguindo.add(u);
        u.seguidores.add(s.buscarUsuario(this.login));
    }

    public void mostrarPosts() {
        for (Postagem pp : this.posts) {
            System.out.println(this.toString());
            pp.mostrarDados();
        }
    }

    public void feed() {
        System.out.println("Feed do " + this.login);
        for (Usuario u : this.seguindo) {
            u.mostrarPosts();
        }
    }

}
