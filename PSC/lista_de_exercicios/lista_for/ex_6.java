// Ler 10 números e imprimir quantos são pares e quantos são ímpares.

package PSC.lista_de_exercicios.lista_for;

import java.util.Scanner;

public class ex_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            int numero = 0;
            int par = 0;
            int impar = 0;

            for (int i = 0; i < 10;) {

                System.out.println("\u001B[36mInsira um número: \u001B[0m");
                String read = sc.nextLine().trim();
                System.out.println("");

                try {
                    numero = Integer.parseInt(read);
                    if (numero % 2 == 0) {
                        par++;
                    } else {
                        impar++;
                    }
                    i++;

                } catch (NumberFormatException e) {
                    System.out.println("\u001B[31m" + "Entrada inválida" + "('" + read + "')" + "\u001B[0m \n");
                }
            }

            System.out.println("\n"
                    + "\u001B[36mHouveram " + par + " números pares, e " + impar + " números ímpares.\n"
                    + "\u001B[0m");

            System.out.println("\n"
                    + "\u001B[36mPressione x para tentar novamente, ou qualquer outra tecla para finalizar...\u001B[0m");
            repeat = sc.nextLine().trim().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();
    }
}
