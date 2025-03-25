// Altere o programa anterior para mostrar no final a soma dos números.

package PSC.lista_de_exercicios.lista_looping;

import java.util.Scanner;

public class ex_11 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {
        int num1 = validar("insira o primeiro numero: ");
        int num2 = validar("insira o segundo numero: ");
        int soma = num1 + num2;

        System.out.println("\u001B[32mA soma dos dois números é " + soma + "\u001B[0m");
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
