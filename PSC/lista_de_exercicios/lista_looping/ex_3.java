// Faça um programa que leia e valide as seguintes informações:
// Nome: maior que 3 caracteres;
// Idade: entre 0 e 150;
// Salário: maior que zero;
// Sexo: 'f' ou 'm';
// Estado Civil: 's', 'c', 'v', 'd';

package PSC.lista_de_exercicios.lista_looping;

import java.util.Scanner;

public class ex_3 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        looping();
    }

    public static void exercício() {

        System.out.println("\u001B[36mInsira seu nome: \u001B[0m");
        String nome = validarNome(sc.nextLine().trim());
        System.out.println("\u001B[36mInsira sua idade: (0-150 anos) \u001B[0m");
        int idade = validarIdade(sc.nextLine());
        System.out.println("\u001B[36mInsira o dígito do seu sexo: (m/f)\u001B[0m");
        String sexo = validarSexo(sc.nextLine().trim());
        System.out.println("\u001B[36mInsira o dígito do seu Estado Civil: "
                + "(s - Solteiro, c - Casado, v - Viúvo, d - Divorciado)\u001B[0m");
        String ec = validarEstadoCivil(sc.nextLine().trim());
        System.out.println("\u001B[36mInsira o valor de seu salário: \u001B[0m");
        double salario = validarSalario(sc.nextLine());

        System.out.println("\u001B[32mSeu nome é: " + nome + ", " + idade + " anos, " + "do sexo: " + sexo + ", " + ec
                + " e com renda mensal de: R$ " + String.format("%.2f", salario) + "\u001B[0m");

    }

    public static String validarNome(String nome) {

        while (nome.length() <= 3 || !nome.matches("^[\\p{L} ]+$")) {
            System.out.println(
                    "\u001B[31mEntrada inválida. O nome deve ao menos mais de três caracteres e conter apenas letras.\u001B[0m");
            System.out.println("\u001B[36mInsira seu nome: \u001B[0m");
            nome = sc.nextLine().trim();
        }

        return nome;
    }

    public static String validarSexo(String sexo) {
        sexo = sexo.toLowerCase();

        while (!sexo.equals("m") && !sexo.equals("f")) {
            System.out.println("\u001B[31mEntrada inválida.\u001B[0m");
            System.out.println("\u001B[36mInsira o dígito do seu sexo: (m/f)\u001B[0m");

            sexo = sc.nextLine().trim().toLowerCase();
        }
        String estado = "";
        switch (sexo) {
            case "f":
                estado = "feminino";
                break;
            case "m":
                estado = "masculino";
                break;
            default:
                break;
        }
        return estado;
    }

    public static String validarEstadoCivil(String ec) {
        ec = ec.toLowerCase();

        while (!ec.equals("s") && !ec.equals("c") && !ec.equals("v") && !ec.equals("d")) {
            System.out.println("\u001B[31mEntrada inválida.\u001B[0m");
            System.out.println("\u001B[36mInsira o dígito do seu Estado Civil: "
                    + "(s - Solteiro, c - Casado, v - Viúvo, d - Divorciado)\u001B[0m");
            ec = sc.nextLine().trim().toLowerCase();
        }

        String estado = "";
        switch (ec) {
            case "s":
                estado = "solteiro";
                break;
            case "c":
                estado = "casado";
                break;
            case "d":
                estado = "divorciado";
                break;
            case "v":
                estado = "viúvo";
                break;
            default:
                break;
        }

        return estado;
    }

    public static int validarIdade(String read) {
        int idade = 0;

        while (true) {
            try {
                idade = Integer.parseInt(read);

                if (idade >= 0 && idade <= 150) {
                    break;
                } else {
                    System.out.println("\n\u001B[31mEntrada inválida. Idade fora da faixa de validação.\u001B[0m");
                    System.out.println("\u001B[36mInsira sua idade: (0-150 anos) \u001B[0m");
                    read = sc.nextLine().trim();

                }
            } catch (NumberFormatException e) {
                System.out.println(
                        "\n\u001B[31mEntrada inválida.\u001B[0m");
                System.out.println("\u001B[36mInsira sua idade: (0-150 anos) \u001B[0m");
                read = sc.nextLine().trim();

            }
        }

        return idade;
    }

    public static double validarSalario(String read) {
        double salario = 0;

        while (true) {

            try {
                salario = Double.parseDouble(read);
                if (salario > 0) {
                    break;
                } else {
                    System.out.println("\n\u001B[31mSalario não pode ser negativo.\u001B[0m");
                    System.out.println("\u001B[36mInsira o valor de seu salário: \u001B[0m");
                    read = sc.nextLine().trim();
                }

            } catch (NumberFormatException e) {
                System.out.println("\n\u001B[31mEntrada inválida\u001B[0m");
                System.out.println("\u001B[36mInsira o valor de seu salário: \u001B[0m");
                read = sc.nextLine().trim();
            }
        }
        if (salario < 100) {
            salario = salario*1000;
        }
        
        return salario;
    }

    public static void looping() {
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
