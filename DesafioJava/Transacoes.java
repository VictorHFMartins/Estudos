package DesafioJava;

import java.util.Date;

public class Transacoes implements Comparable<Transacoes> {
    private Pessoa remetente, destinatario;
    private Double valor;
    private Date data;

    public Pessoa getDestinatario() {
        return destinatario;
    }

    public Pessoa getRemetente() {
        return remetente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public Transacoes(Pessoa remetente, Pessoa destinatario, double valor) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.valor = valor;
        this.data = new Date();
    }

    public static void transferirDinheiro(Pessoa remetente, Pessoa destinatario) {
        boolean loop = true;

        while (loop) {
            if (remetente == destinatario) {
                System.out.println("\n\u001B[31mNão é possivel transferir para si mesmo\u001B[0m");
                break;
            }

            System.out.println("\nValor para transferência: ");
            String valorStr = Atividade.sc.nextLine().replaceAll(",", ".");

            if (valorStr.matches("\\d+(\\.\\d{1,2})?")) {
                double valor = Double.parseDouble(valorStr);

                if (valor >= 0 && valor <= remetente.getSaldo()) {

                    remetente.setSaldo(remetente.getSaldo() - valor);
                    destinatario.setSaldo(destinatario.getSaldo() + valor);

                    if (valor > 0) {
                        System.out.println("\n\u001B[32mTransferência realizada com sucesso!\n"
                                + remetente.getNome() + " para " + destinatario.getNome()
                                + ": R$ " + String.format("%.2f", valor) + "\u001B[0m");
                        adicionarTransacao(remetente, destinatario, valor);
                    }

                    loop = false;
                } else
                    System.out.println("\n\u001B[31mErro. Entrada inválida ou saldo insuficiente\u001B[0m");
            } else {
                System.out.println("\n\u001B[31mEntrada inválida.('" + valorStr + "')\u001B[0m");
            }
        }
    }

    public static void adicionarTransacao(Pessoa remetente, Pessoa destinatario, double valor) {
        Transacoes transacao = new Transacoes(remetente, destinatario, valor);
        remetente.addDebito(transacao);
        destinatario.addCredito(transacao);
    }

    @Override
    public String toString() {
        return "R$ " + String.format("%.2f", valor) + "\u001B[0m";
    }

    @Override
    public int compareTo(Transacoes o) {
        if (this.data.getTime() < o.data.getTime()) {
            return -1;
        } else if (this.data.getTime() > o.data.getTime()) {
            return 1;
        }

        return 0;
    }
}