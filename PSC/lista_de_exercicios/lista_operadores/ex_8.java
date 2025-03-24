// Peça ao usuário inserir seu ano de nascimento e imprima sua idade;

package PSC.lista_de_exercicios.lista_operadores;

import java.time.LocalDate;
import java.util.Scanner;

public class ex_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hoje = LocalDate.now().getYear();
        String repeat;

        do {
            int input = 0;
            boolean value = false;

            while (!value) {
                System.out.println("Insira o seu ano de nascimento: (19xx - 2xxx) ");
                String read = sc.nextLine().trim();

                if (read.matches("^\\d{4}$") || read.matches("^\\d{1,2}\\.\\d{3}$")) {
                    try {
                        input = Integer.parseInt(read.replace(".", ""));
                        value = true;

                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida.");
                    }
                } else {
                    System.out.println("Entrada inválida.");
                }
            }

            System.out.println("Caso você ja tenha feito aniversário esse ano, você terá: " + (hoje - input) + " anos.");

            System.out.println("Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            repeat = sc.nextLine().trim().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();
    }
}
