// Faça um programa, utilizando for, que permita o usuário fazer três contas de subtração. O usuário deve conseguir reconhecer que são três contas diferentes.

package PSC.lista_de_exercicios.lista_for;

import java.util.Scanner;

public class ex_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            int minuendo = 0;
            int subtraendo = 0;
            int resto;

            for (int i = 1; i <= 3; i++) {
                System.out.println("\n" + "\u001B[36m" + i + " conta:\u001B[0m");

                while (true) {
                    System.out.println("\u001B[36mInsira um número para o Minuendo: \u001B[0m");
                    String input1 = sc.nextLine().trim();
                    System.out.println("");

                    try {
                        minuendo = Integer.parseInt(input1);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("\u001B[31m" + "Entrada inválida" + "('" + input1 + "')" + "\u001B[0m \n");
                    }
                }

                while (true) {

                    System.out.println("\u001B[36mInsira um número para o Subtraendo: \u001B[0m");
                    String input2 = sc.nextLine().trim();
                    System.out.println("");

                    try {
                        subtraendo = Integer.parseInt(input2);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("\u001B[31m" + "Entrada inválida" + "('" + input2 + "')" + "\u001B[0m \n");
                    }
                }

                resto = minuendo - subtraendo;

                if (minuendo > 0 && subtraendo > 0 || minuendo <0 && subtraendo > 0) {
                    System.out.println(
                            "\n" + "\u001B[36m" + minuendo + "-" + subtraendo + " = " + resto + "\n" + "\u001B[0m");
                } else if (minuendo > 0 && subtraendo < 0) {
                    System.out.println(
                            "\n" + "\u001B[36m" + minuendo + "-" + "(" + subtraendo + ")" + " = " + resto + "\n"
                                    + "\u001B[0m");
                } else if (minuendo < 0 && subtraendo < 0) {
                    System.out.println(
                            "\n" + "\u001B[36m" + "(" + minuendo + ")" + "-" + "(" + subtraendo + ")" + " = " + resto
                                    + "\n"
                                    + "\u001B[0m");
                }
            }

            System.out.println("\n"
                    + "\u001B[36mPressione x para tentar novamente, ou qualquer outra tecla para finalizar...\u001B[0m");
            repeat = sc.nextLine().trim().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();
    }
}
