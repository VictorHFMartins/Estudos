// Faça um programa que leia 5 números e informe o maior número.

package PSC.lista_de_exercicios.lista_looping;

import java.util.ArrayList;
import java.util.Scanner;

public class ex_8 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {
        ArrayList<Integer> num = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            while (true) {
                System.out.println("\u001B[36minsira um número:\u001B[0m");
                String read = sc.nextLine();

                try {
                    num.add(Integer.parseInt(read));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("\u001B[31mEntrada inválida.\u001B[0m");
                }
            }
        }

        int acumulador = 0;

        for (int i = 0; i < num.size(); i++) {
            acumulador += num.get(i);
        }

        double media = acumulador / num.size();
        System.out.println(
                "\u001B[32mA média entre os números digitados é de: " + String.format("%.0f", media) + "\u001B[0m");
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
