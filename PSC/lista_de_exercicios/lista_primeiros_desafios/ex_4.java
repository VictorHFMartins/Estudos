// O usuário digita uma frase e o programa retorna a frase em ordem 

package PSC.lista_de_exercicios.lista_primeiros_desafios;

import java.util.Scanner;

public class ex_4 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {

        String fraseCerta = "O rato roeu a roupa do rei de roma";
        String[] fraseSplit = fraseCerta.split(" ");

        System.out.println("\n\u001B[36mInsira a frase de referência em uma ordem aleatória de palavras. '\u001B[33m"
                + fraseCerta + "\u001B[36m'\u001B[0m");
        System.out.print("\u001B[36mAguardando entrada... : \u001B[0m");
        String input = sc.nextLine();

        String[] inputSplit = input.split(" ");
        String[] acumulador = new String[fraseSplit.length];
        String[] erros = new String[fraseSplit.length];
        int erroIndex = 0;

        if (inputSplit.length != fraseSplit.length) {
            System.out.println(
                    "\n\u001B[31mA frase está montada diferente, talvez faltando ou sobrando palavras.\u001B[0m");
            return;

        } else {

            for (int i = 0; i < inputSplit.length; i++) {
                for (int j = 0; j < inputSplit.length; j++) {
                    if (fraseSplit[i].toLowerCase().equals(inputSplit[j].toLowerCase())) {
                        acumulador[i] = inputSplit[j];
                    }
                }

                boolean encontrada = false;
                for (int j = 0; j < inputSplit.length; j++) {
                    if (inputSplit[i].equalsIgnoreCase(fraseSplit[j])) {
                        encontrada = true;
                        break;
                    }
                }

                if (!encontrada) {
                    erros[erroIndex] = inputSplit[i];
                    erroIndex++;
                }
            }
        }

        input = String.join(" ", acumulador);
        if (erroIndex == 0) {
            System.out.println("\n\u001B[32mFrase corrigida: " + input + ".\u001B[0m");
        } else {
            System.out.println("\n\u001B[31mA frase está com erros de ortografia.\u001B[0m");
            printErro(erros, erroIndex);
        }
    }

    public static void printErro(String[] erro, int limite) {
        System.out.print("\u001B[33mPalavras erradas: ");

        for (int i = 0; i < limite; i++) {
            System.out.print(erro[i]);
            if (i < limite - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(".\u001B[0m");
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
