import java.util.Scanner;

public class Main extends Convert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma opção:");
        System.out.println("1. Converter de decimal para binário");
        System.out.println("2. Converter de binário para decimal");
        System.out.println("3. Converter de decimal para octal");
        System.out.println("4. Converter de octal para decimal");
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
        } else if (opcao == 3) {
            System.out.print("Digite um número decimal: ");
            String decimalStr = scanner.nextLine();
            try {
                int decimal = Integer.parseInt(decimalStr);
                String octal = toOct(decimal);
                System.out.println("O número octal correspondente é: " + octal);
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida. Digite um número decimal válido.");
            }
        } else if (opcao == 4) {
            System.out.print("Digite um número octal: ");
            String octal = scanner.nextLine();
            try {
                int decimal = Integer.parseInt(octal, 8);
                System.out.println("O número decimal correspondente é: " + decimal);
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida. Digite um número octal válido.");
            }
        } else {
            System.err.println("Opção inválida. Escolha 1, 2, 3 ou 4 para selecionar a conversão desejada.");
        }
    }

    public static String toOct(int number) {
        return Integer.toOctalString(number);
    }


    public static String toDec(String number, int base) {
        if (base == 8) {
            return String.valueOf(Integer.parseInt(number, base));
        } else {
            return toDec(number, base);
        }
    }


    public static String toBin(int number) {
        return Integer.toBinaryString(number);
    }
}