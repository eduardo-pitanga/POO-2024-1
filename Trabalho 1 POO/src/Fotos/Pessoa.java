package Fotos;

import java.util.ArrayList;

public class Pessoa extends Usuario{
    private String cpf;
    private Data nasc;
    private String bio;
    private ArrayList<Usuario> interesses = new ArrayList<>();

    Pessoa(String login, String nome, String senha, String cpf, int dia, int mes, int ano) {
        super(login, nome, senha);
        this.cpf = cpf;
        this.nasc = new Data(dia,mes,ano);
    }

    public String toString() {
        return(this.nome + "(" + this.login + " - " + this.cpf + ")");
    }
}
