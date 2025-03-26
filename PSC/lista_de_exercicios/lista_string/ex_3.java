// Faça um programa que verifica qual o último caractere digitado no texto.

package PSC.lista_de_exercicios.lista_string;

import java.util.Scanner;

public class ex_3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {
        System.out.println("\n\u001B[36mInsira um texto:\u001B[0m");
        String read = sc.nextLine();
        System.out.println("\n\u001B[32mA ultima letra descrita no seu texto é: ('" + read.charAt(read.length() - 1)
                + "')\u001B[0m");
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
