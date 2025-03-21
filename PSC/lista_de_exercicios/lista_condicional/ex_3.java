//Sabendo que a = 5, b = 4, c = 3 e d = 6, informe se as expressões abaixo são verdadeiras ou falsas:

//a. (a > c) AND (c <= d)
//b. (a + b) > 10 OR (a + b) == (c + +d)
//c. (a >= c) AND (d >= c)

package PSC.lista_de_exercicios.lista_condicional;

public class ex_3 {
    public static void main(String[] args) {
        int a, b, c, d;

        a = 5;
        b = 4;
        c = 3;
        d = 6;

        boolean contagem[] = new boolean[3];

        for (int i = 0; i < contagem.length; i++) {

            contagem[0] = ((a > c) && (c <= d));
            contagem[1] = ((a + b) > 10 || (a + b) == (c + d));
            contagem[2] = ((a >= c) && (d >= c));
            

            System.out.println("resultado " + (i + 1) + " :" + contagem[i]);
        }
    }
}
