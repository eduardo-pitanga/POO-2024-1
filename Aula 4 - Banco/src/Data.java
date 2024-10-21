public class Data {
    int dia;
    int mes;
    int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    boolean maior(Data dt2) {
        if (dt2.ano < this.ano) {
            System.out.println("A data atual é maior");
            return true;
        }
        else if (dt2.ano == this.ano && dt2.mes < this.mes) {
            System.out.println("A data atual é maior");
            return true;
        }
        else if (dt2.mes == this.mes && dt2.dia < this.dia) {
            System.out.println("A data atual é maior");
            return true;
        }
        else {
            System.out.println("A data atual é menor");
            return false;
        }
    }

    void imprimir() {
        System.out.printf("%02d/%02d/%04d\n", dia, mes, ano);
    }
}
