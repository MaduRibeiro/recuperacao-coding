import java.util.Scanner;

public class Convert {

    public void Convert()

    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1. Converter de decimal para binário");
        System.out.println("2. Converter de binário para decimal");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (opcao == 1) {
            System.out.print("Digite um número decimal: ");
            String decimalStr = scanner.nextLine();
            try {
                int decimal = Integer.parseInt(decimalStr);
                String binario = toBin(decimal);
                System.out.println("O número binário correspondente é: " + binario);
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida. Digite um número decimal válido.");
            }
        } else if (opcao == 2) {
            System.out.print("Digite um número binário: ");
            String binario = scanner.nextLine();
            try {
                int decimal = Integer.parseInt(binario, 2);
                System.out.println("O número decimal correspondente é: " + decimal);
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida. Digite um número binário válido.");
            }
        } else {
            System.err.println("Opção inválida. Escolha 1 para converter de decimal para binário ou 2 para converter de binário para decimal.");
        }

    }


        public static String toDec (String number){
            return String.valueOf(Integer.parseInt(number, 2));
        }

        public static String toBin ( int number){
            return Integer.toBinaryString(number);
        }
    }

