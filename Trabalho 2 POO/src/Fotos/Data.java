package Fotos;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String toString() {
        return (dia + "/" + mes + "/" + ano);
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int compara(Data d) {
        if (this.ano < d.getAno()) return -1;
        if (this.ano > d.getAno()) return 1;
        if (this.mes < d.getMes()) return -1;
        if (this.mes > d.getMes()) return 1;
        if (this.dia < d.getDia()) return -1;
        if (this.dia > d.getDia()) return 1;
        return 0;
    }
}
