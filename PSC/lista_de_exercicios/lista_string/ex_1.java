// Faça um programa que verifica se o texto começa com letra em caixa alta ou não.

package PSC.lista_de_exercicios.lista_string;

import java.util.Scanner;

public class ex_1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {

        ValidarInicial("\n\u001B[36mInsira um texto: \u001B[0m");
    }

    public static String ValidarInicial(String msg) {
        String read;
        System.out.println(msg);

        while (true) {

            read = sc.nextLine();

            if (Character.isUpperCase(read.charAt(0))) {
                System.out.println("\u001B[32mTexto começa com caixa alta.Letra inicial: ('" + read.charAt(0)
                        +  "')\u001B[0m");
                return read;
            } else {

                System.out.println("\u001B[31mtexto não começa com caixa alta. Letra inicial: ('" + read.charAt(0)
                        + "')\u001B[0m");
                System.out.println(msg);
            }
        }

    }

    public static void repetir() {
        String repeat;

        do {

            exercício();

            System.out.println("\n"
                    + "\u001B[36mPressione x para tentar novamente, ou qualquer outra tecla para finalizar...\u001B[0m");

            repeat = sc.nextLine().trim().toLowerCase();
        } while (repeat.equals("x"));
        sc.close();
    }
}
