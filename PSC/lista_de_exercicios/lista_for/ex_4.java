// Ler um valor inteiro (aceitar somente valores entre 1 e 10) e escrever a tabuada de 1 a 10 do valor lido.

package PSC.lista_de_exercicios.lista_for;

import java.util.Scanner;

public class ex_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            boolean value = false;
            int input = 0;
            while (!value) {
                System.out.println("\u001B[36mInsira um número de 0 a 10: \u001B[0m");
                String read = sc.nextLine().trim();
                System.out.println("");

                if (read.matches("^\\d{1,2}$") && (Integer.parseInt(read) >= 0 && Integer.parseInt(read) <= 10)) {
                    try {
                        input = Integer.parseInt(read);
                        value = true;

                    } catch (NumberFormatException e) {
                        System.out.println("\u001B[31m" + "Entrada inválida" + "('" + read + "')" + "\u001B[0m \n");
                    }
                } else {
                    System.out.println("\u001B[31m" + "Entrada inválida" + "('" + read + "')" + "\u001B[0m \n");
                }
            }

            for (int i = 1; i <= 10; i++) {
                int res = input * i;
                System.out.println(("\u001B[32m" + input + "*" + i + " = " + res + "\u001B[0m"));
            }

            System.out.println("");
            System.out.println("\u001B[36mPressione x para tentar novamente, ou qualquer outra tecla para finalizar...\u001B[0m");
            repeat = sc.nextLine().trim().toLowerCase();

        } while (repeat.equals("x"));

        int input = sc.nextInt();
        System.out.println(input);

        sc.close();

    }
}
