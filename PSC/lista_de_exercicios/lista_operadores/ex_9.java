// Faça um programa que calcula a área de uma circunferência com precisão de 2 casas decimais.

package PSC.lista_de_exercicios.lista_operadores;

import java.util.Scanner;

public class ex_9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            int raio = 0;
            boolean value = false;

            while (!value) {
                System.out.println("Insira o raio da circunferência em centímetros: (Somente números)");
                String read = sc.nextLine().trim();

                try {
                    raio = Integer.parseInt(read);
                    value = true;

                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }
            }

            double calculo = Math.PI * Math.pow(raio, 2);
            System.out.println("A área da circunferência é: " + String.format("%.2f", calculo) + "cm.");

            System.out.println("Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            repeat = sc.nextLine().trim().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();
    }
}
