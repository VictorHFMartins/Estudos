// Peça ao usuário inserir um número inteiro e imprima o seu antecessor;

package PSC.lista_de_exercicios.lista_operadores;

import java.util.Scanner;

public class ex_7 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            int input = 0;
            int antecessor = 0;
            boolean value = false;

            while (!value) {
                System.out.println("Insira um número inteiro: ");
                String read = sc.nextLine().trim();

                try {
                    input = Integer.parseInt(read);
                    antecessor = input-1;
                    value = true;

                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }
            }

            System.out.println("O antecessor de " + input + " é: " + antecessor + ".");

            System.out.println("Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            repeat = sc.nextLine().trim().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();
    }
}
