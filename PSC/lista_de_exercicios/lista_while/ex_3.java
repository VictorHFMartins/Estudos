// Crie um programa para ler 3 notas e mostrar a média delas.

package PSC.lista_de_exercicios.lista_while;

import java.util.Scanner;

public class ex_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cont = 0;
        int notas = 0;

        while (cont < 3) {
            cont++;
            System.out.println("Insira uma nota: ");
            int notaAtual;
            notaAtual = sc.nextInt();
            notas += notaAtual;
        }

        System.out.println("A média entre as " + cont + " notas, é: " + notas / cont);
        sc.close();
    }
}
