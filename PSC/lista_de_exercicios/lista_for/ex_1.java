//Escrever um programa para exibir os números de 1 até 50 na tela.

package PSC.lista_de_exercicios.lista_for;

public class ex_1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            if (i < 50) {
                System.out.print(i + ", ");
            } else {
                System.out.println(i + ".");
            }
        }
    }
}
