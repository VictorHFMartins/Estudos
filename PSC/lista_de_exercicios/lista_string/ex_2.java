// Faça um programa que verifica se o código inicial de um produto começa com “BEB”.

package PSC.lista_de_exercicios.lista_string;

import java.util.Scanner;

public class ex_2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {

        ValidarInicioDoCodigo("\n\u001B[36mInsira o código: \u001B[0m");
    }

    public static String ValidarInicioDoCodigo(String msg) {
        String read;
        System.out.println(msg);

        while (true) {

            read = sc.nextLine();

            if (read.charAt(0) == 'B' && read.charAt(1) == 'E' && read.charAt(2) == 'B') {
                System.out.println("\u001B[32mO código começa com os caracteres: ('" + read.charAt(0) + read.charAt(1)
                        + read.charAt(2)
                        + "')\u001B[0m");
                return read;
            } else {

                System.out.println("\u001B[31mO código não começa com os caracteres BEB. Caracteres iniciais: ('"
                        + read.charAt(0) + read.charAt(1) + read.charAt(2)
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
