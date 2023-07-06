import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o numero de pessoas: ");
        int tamanho = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        PessoaIMC[] pessoas = new PessoaIMC[tamanho];

        for (int i = 0; i < tamanho; i++) {
            System.out.println("Digite os dados para a pessoa #" + (i + 1) + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Data de Nascimento: ");
            String dataNascimento = scanner.nextLine();
            System.out.print("Peso: ");
            double peso = scanner.nextDouble();
            System.out.print("Altura: ");
            double altura = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer

            System.out.print("Digite o tipo de pessoa (H para Homem, M para Mulher): ");
            String tipo = scanner.nextLine();

            if (tipo.equalsIgnoreCase("H")) {
                pessoas[i] = new Homem(nome, dataNascimento, peso, altura);
            } else if (tipo.equalsIgnoreCase("M")) {
                pessoas[i] = new Mulher(nome, dataNascimento, peso, altura);
            } else {
                System.out.println("Tipo inválido. Usando PessoaIMC como padrão.");
                pessoas[i] = new PessoaIMC(nome, dataNascimento, peso, altura) {
                    @Override
                    public String resultIMC() {
                        return "Resultado não disponível.";
                    }
                };
            }
        }

        System.out.println("\nResultados:");

        for (PessoaIMC pessoa : pessoas) {
            System.out.println("\n" + pessoa);
        }
    }
}




