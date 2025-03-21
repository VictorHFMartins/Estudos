// O usuário vai digitar uma nota válida (de 0 até 10). O programa deverá armazenar estas notas em um acumulador. Usar uma segunda variável para contar quantas notas foram armazenadas. Ao final, quando o usuário não quiser mais lançar notas, ele pede para sair e o programa imprime na tela a média das notas.

package PSC.lista_de_exercicios.lista_while;

import java.util.Scanner;

public class ex_7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int contador = 0;
        int notas = 0;

        System.out.println("Digite x finalizar a aplicação a qualquer momento");

        while (true) {
            
            System.out.println("insira sua nota (de 0 a 10):");
            String quit = sc.nextLine().trim().toLowerCase();

            if (quit.equals("x")) {
                System.out.println("Você encerrou a aplicação.");
                break;
            }

            int novaNotas;

            try {
                novaNotas = Integer.parseInt(quit);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número ou x para sair.");
                continue;
            }
            
            if (novaNotas >= 0 && novaNotas <= 10) {
                notas += novaNotas;
                contador++;

            } else {
                System.out.println("Entrada inválida. Insira somente numeros de 0 a 10.");
            }
        }

        System.out.println("A média entre as notas descritas é: " + notas/contador);
        sc.close();
    }
}