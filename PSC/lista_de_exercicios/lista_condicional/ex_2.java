//Sabendo que a = 3, b = 7 e c = 4, informe se as expressões abaixo são verdadeiras ou falsas:
//a. (a + c) > b
//b. b > = (a + 2)
//c. c == (b – a)
//d. (b + a) < = c
//e. (c + a) > b

package PSC.lista_de_exercicios.lista_condicional;

public class ex_2 {
    public static void main(String[] args) {
        int a, b, c;

        a = 3;
        b = 7;
        c = 4;

        boolean contagem[] = new boolean[5];

        for (int i = 0; i < contagem.length; i++) {
            contagem[0] = ((a + c) > b);
            contagem[1] = (b >= (a + 2));
            contagem[2] = (c == (b - a));
            contagem[3] = ((b + a) <= c);
            contagem[4] = ((c + a) > b);

            System.out.println("resultado " + (i + 1) + " :" + contagem[i]);
        }
    }
}

