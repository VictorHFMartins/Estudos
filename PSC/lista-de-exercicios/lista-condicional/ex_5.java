// Tendo como dados de entrada a altura e o sexo de uma pessoa, construa um programa que calcule seu peso ideal utilizando as seguintes fórmulas:
// Homens: Peso Ideal = (72,7 * altura) - 58
// Mulheres: Peso Ideal = (62,1 * altura) – 44,7

import java.util.Scanner;

public class ex_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double altura;

        System.out.println("Você é homem ou mulher?");
        System.out.println("Insira sua resposta M/F...");
        String sexo = sc.nextLine().toLowerCase();   

        while (!sexo.equals("m") && !sexo.equals("f")) {
            System.out.println("Entrada inválida");
            System.out.println("Insira sua resposta M/F...");
            sexo = sc.nextLine().toLowerCase();  
        }

        if(sexo.equals("m") ){
            System.out.println("Insira sua altura:");
            while (!sc.hasNextDouble()) {
                System.out.println("Por favor, insira somente números de acordo com a sua realidade.");
                sc.next();
                System.out.println("Insira sua altura:");
            }
            altura = sc.nextDouble();
            System.out.println("Você é homem e ");
            System.out.println("Seu peso ideal é: " + ((altura*72.7)-58));

        }
        else if (sexo.equals("f") ){
            System.out.println("Insira sua altura:");
            altura = sc.nextDouble();
            System.out.println("Você é mulher e ");
            System.out.println("Seu peso ideal é: " + ((altura*62.1)-44.7));
        }
    }
}
