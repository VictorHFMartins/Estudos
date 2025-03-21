// Como pescador profissional, João tem uma cota diária de 50kg de peixe. Ele deve pesar os peixes pescados ao final de cada dia e pagar uma multa de R$ 4,00 por quilo excedente caso ultrapasse sua cota. Faça um programa que, ao informar o peso de peixes, o programa retorna o valor da multa. 

package PSC.lista_de_exercicios.lista_condicional;

import java.util.Scanner;

public class ex_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;
        double cotaDiaria = 50;
        int taxa = 4;
    
        do {
            System.out.println("informe o peso dos peixes: ");
    
            while (!sc.hasNextDouble()) {
                System.out.println("Entrada inválida. Por favor, insira um número real");
                sc.next();
                System.out.println("informe o peso dos peixes: ");
            }
    
            double peso = sc.nextDouble();

            if (peso > cotaDiaria) {
                double excedente = peso - cotaDiaria;

                System.out.println("O valor da multa é equivalente à: " + excedente * taxa);
            } else {
                System.out.println("Pesca em conformidade com a cota diária, sem multas.");
            }

            System.out.println("Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            sc.nextLine();
            repeat = sc.nextLine().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();

    }
}
