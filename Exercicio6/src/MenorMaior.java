import java.util.Random;
import java.util.Scanner;

public class MenorMaior implements JogoInterface{
    private int numeroSorteado;
    private int numeroTentativas;

    public MenorMaior() {
        resetar();
    }

    @Override
    public void resetar() {
        Random random = new Random();
        numeroSorteado = random.nextInt(100) + 1;
        numeroTentativas = 0;
    }

    @Override
    public Placar jogar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("O jogo Menor Maior começou...");

        while (true) {
            System.out.print("Digite um número (0 para desistir): ");
            int numero = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            if (numero == 0) {
                System.out.println("Desistiu do jogo.");
                return new Placar("Você perdeu! O número sorteado era " + numeroSorteado + ".", false);
            }

            numeroTentativas++;

            System.out.println("O número fornecido é " + (numero < numeroSorteado ? "MENOR" : "MAIOR") + " que o sorteado.");

            if (numero == numeroSorteado) {
                System.out.println("Parabéns! Você acertou o número sorteado.");
                return new Placar("Você venceu! O número sorteado era " + numeroSorteado + ". Total de tentativas: " + numeroTentativas + ".", true);
            }
        }
    }

    @Override
    public void abortar() {
        System.out.println("Jogo abortado.");
    }
}
