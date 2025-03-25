// Leia várias idades e calcule a média entre as idades (usar uma variável para idade)

package PSC.lista_de_exercicios.lista_for;

import java.util.Scanner;

public class ex_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            int contador = 0;
            int acumulador = 0;

            for (;;) {
                System.out.println("\u001B[36mInsira uma idade, ou -1 para parar a solicitação.\u001B[0m");
                String read = sc.nextLine().trim();

                try {
                    int idade = Integer.parseInt(read);

                    if (idade == -1) {
                        System.out.println("\u001B[33mVocê parou a inserção.\u001B[0m");
                        break;

                    } else if (idade < -1 || idade > 120) {
                        System.out.println(
                                "\u001B[31mIdade fora da faixa permitida. (Faixa etária de 0-120 anos).\u001B[0m");

                    } else if (idade >= 0 && idade <= 120) {
                        contador++;
                        acumulador += idade;
                    }

                } catch (NumberFormatException e) {

                    System.out.println("\u001B[31m" + "Entrada inválida" + "('" + read + "')" + "\u001B[0m \n");
                }
            }

            if (acumulador == 0) {
                System.out.println("\n" + "\u001B[31mNenhuma idade inserida.\u001B[0m");
            } else {
                double media = (double) acumulador / contador;
                System.out.println("\u001B[32m" + "Média entre as " + contador + " idades: " + media + "\u001B[0m");
            }

            System.out.println("\n"
                    + "\u001B[36mPressione x para tentar novamente, ou qualquer outra tecla para finalizar...\u001B[0m");
            repeat = sc.nextLine().trim().toLowerCase();
            System.out.println("");
        } while (repeat.equals("x"));

        sc.close();
    }

}
