// Altere o programa anterior permitindo ao usuário informar as populações e as taxas de crescimento iniciais. Valide a entrada e permita repetir a operação.

package PSC.lista_de_exercicios.lista_looping;

import java.util.Scanner;

public class ex_5 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {

        double paisA = validação("insira uma quantidade de habitantes para o país A");
        double paisB = validação("insira uma quantidade de habitantes para o país B");
        double taxaA = validação("insira uma taxa de crescimento populacional para o país A") / 100.0;
        double taxaB = validação("insira uma taxa de crescimento populacional para o país B") / 100.0;
        int anos = 0;

        if (paisA < paisB && taxaA <= taxaB) {
            System.out.println("\u001B[31mO país A nunca alcançará o país B com essa taxa de crescimento.\u001B[0m");
            return;
        } else if (paisB < paisA && taxaB <= taxaA) {
            System.out.println("\u001B[31mO país B nunca alcançará o país A com essa taxa de crescimento.\u001B[0m");
            return;
        } else if (paisA < paisB) {
            while (paisA <= paisB) {
                paisA += paisA * taxaA;
                paisB += paisB * taxaB;
                anos++;
            }
            System.out.println("\n\u001B[32mO pais A demorou cerca de " + "\u001B[33m" + anos + "\u001B[32m"
                    + " anos para alcançar a mesma ordem de habitantes que o pais B, com " + "\u001B[33m"
                    + String.format("%.0f", paisA) + "\u001B[32m" + " habitantes.\u001B[0m");
        } else if (paisA > paisB) {
            while (paisA >= paisB) {
                paisA += paisA * taxaA;
                paisB += paisB * taxaB;
                anos++;
            }
            System.out.println("\n\u001B[32mO pais B demorou cerca de " + "\u001B[33m" + anos + "\u001B[32m"
                    + " anos para alcançar a mesma ordem de habitantes que o pais A, com " + "\u001B[33m"
                    + String.format("%.0f", paisA) + "\u001B[32m" + " habitantes.\u001B[0m");
        } else {
            System.out.println("\u001B[31mOs países já estão em igualdade populacional.\u001B[0m");
        }
    }

    public static double validação(String msg) {

        double item;
        System.out.println("\n\u001B[36m" + msg + "\u001B[0m");

        while (true) {
            String read = sc.nextLine().trim();

            try {
                item = Double.parseDouble(read.replace("%", "").replace(",", "."));
                if (item > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(
                        "\u001B[31mEntrada inválida, por favor, insira um número válido maior que zero.\u001B[0m");
                System.out.println("\u001B[36m" + msg + "\u001B[0m");
            }
        }

        return item;
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
