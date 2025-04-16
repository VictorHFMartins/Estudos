package DesafioJava;

import java.util.ArrayList;
import java.util.Collections;

public class Pessoa {

    private String nome, identidade, sexo, tipoDocumento;
    private int idade;
    private double saldo;
    private final ArrayList<Transacoes> creditos = new ArrayList<>();
    private final ArrayList<Transacoes> debitos = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(String nome, String identidade, String sexo, String idade, String saldo) {
        this.nome = validarNome(nome);
        this.sexo = validarSexo(sexo);
        this.idade = validarIdade(idade);
        this.saldo = validarSaldo(saldo);
        this.identidade = formatarCPF(identidade);
        tipoDocumento(this.identidade);
    }

    public void addDebito(Transacoes obj) {
        debitos.add((obj));
    }

    public void addCredito(Transacoes obj) {
        creditos.add(obj);
    }

    public void getExtrato() {
        ArrayList<Transacoes> extratoLocal = concatenar(debitos, creditos);

        if (extratoLocal != null && !extratoLocal.isEmpty()) {
            for (Transacoes transacoes : extratoLocal) {
                if (transacoes.getValor() > 0) {
                    System.out
                            .println("\u001B[32m " + transacoes + " de " + transacoes.getRemetente().getNome() + " em "
                                    + transacoes.getData() + "\u001B[0m");
                } else {
                    System.out
                            .println("\u001B[31m " + transacoes + " para " + transacoes.getDestinatario().getNome()
                                    + " em "
                                    + transacoes.getData() + "\u001B[0m");
                }
            }
            return;
        } else {
            System.out.println("\u001B[33m\nAinda não foram realizadas transações para esse usuário.\u001B[0m");
        }
    }

