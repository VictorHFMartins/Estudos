// Faça um programa que leia um nome de usuário e a sua senha e não aceite a senha igual ao nome do usuário, mostrando uma mensagem de erro e voltando a pedir as informações.

package PSC.lista_de_exercicios.lista_looping;

import java.util.Scanner;

public class ex_2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
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

    public static void exercício() {

        String user = "";
        String senha = "";

        while (true) {
            System.out.println("\n" + "\u001B[36mInsira Seu nome de usuário: \u001B[0m");
            user = sc.nextLine().trim();
            if (!user.isEmpty()) {
                System.out.println("");
                break;
            } else {
                System.out.println("\u001B[31mNome de usuário não pode ficar vazio\u001B[0m");
            }
        }

        int tentativas = 0;

        while (true) {
            if (tentativas == 0) {
                System.out.println("\n" + "\u001B[36mInsira uma senha: \u001B[0m\n"
                        + "\u001B[33mSua senha deve conter ao menos: \n"
                        + "* 8 dígitos \n"
                        + "* Pelo menos um número \n"
                        + "* Pelo menos um caractere especial \n"
                        + "* Diferenças entre letras maiusculas e minúsculas \u001B[0m");
            } else {
                System.out.println("\n\u001B[36mInsira uma senha: \u001B[0m\n");
            }

            senha = sc.nextLine().trim();

            boolean letrasMaiusculasMinusculas = senha.matches("^(?=.*[a-z])(?=.*[A-Z]).+$");
            boolean numeros = senha.matches("^(?=.*\\d).+$");
            boolean caracteresEspeciais = senha.matches("^(?=.*[\\W_]).+$");
            boolean tamanhoMinimo = senha.length() >= 8;

            if (!senha.equals(user) && letrasMaiusculasMinusculas && numeros && caracteresEspeciais
                    && tamanhoMinimo) {
                System.out.println("\n"
                        + "\u001B[32mUsuário cadastrado com sucesso\u001B[0m");
                break;
            } else if (senha.equals(user)) {
                System.out.println("\u001B[31msenha não pode ser igual ao nome de usuário.\u001B[0m");
                tentativas++;
            } else {
                System.out.println("\n" + "\u001B[31mSenha inválida\u001B[0m\n"
                        + "\u001B[33mSua senha deve conter ao menos: \u001B[0m\n");
                tentativas++;
                validar(tamanhoMinimo, "8 dígitos");
                validar(numeros, "Pelo menos um número");
                validar(caracteresEspeciais, "Pelo menos um caractere especial");
                validar(letrasMaiusculasMinusculas, "Diferenças entre letras maiusculas e minúsculas");
            }
        }

    }

    public static void validar(boolean Validação, String texto) {
        if (Validação) {
            System.out.println("\u001B[32m* " + texto + "\u001B[0m");
        } else {
            System.out.println("\u001B[31m* " + texto + "\u001B[0m");
        }
    }
}
