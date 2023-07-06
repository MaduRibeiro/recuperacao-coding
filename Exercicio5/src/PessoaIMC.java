public abstract class PessoaIMC extends Pessoa {
   protected double peso;
   protected double altura;

    public PessoaIMC(String nome, String dataNascimento, double peso, double altura) {
        super(nome, dataNascimento);
        this.peso = peso;
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public double calculaIMC() {
        double imc = peso / (altura * altura);
        return imc;
    }

    public abstract String resultIMC();
}


