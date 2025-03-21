// Faça um programa para um banco de sangue em que o usuário informará qual o tipo sanguíneo de um paciente e o programa retornará que tipo de sangue este paciente pode receber.

package PSC.lista_de_exercicios.lista_condicional;

import java.util.Scanner;

public class ex_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;

        do {
            System.out.println("Insira seu tipo sanguíneo: ");
            String entrada = sc.nextLine().trim().toUpperCase();

            while (!entrada.equals("A+") && !entrada.equals("A-") &&
                    !entrada.equals("B+") && !entrada.equals("B-") &&
                    !entrada.equals("AB+") && !entrada.equals("AB-") &&
                    !entrada.equals("O+") && !entrada.equals("O-")) {

                System.out.println("Entrada inválida. Insira corretamente seu tipo sanguíneo.");
                entrada = sc.nextLine().trim().toUpperCase();
            }

            switch (entrada) {
                case "A+":
                    System.out.println("Pode doar para AB+ e A+");
                    System.out.println("Pode receber de  A+, A-, O+ e O-");
                    break;

                case "A-":
                    System.out.println("Pode doar para A+, A-, AB+ e AB-");
                    System.out.println("Pode receber de  A- e O-");
                    break;

                case "B+":
                    System.out.println("Pode doar para B+ e AB+");
                    System.out.println("Pode receber de  B+, B-, O+ e O-");
                    break;

                case "B-":
                    System.out.println("Pode doar para B+, B-, AB+ e AB-");
                    System.out.println("Pode receber de  B- e O-");
                    break;

                case "AB+":
                    System.out.println("Pode doar para AB+");
                    System.out.println("Pode receber de  todos");
                    break;

                case "AB-":
                    System.out.println("Pode doar para AB+ e AB-");
                    System.out.println("Pode receber de  A-, B-, O- e AB-");
                    break;

                case "O+":
                    System.out.println("Pode doar para A+, B+, O+ e AB+");
                    System.out.println("Pode receber de  O+ e O-");
                    break;

                case "O-":
                    System.out.println("Pode doar para todos");
                    System.out.println("Pode receber de  O-");
                    break;
            }

            System.out.println("\n" + "Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            repeat = sc.nextLine().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();

    }
}