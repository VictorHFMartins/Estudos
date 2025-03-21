// Escreva um programa com um looping indeterminado em que enquanto o usuário não pedir para o programa sair, ele continua printando um contador na tela.

package PSC.lista_de_exercicios.lista_while;

import java.util.Scanner;

public class ex_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cont = 0;
        boolean key = true;

        while(key){

            System.out.println("Digite qualquer tecla para continuar o programa \nou digite encerrar para finalizar.");
            String resp = sc.nextLine().trim().toLowerCase();

            if (resp.equals("encerrar")) {
                key = false;
                System.out.println("Você encerrou o programa.");
            }else{
                cont ++;
                System.out.println(cont);}
        }

        sc.close();
    }
}
