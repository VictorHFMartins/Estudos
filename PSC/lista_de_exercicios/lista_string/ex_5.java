// Fazer um programa com uma palavra secreta. O usuário deverá tentar adivinhar esta palavra.

package PSC.lista_de_exercicios.lista_string;

import java.util.Random;
import java.util.Scanner;

public class ex_5 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        repetir();
    }

    public static void exercício() {

        String[][] quizz = new String[3][4];
        int dicas = 0;
        int tentativas = 1;

        quizz[0][0] = "sol";
        quizz[0][1] = "Está no céu, mas não é uma nuvem.";
        quizz[0][2] = "É quente e ilumina o dia.";
        quizz[0][3] = "É essencial para a vida na Terra.";

        quizz[1][0] = "gato";
        quizz[1][1] = "É um animal doméstico.";
        quizz[1][2] = "Gosta de dormir e se lamber.";
        quizz[1][3] = "Diz 'miau'.";

        quizz[2][0] = "bola";
        quizz[2][1] = "É usada em muitos esportes.";
        quizz[2][2] = "É redonda.";
        quizz[2][3] = "Crianças adoram brincar com ela.";

        System.out.print("\n\u001B[36mBem vindo ao quizz, digite enter para começar: \u001B[0m");
        String input = sc.nextLine().trim();

        if (input.matches("")) {

            System.out.println(
                    "\n\u001B[36mO programa vai selecionar uma das três palavras que têmos e você terá que adivinhar qual é!\n"
                            + "Parece divertido, não?\u001B[0m");

            System.out.println(
                    "\n\u001B[36mVocê terá direito a 3 dicas e pode solicita-las a qualquer momento digitando 'd'.\u001B[0m");
            System.out.println("\n\u001B[36mEscolhendo a palavra...\u001B[0m");

            for (int i = 0; i < 3; i++) {
                try {
                    System.out.print("\u001B[33m.\u001B[0m");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("");
            System.out.println("\n\u001B[32mBoa Sorte!\u001B[0m");
            System.out.println("\u001B[33mLembrando que para parar o jogo basta apenas digitar 'q'\u001B[0m");

            Random rd = new Random();

            int num = rd.nextInt(3);

            String palavraChave = quizz[num][0];
            System.out.println("\n\u001B[33mVocê tem " + (4 - tentativas) + " tentativas disponíveis.\u001B[0m");

            while (true) {

                if (tentativas <= 3) {
                    System.out.println("\n\u001B[36mDigite uma palavra, 'd' para dica ou 'q' para sair. \u001B[0m");
                    System.out.print("\u001B[36mAguardando entrada... : \u001B[0m");

                    input = sc.nextLine().trim().toLowerCase();

                    if (input.equals("")) {
                        System.out.println("\n\u001B[31mCampo de entrada vazio.\u001B[0m");
                    } else if (input.equals("q")) {
                        System.out.println("\n\u001B[36mVocê encerou o jogo.\u001B[0m");
                        break;
                    } else if (input.equals("d")) {
                        if (dicas < 3) {
                            System.out.println("\n\u001B[36m" + (quizz[num][dicas + 1]) + "\u001B[0m");
                            dicas++;
                            System.out
                                    .println("\n\u001B[33mVocê ainda tem " + (3 - dicas)
                                            + " dicas disponíveis.\u001B[0m");
                        } else {
                            System.out.println("\n\u001B[31mSem dicas disponíveis.\u001B[0m");
                        }
                    } else if (input.equals(palavraChave)) {
                        if (tentativas == 1) {
                            System.out.println("\n\u001B[32mParabéns, você acertou a palavra de primeira!!!\u001B[0m");
                            System.out.println("\u001B[32mNúmero de dicas utilizadas: " + dicas + ".\u001B[0m");
                            break;
                        } else {
                            System.out.println("\n\u001B[32mParabéns, você acertou a palavra!\u001B[0m");
                            System.out.println("\u001B[32mNúmero de tentativas: " + tentativas + ".\u001B[0m");
                            System.out.println("\u001B[32mNúmero de dicas utilizadas: " + dicas + ".\u001B[0m");
                            break;
                        }
                    } else {
                        System.out.println("\n\u001B[31mErrou! Tente novamente.\u001B[0m");
                        System.out.println("\u001B[31m-----------------------------\u001B[0m\n");

                        tentativas++;
                        System.out
                                .println("\n\u001B[33mVocê tem " + (4 - tentativas)
                                        + " tentativas disponíveis.\u001B[0m");
                    }

                } else {
                    System.out.println("\n\u001B[31mAcabaram as tentativas. Perdeu feio!\u001B[0m");
                    System.out.println("\u001B[31mA palavra correta era: " + palavraChave + "\u001B[0m");
                    break;
                }
            }

        } else {
            System.out.println("\n\u001B[31mVocê saiu do quizz.\u001B[0m");
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
