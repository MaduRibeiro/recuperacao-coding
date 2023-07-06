import java.util.Scanner;

public class Jogo {
    private Scanner scanner;
    private JogoInterface jogo;

    public Jogo() {
        scanner = new Scanner(System.in);
        jogo = null;
    }

    public void iniciar() {
        boolean executando = true;

        while (executando) {
            System.out.println("\nEscolha o jogo:\n[1] Menor Maior\n[2] Cara Coroa\n[0] Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    jogo = new MenorMaior();
                    break;
                case 2:
                    jogo = new CaraCoroa();
                    break;
                case 0:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            if (jogo != null) {
                jogar();
            }
        }
    }

    private void jogar() {
        boolean jogando = true;

        while (jogando) {
            Placar placar = jogo.jogar();
            exibirPlacar(placar);

            System.out.print("Deseja jogar novamente? (S/N): ");
            String resposta = scanner.nextLine();

            if (!resposta.equalsIgnoreCase("S")) {
                jogando = false;
                jogo.abortar();
                jogo.resetar();
            }
        }
    }

    private void exibirPlacar(Placar placar) {
        System.out.println("\n==== Resultado ====");
        System.out.println(placar.getMensagem());

        if (placar.isJogoGanho()) {
            System.out.println("Parabéns!");
        } else {
            System.out.println("Mais sorte na próxima vez!");
        }

        System.out.println("===================\n");
    }

    public void finalizar() {
        scanner.close();
        System.out.println("Programa finalizado.");
    }

}
