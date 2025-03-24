// Fazer um programa para encontrar todos os números pares entre 1 e 100.

package PSC.lista_de_exercicios.lista_for;

public class ex_3 {
    public static void main(String[] args) {
        int par = 0;
        int impar = 0;

        for (int i = 0; i < 100; i++) {

            if (i % 2 == 0) {
                par++;
            } else {
                impar++;
            }
        }
        
        System.out.println("Houveram " + par + " números pares, e " + impar + " números ímpares.");
    }
}
