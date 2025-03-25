// Supondo que a população de um país A seja da ordem de 80000 habitantes com uma taxa anual de crescimento de 3% e que a população de B seja 200000 habitantes com uma taxa de crescimento de 1.5%. Faça um programa que calcule e escreva o número de anos necessários para que a população do país A ultrapasse ou iguale a população do país B, mantidas as taxas de crescimento.

package PSC.lista_de_exercicios.lista_looping;

import java.util.Scanner;

public class ex_4 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {
        double paisA = 80000;
        double paisB = 200000;
        double taxaA = 0.03;
        double taxaB = 0.015;
        int anos = 0;

        while (paisA <= paisB) {
            paisA += paisA * taxaA;
            paisB += paisB * taxaB;
            anos++;
        }
        System.out.println("\n\u001B[32mO paisA demorou cerca de " + "\u001B[33m" + anos + "\u001B[32m"
                + " anos para alcançar a mesma ordem de habitantes que o paisB, com " + "\u001B[33m"
                + String.format("%.0f", paisA) + "\u001B[32m" + " habitantes.\u001B[0m");
    }

    public static void repetir() {
        String repeat;

        do {

            exercício();

            System.out.println("\n"
                    + "\u001B[36mPressione x para tentar novamente, ou qualquer outra tecla para finalizar...\u001B[0m");

            repeat = sc.nextLine().trim().toLowerCase();
        } while (repeat.equals("x"));
        sc.close();
    }

}
