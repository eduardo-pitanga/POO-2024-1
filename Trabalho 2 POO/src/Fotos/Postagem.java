package Fotos;

public class Postagem {
    private String foto;
    private String legenda;
    private Data d;

    Postagem(String foto, String legenda, Data hoje) {
        this.foto = foto;
        this.legenda = legenda;
        this.d = hoje;
    }

    Postagem(String foto, String legenda, int dia, int mes, int ano) {
        this.foto = foto;
        this.legenda = legenda;
        this.d = new Data(dia, mes, ano);
    }

    public void mostrarDados() {
        System.out.println(this.foto + "\n" + this.legenda + "\n" + this.d.toString() + "\n*");
    }

    public String getFoto() {
        return foto;
    }

    public String getLegenda() {
        return legenda;
    }

    public Data getD() {
        return d;
    }
}
