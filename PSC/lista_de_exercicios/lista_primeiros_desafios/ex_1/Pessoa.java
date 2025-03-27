package PSC.lista_de_exercicios.lista_primeiros_desafios.ex_1;

public class Pessoa {
    private String nome;
    private String sexo;
    private double altura;

    public Pessoa() {
    }

    public Pessoa(String nome, String sexo, double altura) {
        setNome(nome);
        setSexo(sexo);
        setAltura(altura);
    }

    public void setNome(String nome) {

        if (nome == null || nome.length() <= 3 || !nome.matches("^[\\p{L} ]+$")) {
            throw new IllegalArgumentException(
                    "Entrada invalida. Formato de entrada não pode ser inserido. ('" + nome + "')");

        } else {
            this.nome = nome;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setSexo(String sexo) {
        String estado = "";
        sexo = sexo.toLowerCase();

        if (sexo == null
                || !(sexo.equalsIgnoreCase("f") || sexo.equalsIgnoreCase("m")
                        || sexo.equalsIgnoreCase("feminino") || sexo.equalsIgnoreCase("masculino"))) {

            throw new IllegalArgumentException(
                    "Entrada invalida. Formato de entrada não pode ser inserido. ('" + sexo + "')");
        }

        if (sexo.equals("f") || sexo.equals("feminino")) {
            estado = "feminino";
        } else {
            estado = "masculino";
        }

        this.sexo = estado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setAltura(double altura) {

        if (altura > 100) {
            altura = altura / 100;
        }

        if (altura > 0.6 && altura < 2.51) {
            this.altura = altura;
        } else {
            throw new IllegalArgumentException(
                    "Entrada invalida. Formato de entrada não pode ser inserido. ('" + altura + "')");

        }
    }

    public double getAltura() {
        return altura;
    }

    public static Pessoa criarPessoa(String nome, String sexo, double altura) {
        if (sexo == null) {
            throw new IllegalArgumentException(
                    "Entrada invalida. Formato de entrada não pode ser inserido. ('" + sexo + "')");
        }

        sexo = sexo.toLowerCase();

        switch (sexo) {
            case "m":
                return new Homem(nome, altura);
            case "f":
                return new Mulher(nome, altura);
            default:
                throw new IllegalArgumentException("Sexo inválido. Use 'm' ou 'f'.");
        }
    }

    public static void instrucoes() {

        System.out.println(
                "\nO nome deve conter ao menos três letras, e qualquer caráctere que não seja letra invalidará o nome\n"
                        + "O sexo deve ser descrito por sua inicial 'm' para masculino ou 'f' para feminino e qualquer caráctere que fuja disso invalidará o sexo.\n"
                        + "A altura pode ser descrita com ponto ou sem pontos, porém respeitando um limite entre 0.6 metros ou 60cm e 2.51 metros ou 251cm.\n"
                        + " (muita atenção na pontuação, pois como divisor de numeros, só será aceito o '.'\n ou seja, virgula ou qualquer outro simbulo, além da insersão de letras invalidará a altura).");
    }

    @Override

    public String toString() {
        return "\u001B[32mNome: " + nome + ", sexo: " + sexo + ", altura: " + altura + " metros.\u001B[0m";
    }
}
