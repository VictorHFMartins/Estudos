package PSC.lista_de_exercicios.lista_primeiros_desafios.ex_2;

public class Parede {
    private double altura;
    private double comprimento;

    public Parede() {

    }

    public Parede(double altura, double comprimento) {
        setAltura(altura);
        setComprimento(comprimento);

    }

    public double calculoDeArea() {

        return this.altura * this.comprimento;
    }

    public void setAltura(double altura) {

        if (altura > 100) {
            altura = altura / 100;
        }

        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setComprimento(double comprimento) {

        if (comprimento > 100) {
            comprimento = comprimento / 100;
        }

        this.comprimento = comprimento;
    }

    public double getComprimento() {
        return comprimento;
    }
}
