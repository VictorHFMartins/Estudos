// Neste exercício você deverá projetar um programa que imprime na tela números de 1 a 100, mas:
// Sempre que o número for divisível por 3, aparece fizz. 
// Sempre que um número for divisível por 5, aparece buzz.
// Quando for divisível pelos 2, aparece Fizz Buzz.

package PSC.lista_de_exercicios.lista_for;

import java.util.Scanner;

public class ex_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            System.out.println("");

            for (int i = 1; i <= 100; i++) {

                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("\u001B[33m" + i + " - fizzbuzz\u001B[0m");
                } else if (i % 5 == 0) {
                    System.out.println("\u001B[34m" + i + " - buzz\u001B[0m");
                } else if (i % 3 == 0) {
                    System.out.println("\u001B[35m" + i + " - fizz\u001B[0m");
                } else
                    System.out.println("\u001B[32m" + i + "\u001B[0m");
            }

            System.out.println("\n"
                    + "\u001B[36mPressione x para tentar novamente, ou qualquer outra tecla para finalizar...\u001B[0m");
            repeat = sc.nextLine().trim().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();
    }
}