    private ArrayList<Transacoes> concatenar(ArrayList<Transacoes> debitos, ArrayList<Transacoes> creditos) {
        ArrayList<Transacoes> registros = new ArrayList<>();

        for (int i = 0; i < debitos.size(); i++) {
            Transacoes debitoCopia = new Transacoes(
                    debitos.get(i).getRemetente(),
                    debitos.get(i).getDestinatario(),
                    debitos.get(i).getValor() * -1);
            debitoCopia.setData(debitos.get(i).getData());

            registros.add(debitoCopia);
        }

        for (int i = 0; i < creditos.size(); i++) {
            registros.add(creditos.get(i));
        }
        Collections.sort(registros);

        return registros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void tipoDocumento(String identidade) {
        if (identidade != null) {
            if (identidade.length() == 11)
                this.tipoDocumento = "CPF";
            else
                this.tipoDocumento = "RG";
        }
    }

    public static String formatarCPF(String identidade) {
        while (true) {
            if (identidade.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")
                    || identidade.matches("^\\d{11}$")
                    || identidade.matches("^\\d{9}$")
                    || identidade.matches("^\\d{9}\\D{1}$")
                    || identidade.matches("^\\d{2}\\.\\d{3}\\.\\d{3}-\\d{1}$")
                    || identidade.matches("^\\d{2}\\.\\d{3}\\.\\d{3}-\\D{1}$")
                    || identidade.matches("^\\d{2}\\.\\d{3}\\.\\d{3}$")) {
                break;
            } else {
                throw new IllegalArgumentException(
                        "\u001B[31mEntrada invalida. Formato de entrada não pode ser inserido. ('" + identidade
                                + "')\u001B[0m");
            }
        }

        return identidade.replaceAll("\\D", "");
    }

    public static String validarNome(String nome) {
        if (!nome.isEmpty() && nome.length() > 3
                && !nome.matches(".*\\d.*")
                && !nome.matches(".*\\p{S}.*")
                && !nome.matches(".*\\p{P}.*")) {
            return nome;
        } else {
            throw new IllegalArgumentException(
                    "\u001B[31mEntrada invalida. Formato de entrada não pode ser inserido. ('" + nome + "')\u001B[0m");
        }
    }

    public static String validarSexo(String sx) {
        sx = sx.toLowerCase().trim();
        if (sx.isEmpty()
                || !(sx.equalsIgnoreCase("f") || sx.equalsIgnoreCase("m")
                        || sx.equalsIgnoreCase("feminino") || sx.equalsIgnoreCase("masculino"))) {
            throw new IllegalArgumentException(
                    "\u001B[31mEntrada invalida. Formato de entrada não pode ser inserido. ('" + sx + "')\u001B[0m");
        }

        if (sx.equals("m") || sx.equals("masculino")) {
            return "Masculino";
        } else
            return "Feminino";
    }

    public static int validarIdade(String numStr) {
        int num = 0;

        while (true) {
            if (numStr.matches("\\d+")) {
                num = Integer.parseInt(numStr);
                break;
            } else {
                System.out.print("Idade: ");
                numStr = Atividade.sc.nextLine();
            }
        }

        if (num >= 0 && num <= 120) {
            return num;
        } else {
            throw new IllegalArgumentException(
                    "\u001B[31mEntrada invalida. Formato de entrada não pode ser inserido. ('" + num + "')\u001B[0m");
        }
    }

    public static double validarSaldo(String saldoStr) {
        double saldo = 0;

        while (true) {
            if (saldoStr.matches("\\d+")) {
                saldo = Double.parseDouble(saldoStr);
                break;
            } else {
                System.out.print("Saldo inicial: ");
                saldoStr = Atividade.sc.nextLine();
            }
        }

        if (saldo >= 0) {
            return saldo;
        } else {
            throw new IllegalArgumentException(
                    "\u001B[31mEntrada invalida. Formato de entrada não pode ser inserido. ('" + saldo + "')\u001B[0m");
        }
    }

    public String consultarSaldo() {

        return "saldo atual para " + nome + ": " + formatarDinheiro(saldo);
    }

    public double saque() {

        while (true) {

            System.out.print("\u001B[33mDigite o valor para o saque: \u001B[0m");
            String saqueStr = Atividade.sc.nextLine().replaceAll(",", ".");

            if (saqueStr.matches("\\d+(\\.\\d{1,2})?")) {

                double saque = Double.parseDouble(saqueStr);

                if (saque >= 0) {
                    if (saque <= saldo) {
                        saldo -= saque;
                        if (saque > 0) {
                            System.out
                                    .println("\n\u001B[32mSaque realizado com sucesso. + ('"
                                            + String.format("%.2f", saque) + "').\u001B[0m");
                        }
                        return saldo;
                    } else
                        System.out.println(
                                "\u001B[31m\nEntrada invalida. Saldo insuficiente. ('" + String.format("%.2f", saque)
                                        + "') + Saldo atual: ('"
                                        + saldo
                                        + "')\n\u001B[0m");
                } else
                    System.out.println(
                            "\u001B[31m\nEntrada invalida. Formato de valor não pode ser inserido. ('"
                                    + String.format("%.2f", saque)
                                    + "')\n\u001B[0m");
            } else
                System.out.println(
                        "\u001B[31m\nEntrada invalida. Formato de valor não pode ser inserido. ('" + saqueStr
                                + "')\n\u001B[0m");
        }
    }

    public double deposito() {
        while (true) {

            System.out.print("\u001B[33mDigite o valor para o deposito: \u001B[0m");
            String depositoStr = Atividade.sc.nextLine().replaceAll(",", ".");

            if (depositoStr.matches("\\d+(\\.\\d{1,2})?")) {

                double deposito = Double.parseDouble(depositoStr);

                if (deposito >= 0) {
                    saldo += deposito;
                    if (deposito > 0) {
                        System.out.println(
                                "\n\u001B[32mDepósito realizado com sucesso. + ('" + String.format("%.2f", deposito)
                                        + "').\u001B[0m");
                    }
                    return saldo;
                } else
                    System.out.println(
                            "\u001B[31m\nEntrada invalida. Formato de valor não pode ser inserido. ('"
                                    + String.format("%.2f", deposito)
                                    + "')\n\u001B[0m");
            } else
                System.out.println(
                        "\u001B[31m\nEntrada invalida. Formato de valor não pode ser inserido. ('" + depositoStr
                                + "')\n\u001B[0m");
        }
    }

    public static String formatarDinheiro(double valor) {
        long parteInteira = (long) valor;
        int parteDecimal = (int) Math.round((valor - parteInteira) * 100);

        String numeroStr = String.valueOf(parteInteira);
        String resultado = "";
        int contador = 0;

        for (int i = numeroStr.length() - 1; i >= 0; i--) {
            resultado = numeroStr.charAt(i) + resultado;
            contador++;

            if (contador % 3 == 0 && i != 0) {
                resultado = "." + resultado;
            }
        }

        String decimalStr = parteDecimal < 10 ? "0" + parteDecimal : String.valueOf(parteDecimal);

        return resultado + "," + decimalStr;
    }

    public String toString() {
        return "\n\u001B[32mNome: " + nome + "\nIdade: " + idade + " anos" + "\nSexo: " + sexo + "\n" + tipoDocumento
                + ": "
                + identidade
                + "\nSaldo atual: R$ " + formatarDinheiro(saldo) + "\u001B[0m";
    }
}
