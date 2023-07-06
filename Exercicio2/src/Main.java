import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o número de cartas: ");
            int numCartas = scanner.nextInt();

            Queue<String> baralho = new LinkedList<>();

            for (int i = 1; i <= numCartas; i++) {
                System.out.print("Digite a letra da carta #" + i + ": ");
                String carta = scanner.next();
                baralho.offer(carta);
            }

            Queue<String> cartasDescartadas = descartarCartas(baralho);

            System.out.print("Cartas descartadas: ");
            while (!cartasDescartadas.isEmpty()) {
                System.out.print(cartasDescartadas.poll());
                if (!cartasDescartadas.isEmpty()) {
                    System.out.print(", ");
                }
            }

            System.out.println();
            System.out.println("Carta restante: " + baralho.poll());
        }

        public static Queue<String> descartarCartas(Queue<String> baralho) {
            Queue<String> cartasDescartadas = new LinkedList<>();

            while (baralho.size() > 1) {
                String cartaDescartada = baralho.poll();
                cartasDescartadas.offer(cartaDescartada);

                String cartaTopo = baralho.poll();
                baralho.offer(cartaTopo);
            }

            return cartasDescartadas;
        }
    }

