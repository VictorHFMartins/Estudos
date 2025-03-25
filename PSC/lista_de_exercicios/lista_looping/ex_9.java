// Faça um programa que imprima na tela apenas os números ímpares entre 1 e 50.

package PSC.lista_de_exercicios.lista_looping;

import java.util.Scanner;

public class ex_9 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {
        for (int i = 1; i <= 50; i++) {
            if (i % 2 != 0) {
                if (i < 49) {
                    System.out.print("\u001B[32m" + i + ", \u001B[0m");
                } else {
                    System.out.println("\u001B[32m" + i + ".\u001B[0m");
                }
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
