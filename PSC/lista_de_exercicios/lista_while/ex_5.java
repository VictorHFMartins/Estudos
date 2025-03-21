// Faça um programa que peça ao usuário um número entre 12 e 20. Se a pessoa digitar um número diferente, mostrar a mensagem "entrada inválida" e solicitar o número novamente. Se digitar correto mostrar o número digitado.

package PSC.lista_de_exercicios.lista_while;

import java.util.Scanner;

public class ex_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("digite um número entre o intervalo de 12 a 20:");
        int entrada = sc.nextInt();

        while (entrada < 12 || entrada > 20) {
            System.out.println("Entrada inválida.");
            System.out.println("Digite novamente: ");
            entrada = sc.nextInt();
        }

        System.out.println("Seu número é: " + entrada);
    }
}
