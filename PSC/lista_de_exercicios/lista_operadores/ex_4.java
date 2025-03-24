// Faça programa em que o usuário digita uma letra e o programa retorna o número inteiro do código UNICODE referente àquela letra.

package PSC.lista_de_exercicios.lista_operadores;

import java.util.Scanner;

public class ex_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            int unicode = 0;
            char letra = ' ';
            boolean value = false;

            while (!value) {
                System.out.println("Insira uma letra: ");
                String read = sc.nextLine().trim();

                if (read.length() == 1 || read.matches("\\p{L}")) {
                    char[] conv = read.toCharArray();
                    letra = conv[0];
                    unicode = (int) letra;
                    value = true;
                } else {
                    System.out.println("Entrada Invalida. Insira um único caractere de letra");
                }
            }

            System.out.println("Você digitou a letra: " + letra + ", e seu respectivo código Unicode é: " + unicode);

            System.out.println("Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            repeat = sc.nextLine().trim().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();
    }
}
