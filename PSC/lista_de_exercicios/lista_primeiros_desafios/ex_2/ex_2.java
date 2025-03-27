// Faça um programa em que o usuário informa a altura e o comprimento de uma parede e o programa informa a quantidade de latas de tinta que devem ser compradas. Sabe-se que uma lata de tinta consegue pintar 1.6 m² de parede.

package PSC.lista_de_exercicios.lista_primeiros_desafios.ex_2;

import java.util.Random;
import java.util.Scanner;

public class ex_2 {
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {
        double rendimentoDaTinta = 1.6;

        Parede p1 = new Parede(geradorDeMedidas(), geradorDeMedidas());

        double qtdDeLatas = p1.calculoDeArea() / rendimentoDaTinta;

        System.out.printf(
                "\n\u001B[32mA quantidade necessária para pintar a parede p1 que tem %.2f de altura e %.2f de comprimento é de %.2f latas.\n\u001B[0m",
                p1.getAltura(), p1.getComprimento(), qtdDeLatas);
    }

    public static double geradorDeMedidas() {
        double medida = rd.nextDouble(10.0);

        return medida;
    }

    public static void repetir() {
        String repeat;

        do {

            exercício();

            System.out.println("\n"
                    + "\u001B[36mPressione x para tentar novamente, ou qualquer outra tecla para finalizar...\u001B[0m");
            System.out.print("\u001B[36mAguardando entrada... : \u001B[0m");

            repeat = sc.nextLine().trim().toLowerCase();
        } while (repeat.equals("x"));
        sc.close();
    }
}
