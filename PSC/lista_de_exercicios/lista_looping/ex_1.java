// Faça um programa que peça uma nota, entre zero e dez. Mostre uma mensagem caso o valor seja inválido e continue pedindo até que o usuário informe um valor válido.

package PSC.lista_de_exercicios.lista_looping;

import java.util.Scanner;

public class ex_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            int nota = 0;

            while (true) {
                System.out.println("\n"+"\u001B[36mInsira uma nota de 0 a 10: \u001B[0m");
                String read = sc.nextLine().trim();
                System.out.println("");

                try {
                    nota = Integer.parseInt(read);
                    if (nota >= 0 && nota <= 10) {
                        System.out.println("\n"
                                + "\u001B[36mNota escolhida: " + nota + "\u001B[0m");
                        break;
                    } else {
                        System.out.println("\u001B[31mValor fora do intervalo 0-10.\u001B[0m");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("\u001B[31m" + "Entrada inválida" + "('" + read + "')" + "\u001B[0m \n");
                }
            }

            System.out.println("\n"
                    + "\u001B[36mPressione x para tentar novamente, ou qualquer outra tecla para finalizar...\u001B[0m");

            repeat = sc.nextLine().trim().toLowerCase();
        } while (repeat.equals("x"));
    
        sc.close();
    }
}
