//Faça um programa que leia um número inteiro e retorna ao usuário uma mensagem informando se o número é par ou ímpar e se é positivo ou negativo.

import java.util.Scanner;

public class ex_4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String repeat;
        
        do {

            System.out.println("Insira um número inteiro: ");
    
            while(!sc.hasNextInt()){   
                System.out.println("Entrada inválida. Por favor, insira somente números inteiros.");     
                sc.next();
                System.out.println("Insira um número inteiro: ");

            }
        
            int input = sc.nextInt();
            sc.nextLine();
          
            if (input%2==0){
                System.out.println("Número é par");
            }else{
                System.out.println("Número é impar");
            }
           
            System.out.println("Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            repeat = sc.nextLine().toLowerCase();

        } while (repeat.equals("x"));

        sc.close();

    }
}