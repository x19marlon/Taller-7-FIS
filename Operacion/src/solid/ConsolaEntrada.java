package solid;

import java.util.Scanner;

public class ConsolaEntrada {
    private final Scanner scanner;

    public ConsolaEntrada() {
        this.scanner = new Scanner(System.in);
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public void cerrar() {
        scanner.close();
    }
}
