package DesafioJava;

import java.util.ArrayList;
import java.util.Scanner;

public class Atividade {
    private final static ArrayList<Pessoa> p = new ArrayList<>();
    final static Scanner sc = new Scanner(System.in);
    private static String usuário = "";

    public static void main(String[] args) {

        p.add(new Pessoa("Fulano da Silva", "000.000.000-00", "Masculino", "30", "1000"));
        p.add(new Pessoa("Fulana dos Santos", "111.111.111-11", "Feminino", "47", "1000"));

        console();
    }

    public static void console() {

        int indexPessoa = -1;
        int input;

        if (usuário.equals("")) {

            System.out.println("\n\u001B[33mEscolha uma opção: \u001B[0m");
            System.out.println("");
            System.out.println("1 - Cadastro de novo usuário. ");
            System.out.println("2 - Remover usuário. ");
            System.out.println("3 - Listar todas os usuários. ");
            System.out.println("4 - Entrar como usuário. ");
            System.out.println("0 - Sair. \n");

            String valorStr = Atividade.sc.nextLine();

            if (valorStr.matches("\\d")) {
                input = Integer.parseInt(valorStr);
                System.out.println("");

                if (input >= 0 && input <= 4) {

                    switch (input) {
                        case 0:
                            System.out.println("\u001B[33mVocê saiu da aplicação\u001B[0m");
                            return;
                        case 1:
                            cadastroPessoa();
                            break;
                        case 2:
                            p.remove(consultarPessoa());
                            System.out.println("\u001B[32mUsuário Removido com sucesso.\u001B[0m");
                            usuário = "";
                            break;
                        case 3:
                            for (int i = 0; i < p.size(); i++) {
                                System.out.println(i + " - " + p.get(i).getNome());
                            }
                            break;
                        case 4:
                            indexPessoa = consultarPessoa();
                            break;
                        default:
                            break;
                    }
                } else
                    System.out.println("\u001B[31mEntrada inválida.('" + input + "')\u001B[0m");
            } else
                System.out.println("\n\u001B[31mEntrada inválida. ('" + valorStr + "')\u001B[0m");
        }

        while (!usuário.equals("")) {

            System.out.println("\n\u001B[33mEscolha uma opção: \u001B[0m");
            System.out.println("");
            System.out.println("1 - Consultar saldo. ");
            System.out.println("2 - Realizar saque. ");
            System.out.println("3 - Realizar depósito. ");
            System.out.println("4 - Transferir dinheiro. ");
            System.out.println("5 - Acessar extrato. ");
            System.out.println("6 - Dados do usuário. ");
            System.out.println("0 - retornar. \n");

            String valorStr = Atividade.sc.nextLine();

            if (valorStr.matches("\\d")) {
                input = Integer.parseInt(valorStr);
                System.out.println("");

                if (input >= 0 && input <= 6) {

                    switch (input) {
                        case 0:
                            usuário = "";
                            break;
                        case 1:
                            System.out.println(p.get(indexPessoa).consultarSaldo());
                            break;
                        case 2:
                            p.get(indexPessoa).saque();
                            break;
                        case 3:
                            p.get(indexPessoa).deposito();
                            break;
                        case 4:
                            Transacoes.transferirDinheiro(p.get(indexPessoa), p.get(consultarPessoa()));
                            break;
                        case 5:
                            p.get(indexPessoa).getExtrato();
                            break;
                        case 6:
                            System.out.println(p.get(indexPessoa).toString());
                            break;

                        default:
                            break;
                    }
                } else
                    System.out.println("\u001B[31mEntrada inválida.('" + input + "')\u001B[0m");
            } else
                System.out.println("\n\u001B[31mEntrada inválida. ('" + valorStr + "')\u001B[0m");
        }

        console();
    }

    public static int consultarPessoa() {

        int num = -1;
        boolean loop = true;

        do {
            System.out.println("\u001B[33mDigite o documento do usuário: \u001B[0m");
            String ref = sc.nextLine();

            try {
                for (int i = 0; i < p.size(); i++) {
                    if (Pessoa.formatarCPF(ref).equals(p.get(i).getIdentidade())) {
                        num = i;
                        System.out.println("");
                        System.out.println("\n\u001B[32mUsuário encontrado: " + p.get(num).getNome() + "\u001B[0m");
                        usuário = Pessoa.formatarCPF(ref);
                        return num;
                    }
                }
                if (num == -1) {
                    System.out.println("\n\u001B[31mUsuário não encontrado.\u001B[0m");
                    console();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n\u001B[31mEntrada invalida. Formato de entrada não pode ser inserido. ('" + ref
                        + "')\u001B[0m\n");
            }

        } while (loop);

        return -1;
    }

    public static void cadastroPessoa() {
        System.out.println("\u001B[33mCadastro de novo usuário. \u001B[0m");
        Pessoa p1 = new Pessoa();

        do {
            try {
                System.out.print("Nome: ");
                p1.setNome(Pessoa.validarNome(sc.nextLine()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\u001B[31m\nEntrada invalida.\u001B[0m\n");

            }
        } while (true);

        boolean loop = true;
        while (loop) {
            try {
                boolean duplicado = false;
                System.out.print("Documento de identidade (RG ou CPF com digitos e pontuações): ");
                p1.setIdentidade(Pessoa.formatarCPF(sc.nextLine()));

                for (Pessoa pessoa : p) {
                    if (p1.getIdentidade().equals(pessoa.getIdentidade())) {
                        duplicado = true;
                    }
                }

                if (!duplicado) {
                    loop = false;
                } else {
                    System.out.println("\u001B[31m\nDocumento de identidade já cadastrado no sistema.\u001B[0m\n");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\u001B[31m\nEntrada invalida.\u001B[0m\n");
            }
        }
        do {
            try {
                System.out.print("Sexo: ");
                p1.setSexo(Pessoa.validarSexo(sc.nextLine()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\u001B[31m\nEntrada invalida.\u001B[0m\n");
            }
        } while (true);
        do {
            try {
                System.out.print("Idade: ");
                p1.setIdade(Pessoa.validarIdade(sc.nextLine()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\u001B[31m\nEntrada invalida.\u001B[0m\n");
            }
        } while (true);
        do {
            try {
                System.out.print("Saldo inicial: ");
                p1.setSaldo(Pessoa.validarSaldo(sc.nextLine()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\u001B[31m\nEntrada invalida.\u001B[0m\n");
            }
        } while (true);

        p.add(p1);
        System.out.println("\u001B[32m\nUsuário cadastrado com sucesso.\u001B[0m");
    }

    public static String getUsuário() {
        return usuário;
    }
}
