import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Insira as coordenadas dos pontos do triângulo (Ax Ay Bx By Cx Cy):");
                double ax = scanner.nextDouble();
                double ay = scanner.nextDouble();
                double bx = scanner.nextDouble();
                double by = scanner.nextDouble();
                double cx = scanner.nextDouble();
                double cy = scanner.nextDouble();

                double ladoAB = calcularDistancia(ax, ay, bx, by);
                double ladoBC = calcularDistancia(bx, by, cx, cy);
                double ladoCA = calcularDistancia(cx, cy, ax, ay);

                if (!formamTriangulo(ladoAB, ladoBC, ladoCA)) {
                    throw new IllegalArgumentException("Os pontos não formam um triângulo válido.");
                }

                double perimetro = calcularPerimetro(ladoAB, ladoBC, ladoCA);
                double area = calcularArea(ladoAB, ladoBC, ladoCA);

                System.out.println("O perímetro do triângulo é: " + perimetro + " unidades.");
                System.out.println("A área do triângulo é: " + area + " unidades de área.");
                System.out.println("O triângulo é " + classificarTriangulo(ladoAB, ladoBC, ladoCA));
            } catch (NumberFormatException e) {
                System.err.println("Erro de conversão. Entrada inválida.");
            } catch (IllegalArgumentException e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }

        public static double calcularDistancia ( double x1, double y1, double x2, double y2){
            return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        }

        public static boolean formamTriangulo ( double ladoAB, double ladoBC, double ladoCA){
            return (ladoAB + ladoBC > ladoCA) && (ladoBC + ladoCA > ladoAB) && (ladoCA + ladoAB > ladoBC);
        }

        public static double calcularPerimetro ( double ladoAB, double ladoBC, double ladoCA){
            return ladoAB + ladoBC + ladoCA;
        }

        public static double calcularArea ( double ladoAB, double ladoBC, double ladoCA){
            double semiperimetro = calcularPerimetro(ladoAB, ladoBC, ladoCA) / 2;
            return Math.sqrt(semiperimetro * (semiperimetro - ladoAB) * (semiperimetro - ladoBC) * (semiperimetro - ladoCA));
        }

        public static String classificarTriangulo ( double ladoAB, double ladoBC, double ladoCA){
            if (ladoAB == ladoBC && ladoBC == ladoCA) {
                return "Equilátero";
            } else if (ladoAB == ladoBC || ladoBC == ladoCA || ladoCA == ladoAB) {
                return "Isósceles";
            } else {
                return "Escaleno";
            }
        }
    }


