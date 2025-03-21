// Tendo como dados de entrada a altura e o sexo de uma pessoa, construa um programa que calcule seu peso ideal utilizando as seguintes fórmulas:
// Homens: Peso Ideal = (72,7 * altura) - 58
// Mulheres: Peso Ideal = (62,1 * altura) – 44,7

import java.util.Scanner;

public class ex_5 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double altura;

        
        String repeat;

        do {
            System.out.println("Você é homem ou mulher?");
            System.out.println("Insira sua resposta: Homem/Mulher...");
            String sexo = sc.next().toLowerCase();

            while (!sexo.equals("homem") && !sexo.equals("mulher")) {
                System.out.println("Entrada inválida");
                System.out.println("Insira sua resposta Homem/Mulher...");
                sexo = sc.next().toLowerCase();
            }

            if (sexo.equals("homem")) {
                altura = hasdouble("Insira sua altura:");
                System.out.println("você é homem, eu peso ideal é: " + ((altura * 72.7) - 58));

            } else if (sexo.equals("mulher")) {

                altura = hasdouble("Insira sua altura:");
                System.out.println("Você é mulher, e seu peso ideal é: " + ((altura * 62.1) - 44.7));
            }

            System.out.println("Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            sc.nextLine();
            repeat = sc.nextLine().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();

    }

    public static double hasdouble(String msg) {

        System.out.println(msg);

        while (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida, por favor, inserir um número real.");
            sc.next();
            System.out.println(msg);
        }

        return sc.nextDouble();
    }
}
