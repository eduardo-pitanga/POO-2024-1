import java.util.Scanner;

public class Entrada {
    Scanner s;

    Entrada() {
        this.s = new Scanner(System.in);
    }

    String linha(String msg) {
        System.out.print(msg);
        return this.s.nextLine();
    }

    char caractere(String msg) {
        return this.linha(msg).charAt(0);
    }

    int inteiro(String msg) {
        return Integer.parseInt(this.linha(msg));
    }

    double decimal(String msg) {
        return Double.parseDouble(this.linha(msg));
    }
}