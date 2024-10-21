public class Data {
    int dia;
    int mes;
    int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    void imprimir() {
        System.out.printf("%02d/%02d/%04d\n", dia, mes, ano);
    }
}
