// Faça para converter a velocidade de km/h para m/s.
// vms=vhmh/3,6 

package PSC.lista_de_exercicios.lista_operadores;

import java.util.Scanner;

public class ex_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            double input = 0;
            boolean value = false;

            while (!value) {
                System.out.println("Insira a velocidade em Km/h: (Insira somente os números)");
                String read = sc.nextLine().trim();

                try {
                    input = Double.parseDouble(read);
                    value = true;

                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }

            }

            Double conversao = input / 3.6;
            System.out.println("A velocidade de " + input + " Km/h, em metros por segundo é de: "
                    + String.format("%.2f", conversao) + " m/s.");

            System.out.println("Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            repeat = sc.nextLine().trim().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();
    }
}
