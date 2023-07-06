import java.text.DecimalFormat;

public class Homem extends PessoaIMC{
    public Homem(String nome, String dataNascimento, double peso, double altura) {
        super(nome, dataNascimento, peso, altura);
    }

    @Override
    public String resultIMC() {
        double imc = calculaIMC();
        if (imc < 20.7) {
            return "Abaixo do peso ideal.";
        } else if (imc < 26.4) {
            return "Peso ideal.";
        } else {
            return "Acima do peso ideal.";
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return super.toString() + "\nPeso: " + peso + "\nAltura: " + altura + "\nIMC: " + df.format(calculaIMC()) + "\nResultado: " + resultIMC();
    }
}
