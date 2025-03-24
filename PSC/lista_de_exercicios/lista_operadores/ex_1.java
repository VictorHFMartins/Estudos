// Faça um programa que leia um número inteiro e o imprima;

package PSC.lista_de_exercicios.lista_operadores;

import java.util.Scanner;

public class ex_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            int input = 0;
            boolean value = false;

            while (!value) {
                System.out.println("Insira um número inteiro: ");
                String read = sc.nextLine().trim();

                try {
                    input = Integer.parseInt(read);
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
