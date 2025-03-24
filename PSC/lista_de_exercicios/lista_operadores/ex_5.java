// Peça ao usuário inserir a temperatura em °C e imprima a temperatura em °F:
// F=C*95+32

package PSC.lista_de_exercicios.lista_operadores;

import java.util.Scanner;

public class ex_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;
        do {
            double input = 0;
            boolean value = false;

            while (!value) {
                System.out.println("Insira a temperatura em ºC: (Insira somente os números)");
                String read = sc.nextLine().trim();

                try {
                    input = Double.parseDouble(read);
                    value = true;

                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }

            }
            Double conversao = input * (9.0 / 5.0) + 32;
            System.out.println("A temperatura de " + input + "ºC, em Fahrenheit é: " + String.format("%.2f", conversao) + "ºF");

            System.out.println("Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            repeat = sc.nextLine().trim().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();
    }
}
