package solid;

import java.util.Scanner;

public class CaluladoraSoLiD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    operarBinaria(sc, "+");
                    break;
                case 2:
                    operarBinaria(sc, "-");
                    break;
                case 3:
                    operarBinaria(sc, "*");
                    break;
                case 4:
                    operarBinaria(sc, "/");
                    break;
                case 5:
                    operarBinaria(sc, "%");
                    break;
                case 6:
                    raizCuadrada(sc);
                    break;
                case 7:
                    logaritmoNatural(sc);
                    break;
                case 0:
                    System.out.println("Saliendo de la calculadora...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println();

        } while (opcion != 0);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("===== CALCULADORA SoLiD =====");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Módulo");
        System.out.println("6. Raíz cuadrada");
        System.out.println("7. Logaritmo natural");
        System.out.println("0. Salir");
    }

    public static void operarBinaria(Scanner sc, String operador) {
        System.out.print("Ingresa el primer número entero: ");
        int a = sc.nextInt();

        System.out.print("Ingresa el segundo número entero: ");
        int b = sc.nextInt();

        switch (operador) {
            case "+":
                System.out.println("Resultado: " + (a + b));
                break;
            case "-":
                System.out.println("Resultado: " + (a - b));
                break;
            case "*":
                System.out.println("Resultado: " + (a * b));
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Error: no se puede dividir entre cero.");
                } else {
                    System.out.println("Resultado: " + ((double) a / b));
                }
                break;
            case "%":
                if (b == 0) {
                    System.out.println("Error: no se puede calcular módulo entre cero.");
                } else {
                    System.out.println("Resultado: " + (a % b));
                }
                break;
            default:
                System.out.println("Operación no válida.");
        }
    }

    public static void raizCuadrada(Scanner sc) {
        System.out.print("Ingresa un número entero: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Error: no se puede calcular la raíz cuadrada de un número negativo.");
        } else {
            System.out.println("Resultado: " + Math.sqrt(n));
        }
    }

    public static void logaritmoNatural(Scanner sc) {
        System.out.print("Ingresa un número entero: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Error: el logaritmo natural solo existe para números mayores que cero.");
        } else {
            System.out.println("Resultado: " + Math.log(n));
        }
    }
}
