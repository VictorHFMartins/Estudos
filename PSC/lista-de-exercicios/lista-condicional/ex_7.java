// Faça um programa de resultado de exames em que o usuário digitará Nome, idade, sexo biológica e quantidade de hemoglobina em g/gL. O programa deverá, com base na tabela abaixo, informar se o resultado está normal ou se há alguma alteração.

// Crianças de 2 a 6 anos
// 11,5 a 13,5 g/dL
// ---------------------------
// Crianças de 6 a 12 anos
// 11,5 a 15,5 g/dL
// ---------------------------
// Homens
// 14 a 18 g/dL
// ---------------------------
// Mulheres
// 12 a 16 g/dL
// ---------------------------
// Grávidas
// 11 g/dL

import java.util.Scanner;

public class ex_7 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String repeat;
        String nome, genero;
        int idade;
        double qtdHemoglobina;

        do {
            nome = hasString("Digite seu nome completo:");
            genero = hasString("Você é homem ou mulher?");

            while (!genero.equals("homem") && !genero.equals("mulher")) {
                System.out.println("Entrada inválida");
                genero = hasString("Você é homem ou mulher?");
            }

            idade = hasInt("Digite sua idade:");
            qtdHemoglobina = hasDouble("Resultado do exame de hemoglobina:");
            sc.nextLine();

            System.out.println("");
            calculo(genero, idade, qtdHemoglobina);

            System.out.println("Seu nome é " + nome + ", " + genero + ", " + idade + " anos. "
                    + "Resultado do exame atestado: " + qtdHemoglobina + " g/dL.");

            System.out.println("\n" + "Pressione x para tentar novamente, ou qualquer outra tecla para finalizar...");
            repeat = sc.nextLine().toLowerCase();
            System.out.println("");

        } while (repeat.equals("x"));

        sc.close();
    }

    public static void calculo(String genero, int idade, double qtdHemoglobina) {
        if (idade >= 2 && idade < 6) {
            if (qtdHemoglobina > 13.5) {
                System.out.println("Niveis de hemoglobina g/dL acima do normal. (niveis esperados: 11,5 a 13,5 g/dL)");
            } else if (qtdHemoglobina < 11.5) {
                System.out.println("Niveis de hemoglobina g/dL abaixo do normal. (niveis esperados: 11,5 a 13,5 g/dL)");
            } else {
                System.out.println("Niveis de hemoglobina g/dL dentro do normal.");
            }
        } else if (idade >= 6 && idade < 12) {
            if (qtdHemoglobina > 15.5) {
                System.out.println("Niveis de hemoglobina g/dL acima do normal. (niveis esperados: 11,5 a 15,5 g/dL)");
            } else if (qtdHemoglobina < 11.5) {
                System.out.println("Niveis de hemoglobina g/dL abaixo do normal. (niveis esperados: 11,5 a 15,5 g/dL)");
            } else {
                System.out.println("Niveis de hemoglobina g/dL dentro do normal.");
            }
        }

        if (genero.equals("homem")) {
            if (idade > 12) {
                if (qtdHemoglobina > 18) {
                    System.out.println("Niveis de hemoglobina g/dL acima do normal. (niveis esperados: 14 a 18 g/dL)");
                } else if (qtdHemoglobina < 14) {
                    System.out.println("Niveis de hemoglobina g/dL abaixo do normal. (niveis esperados: 14 a 18 g/dL)");
                } else {
                    System.out.println("Niveis de hemoglobina g/dL dentro do normal.");
                }
            }
        } else if (genero.equals("mulher")) {

            if (idade > 12) {

                String resposta = hasString("Você está gravida? Sim/Não");

                while (!resposta.trim().toLowerCase().equals("sim") && !resposta.trim().toLowerCase().equals("não")) {
                    System.out.println("Entrada inválida");
                    resposta = hasString("Você está gravida? Sim/Não");
                }

                if (resposta.trim().toLowerCase().equals("sim")) {
                    System.out.println("\n" + "A paciente é gestante.");
                    if (qtdHemoglobina > 11) {
                        System.out.println("Niveis de hemoglobina g/dL acima do normal. (niveis esperados: 11 g/dL)");
                    } else if (qtdHemoglobina < 11) {
                        System.out.println("Niveis de hemoglobina g/dL abaixo do normal. (niveis esperados: 11 g/dL)");
                    } else {
                        System.out.println("Niveis de hemoglobina g/dL dentro do normal.");
                    }

                } else if (resposta.equals("não")) {
                    if (qtdHemoglobina > 16) {
                        System.out.println(
                                "Niveis de hemoglobina g/dL acima do normal. (niveis esperados: 12 a 16 g/dL)");
                    } else if (qtdHemoglobina < 12) {
                        System.out.println(
                                "Niveis de hemoglobina g/dL abaixo do normal. (niveis esperados: 12 a 16 g/dL)");
                    } else {
                        System.out.println("Niveis de hemoglobina g/dL dentro do normal.");
                    }
                }
            }
        }
    }

    public static double hasDouble(String msg) {

        System.out.println(msg);
        System.out.println("Somente os números, por favor...");

        while (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida, por favor, inserir um número real.");
            sc.next();
            System.out.println(msg);
        }

        double valor = sc.nextDouble();
        return valor;
    }

    public static int hasInt(String msg) {

        System.out.println(msg);
        System.out.println("Somente os números, por favor...");

        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida, por favor, inserir um número real.");
            sc.next();
            System.out.println(msg);
        }

        int valor = sc.nextInt();
        return valor;
    }

    public static String hasString(String msg) {

        System.out.println(msg);
        String resp = sc.nextLine().trim().toLowerCase();

        while (resp.isEmpty() || !resp.matches("^[a-zA-Zá-úÁ-Ú\\s]+$")) {
            System.out.println("Entrada inválida, por favor, inserir seu nome corretamente.");
            System.out.println(msg);
            resp = sc.nextLine().trim().toLowerCase();
        }

        return resp;
    }
}
