// Tem-se um conjunto de dados contendo a altura e o sexo (masculino, feminino) de 10 pessoas. Fazer um algoritmo que calcule e escreva:
// A maior e a menor altura do grupo;
// Média de altura dos homens;
// O número de mulheres.

package PSC.lista_de_exercicios.lista_primeiros_desafios.exercício_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ex_1 {
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();

    public static void main(String[] args) {
        repetir();
    }

    public static void exercício() {
        double mediaAlturaM = 0;
        double mediaAlturaF = 0;
        int qtdM = 0;
        int qtdF = 0;
        double maiorAltura = Double.MIN_VALUE;
        double menorAltura = Double.MAX_VALUE;

        ArrayList<Pessoa> arr = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String sexo = geradorDeSexo();
            String nome = geradorDeNomes(sexo);
            Pessoa p = Pessoa.criarPessoa(nome, sexo, geradorDeAltura(sexo));
            arr.add(p);
        }

        double acumulador1 = 0;
        double acumulador2 = 0;

        for (Pessoa pessoa : arr) {
            maiorAltura = Math.max(maiorAltura, pessoa.getAltura());
            menorAltura = Math.min(menorAltura, pessoa.getAltura());

            if (pessoa.getSexo().equals("masculino")) {
                qtdM++;
                acumulador1 += pessoa.getAltura();
            } else if (pessoa.getSexo().equals("feminino")) {
                qtdF++;
                acumulador2 += pessoa.getAltura();
            }
        }

        if (qtdM > 0)
            mediaAlturaM = acumulador1 / qtdM;
        if (qtdF > 0)
            mediaAlturaF = acumulador2 / qtdF;

        System.out.printf("A maior altura do grupo é de: %.2f metros, e a menor é: %.2f metros.%n", maiorAltura,
                menorAltura);

        if (qtdM > 0) {
            System.out.printf("A média de altura entre os homens é de: %.2f metros.%n", mediaAlturaM);
            System.out.println("O número de homens é de: " + qtdM + ".");
        } else {
            System.out.println("Não há registros de homens.");
        }

        if (qtdF > 0) {
            System.out.printf("A média de altura entre as mulheres é de: %.2f metros.%n", mediaAlturaF);
            System.out.println("O número de mulheres é de: " + qtdF + ".");
        } else {
            System.out.println("Não há registros de mulheres.");
        }
    }

    public static double geradorDeAltura(String sexo) {
        double media = sexo.equalsIgnoreCase("f") ? 1.75 : 1.62;
        double desvio = 0.8;
        double altura;
        do {
            altura = media + desvio * rd.nextGaussian();
        } while (altura < 1.40 || altura > 2.10);

        return altura;
    }

    public static String geradorDeSexo() {

        String[] sigla = { "m", "f" };

        Random rand = new Random();
        String sexo = sigla[rand.nextInt(sigla.length)];

        return sexo;
    }

    public static String geradorDeNomes(String sexo) {

        String[] masculinos = {
                "Bruno", "Carlos", "Eduardo", "Gabriel", "Igor",
                "João", "Kleber", "Marcos", "Otávio", "Rafael", "Thiago"
        };

        String[] femininos = {
                "Ana", "Daniela", "Fernanda", "Helena", "Juliana",
                "Lívia", "Natália", "Paula", "Sabrina", "Viviane"
        };

        String[] sobrenomes = {
                "Silva", "Santos", "Oliveira", "Souza", "Pereira",
                "Costa", "Almeida", "Ferreira", "Rodrigues", "Martins",
                "Barbosa", "Gomes", "Araújo", "Lima", "Rocha",
                "Monteiro", "Melo", "Nascimento", "Ribeiro", "Teixeira"
        };

        Random rd = new Random();

        String primeiroNome;
        if (sexo.equalsIgnoreCase("m")) {
            primeiroNome = masculinos[rd.nextInt(masculinos.length)];
        } else {
            primeiroNome = femininos[rd.nextInt(femininos.length)];
        }

        String sobrenome = sobrenomes[rd.nextInt(sobrenomes.length)];

        return primeiroNome + " " + sobrenome;
    }

    public static void repetir() {
        String repeat;

        do {

            exercício();

            System.out.println("\n"
                    + "\u001B[36mPressione x para tentar novamente, ou qualquer outra tecla para finalizar...\u001B[0m");

            repeat = sc.nextLine().trim().toLowerCase();
        } while (repeat.equals("x"));
        sc.close();
    }
}
