//Tendo as variáveis salario, ir e salliq, e considerando os valores abaixo, informe se as expressões são verdadeiras ou falsas:
//Salario   IR  Salliq  Expressão                      V/F
// 100      0    100    (salliq >= 100)             Verdadeiro
// 200      10   190    (salliq < 190)                Falso
// 300      15   285    (salliq = salario + ir)       Falso


import java.util.Scanner;

public class ex_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double salario = 0, ir = 0, salliq = 0;
        boolean res = false;
        String repeat;

        do {
            System.out.println("A veracidade da expressão é: " + conta(salario, ir, salliq, res));
           
            System.out.println("Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            repeat = sc.nextLine().toLowerCase();
         } while (repeat.equals("x"));

        sc.close();
    }

    public static boolean conta(double x, double y, double z, boolean k) {

        Scanner sc = new Scanner(System.in);
        double cont = 0;

        System.out.println("insira o valor para Salário");
        x = sc.nextDouble();
        System.out.println("insira o valor para IR");
        y = sc.nextDouble();
        System.out.println("insira o valor para Selliq");
        z = sc.nextDouble();

        cont = x - y;

        k = (z == cont);

        return k;
    }

}
