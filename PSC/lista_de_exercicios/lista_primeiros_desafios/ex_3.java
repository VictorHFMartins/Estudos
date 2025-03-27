// O usuário digita um texto e o corretor corrige o “m” quando aparecer alguma palavra errada. O programa deve retornar ao usuário o texto corrigido. Por exemplo: 
// Entrada: O homem está alimentando as ponbas
// Saída: O homem está alimentando as pombas

package PSC.lista_de_exercicios.lista_primeiros_desafios;

import java.util.Scanner;

public class ex_3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        repetir();
    }

    public static void exercício() {
        String[] palavrasCertas = new String[] { "exceção", "reivindicar", "beneficente" };
        String[][] palavrasErradas = new String[3][3];

        palavrasErradas[0][0] = "excessão";
        palavrasErradas[0][1] = "exessão";
        palavrasErradas[0][2] = "ecceção";

        palavrasErradas[1][0] = "revindicar";
        palavrasErradas[1][1] = "reinvidicar";
        palavrasErradas[1][2] = "reivindar";

        palavrasErradas[2][0] = "beneficiente";
        palavrasErradas[2][1] = "benefincente";
        palavrasErradas[2][2] = "beneficiante";

        System.out.println(
                "\n\u001B[36mEscreva uma frase para testar o corretor: \n\u001B[33mPalavras cadastradas: exceção, reivindicar, beneficente\u001B[0m");
        String input = "";

        do {
            System.out.print("\u001B[36mAguardando entrada... : \u001B[0m");
            input = sc.nextLine();

            if (input.length() < 7) {
                System.out.print(
                        "\u001B[31mEntrada inválida. Escreva ao menos uma das nossas palavras cadastradas.\n\u001B[0m");
            }
        } while (input.length() < 7);

        String[] frase = input.split(" ");

        boolean correcao = false;

        for (int i = 0; i < frase.length; i++) {

            for (int j = 0; j < palavrasErradas.length; j++) {
                for (int k = 0; k < palavrasErradas[j].length; k++) {
                    if (frase[i].toLowerCase().equals(palavrasErradas[j][k])) {
                        frase[i] = palavrasCertas[j];
                        correcao = true;
                    }
                }
            }
        }

        input = String.join(" ", frase);

        if (correcao) {
            System.out.println("\n\u001B[32mA frase agora está corrigida: " + input + "\u001B[0m");
        } else {
            System.out.println(
                    "\u001B[31mA frase não precisou de correções\n\u001B[0m" + "\u001B[33m" + input + "\u001B[0m");
        }

    }

    public static void repetir() {
        String repeat;

        do {

            exercício();

            System.out.println("\n"
                    + "\u001B[36mPressione x para tentar novamente, ou qualquer outra tecla para finalizar...\u001B[0m");
            System.out.print("\u001B[36mAguardando entrada... : \u001B[0m");

            repeat = sc.nextLine().trim().toLowerCase();
        } while (repeat.equals("x"));
        sc.close();
    }
}
