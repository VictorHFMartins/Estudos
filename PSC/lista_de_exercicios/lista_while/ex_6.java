// Usando o laço while para pedir ao usuário que tente acertar um número aleatório entre 0 e 10 (incluindo) e mostrar a quantidade de tentativas feitas. Dica: Usar o comando Random numero = new Random();

package PSC.lista_de_exercicios.lista_while;

import java.util.Random;
import java.util.Scanner;

public class ex_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random nm = new Random();

        String repeat;

        do {
            int numero = nm.nextInt(11);
            int tentativas = 0;
            System.out.println("Tente adivinhar o número oculto (de 0 a 10).");
            System.out.println("digite x para cancelar a rodada a qualquer momento.");

            while (true) {

                System.out.println("Digite um número:");
                String quit = sc.nextLine().trim().toLowerCase();

                if (quit.equals("x")) {
                    System.out.println("Você encerrou o jogo.");
                    break;
                }

                int chute;
                try {
                    chute = Integer.parseInt(quit);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número ou x para sair.");
                    continue;
                }

                tentativas++;

                if (chute == numero) {
                    System.out.println("Parabéns, você acertou o número!");
                    break;
                } else {
                    System.out.println("Errou. Tente novamente!");
                }

                System.out.println("Tentativa: " + tentativas);
            }

            System.out.println(
                    "\n" + "Pressione x para tentar novamente, ou qualquer outra tecla para finalizar a aplicação...");
            repeat = sc.nextLine().toLowerCase();
            System.out.println("");

        } while (repeat.equals("x"));

        sc.close();
    }
}
