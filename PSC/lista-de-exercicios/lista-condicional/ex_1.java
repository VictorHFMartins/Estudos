//Tendo as variáveis salario, ir e salliq, e considerando os valores abaixo, informe se as expressões são verdadeiras ou falsas:
//Salario   IR  Salliq  Expressão                      V/F
// 100      0    100    (salliq >= 100)             Verdadeiro
// 200      10   190    (salliq < 190)                Falso
// 300      15   285    (salliq = salario + ir)       Falso

import java.util.Scanner;

public class ex_1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String repeat;

        do {
            System.out.println("A veracidade da expressão é: " + conta());

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

    public static boolean conta() {
        double x, y, z;

        x = hasdouble("insira o valor para Salário");
        y = hasdouble("insira o valor para IR");
        z = hasdouble("insira o valor para Selliq");

        double cont = x - y;

        return (z == cont);
    }

}
