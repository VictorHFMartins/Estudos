// O usuário insere um CPF seguindo xxx.xxx.xxx-xx. O programa deve apagar os pontos e o hífen e, depois contar quantos caracteres foram inseridos.

package PSC.lista_de_exercicios.lista_string;

import java.util.Scanner;

public class ex_4 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {

        formatarCPF("\n\u001B[36mInsira seu CPF: no formato (''xxx.xxx.xxx-xx'') \u001B[0m");
    }

    public static String formatarCPF(String msg) {
        String read;
        System.out.println(msg);
        System.out.print("\u001B[36mAguardando entrada... : \u001B[0m");

        while (true) {
            while (true) {
                read = sc.nextLine().trim();
                if (read.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
                    break;
                } else {
                    System.out.println(
                            "\n\u001B[31mErro de entrada. CPF inserido de maneira inválida: ('" + read
                                    + "').\u001B[0m");
                    System.out.println(msg);
                    System.out.print("\u001B[36mAguardando entrada... : \u001B[0m");

                }
            }

            String readFormat = read.replaceAll("\\D", "");
            System.out.println("\n\u001B[32m-----------------------------\u001B[0m");
            System.out.println("\n\u001B[32mSeu CPF formatado sem as pontuações é '" + readFormat + "', e contém: "
                    + readFormat.length() + " dígitos.\u001B[0m\n");
            System.out.println("\u001B[32m-----------------------------\u001B[0m");

            return readFormat;

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
