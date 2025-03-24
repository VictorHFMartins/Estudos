//Crie um programa que calcula o fatorial de um número. Mas o incremento do for deve ser regressivo.

package PSC.lista_de_exercicios.lista_for;

import java.util.Scanner;

public class ex_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            int input = 0;
            boolean value = false;

            while (!value) {
                System.out.println("digite um número para o calculo de fatorial.");
                String read = sc.nextLine().trim();
                System.out.println("");

                try {

                    input = Integer.parseInt(read);
                    value = true;

                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }
            }

            long fatorial = 1;
            for (int i = input; i > 1; i--) {
                System.out.print(fatorial + "*" + i);
                fatorial *= i;
                System.out.println(" = " + fatorial);
            }

            System.out.println("\nO fatorial do seu número é: " + fatorial + ".");

            System.out.println("Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            repeat = sc.nextLine().trim().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();
    }
}
