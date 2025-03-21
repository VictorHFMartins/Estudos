// Crie um programa que imprima 11 vezes a frase " Hello World!" utilizando uma estrutura sequencial e uma estrutura de repetição while.

package PSC.lista_de_exercicios.lista_while;

public class ex_1 {
    public static void main(String[] args) {

        int cont = 0;

        while(cont < 11){
            cont++;
            System.out.println(cont +"º," + " Hello world");
        }
    }
}
