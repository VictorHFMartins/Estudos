// Peça ao usuário para digitar três valores inteiros e imprima a soma deles;

package PSC.lista_de_exercicios.lista_operadores;

import java.util.Scanner;

public class ex_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            int resp = 0;
            boolean value = false;
            int contador = 0;

            while (!value || contador < 3) {

                System.out.println("Insira um número Real: ");
                String read = sc.nextLine().trim();

                try {
                    int acumulador = Integer.parseInt(read);

                    contador++;
                    resp += acumulador;
                    value = true;

                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }
            }

            System.out.println("A soma dos números inserídos é: " + resp);

            System.out.println("Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            repeat = sc.nextLine().trim().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();
    }
}
