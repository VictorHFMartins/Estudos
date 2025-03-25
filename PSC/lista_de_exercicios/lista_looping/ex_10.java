// Faça um programa que receba dois números inteiros e gere os números inteiros que estão no intervalo compreendido por eles.

package PSC.lista_de_exercicios.lista_looping;

import java.util.Scanner;

public class ex_10 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {
        int num1 = validar("insira o primeiro numero: ");
        int num2 = validar("insira o segundo numero: ");

        int menor = Math.min(num1, num2);
        int maior = Math.max(num1, num2);

        if (menor == maior) {
            System.out.println("números são iguais.");
            return;
        } else if (maior - menor == 1) {
            System.out.println("números são consecutivos, então não a sequência entre eles.");
        }

        System.out.println("\u001B[32mNúmeros entre " + menor + " e " + maior + ":\u001B[0m");

        for (int i = menor + 1; i < maior; i++) {
            if (i == maior - 1) {
                System.out.println(i + ".");
            } else {
                System.out.print(i + ", ");
            }
        }
    }

    public static int validar(String msg) {
        while (true) {
            System.out.println("\u001B[36m" + msg + "\u001B[0m ");
            String entrada = sc.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mEntrada inválida. Por favor, insira um número inteiro válido.\u001B[0m");
            }
        }

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
