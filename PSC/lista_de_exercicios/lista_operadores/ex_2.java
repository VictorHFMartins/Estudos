// Faça um programa que leia um número real e o imprima;

package PSC.lista_de_exercicios.lista_operadores;

import java.util.Scanner;

public class ex_2 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            double input = 0;
            boolean value = false;

            while (!value) {
                System.out.println("Insira um número Real: ");
                String read = sc.nextLine().trim();

                try {
                    input = Double.parseDouble(read);
                    value = true;

                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }
            }

            System.out.println("Você digitou: " + input);

            System.out.println("Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            repeat = sc.nextLine().trim().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();
    }
}
