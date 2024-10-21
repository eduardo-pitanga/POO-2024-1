package Fotos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public abstract class Usuario {
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

    public String toString2() {
        int count = this.seguidores.size();
        if (count == 1)
            return(this.nome + " (" + count + " seguidor)");
        else
            return(this.nome + " (" + count + " seguidores)");
    }

    public void postar(String foto, String legenda, Data hoje, String senha) {
        Postagem post = new Postagem(foto, legenda, hoje);
        if (validarAcesso(senha)) {
            this.posts.add(post);
        }
    }

    public int comp_seguidores(ArrayList<Usuario> seguidores) {
        if (this.seguidores.size() > seguidores.size()) return 1;
        if (this.seguidores.size() < seguidores.size()) return -1;
        else return 0;
    }

    public int comp_login(String login) {
        return this.login.compareTo(login);
    }

    public void seguir(Usuario u, Sistema s) {
        this.seguindo.add(u);
        u.seguidores.add(s.buscarUsuario(this.login));
    }

    public void mostrarPosts(ArrayList<Auxiliar> lista) {
        for (Auxiliar aux : lista) {
            System.out.println(aux.user.toString2());
            aux.post.mostrarDados();
        }
    }

    public void feed() {
        System.out.println("Feed do " + this.login +":\n*");
        ArrayList<Auxiliar> aux = new ArrayList<>();

        for (Usuario u : this.seguindo) {
            for (Postagem p : u.posts) {
                Auxiliar par = new Auxiliar();
                par.user = u;
                par.post = p;
                aux.add(par);
            }
        }

        Collections.sort(aux, new Comparator<Auxiliar>() {
            @Override
            public int compare(Auxiliar o1, Auxiliar o2) {
                return o1.comparador(o1,o2);
            }
        });

        mostrarPosts(aux);

    }

}
