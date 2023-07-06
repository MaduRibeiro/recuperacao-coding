import java.util.Scanner;

public class CaraCoroa implements JogoInterface{
    private int numeroTentativas;

    @Override
    public void resetar() {
        numeroTentativas = 0;
    }

    @Override
    public Placar jogar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("O jogo Cara Coroa começou...");

        while (true) {
            System.out.print("Escolha: [C] Cara ou [O] Coroa (0 para desistir): ");
            String escolha = scanner.nextLine();

            if (escolha.equalsIgnoreCase("C")) {
                numeroTentativas++;
                boolean resultado = Math.random() < 0.5;

                if (resultado) {
                    System.out.println("Cara! Você ganhou.");
                    return new Placar("Você venceu! Cara.", true);
                } else {
                    System.out.println("Coroa! Você perdeu.");
                    return new Placar("Você perdeu! Coroa.", false);
                }
            } else if (escolha.equalsIgnoreCase("O")) {
                numeroTentativas++;
                boolean resultado = Math.random() < 0.5;

                if (resultado) {
                    System.out.println("Coroa! Você ganhou.");
                    return new Placar("Você venceu! Coroa.", true);
                } else {
                    System.out.println("Cara! Você perdeu.");
                    return new Placar("Você perdeu! Cara.", false);
                }
            } else if (escolha.equals("0")) {
                System.out.println("Desistiu do jogo.");
                return new Placar("Você perdeu! Desistiu do jogo.", false);
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    @Override
    public void abortar() {
        System.out.println("Jogo abortado.");
    }

}
