// Faça um programa que imprima na tela os números de 1 a 20, um abaixo do outro. Depois modifique o programa para que ele mostre os números um ao lado do outro.

package PSC.lista_de_exercicios.lista_looping;

import java.util.Scanner;

public class ex_6 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {
        int rep = 0;

        while (rep != 2) {
            if (rep == 0) {
                System.out.println("\n\u001B[32mItens organizados um a baixo do outro: \u001B[0m");
                for (int i = 1; i <= 20; i++) {
                    System.out.println(i);
                }
            } else if (rep == 1) {
                System.out.println("\n\u001B[32mItens organizados um ao lado do outro: \u001B[0m");
                for (int i = 1; i <= 20; i++) {
                    if (i == 20) {
                        System.out.println(i + ".");
                    } else if (i < 20) {
                        System.out.print(i + ", ");
                    }
                }
            }
            rep++;
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
