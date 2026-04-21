package soliddip;

import java.util.Scanner;

public class EntradaConsola implements Entrada {
    private final Scanner scanner;
    private final Salida salida;

    public EntradaConsola(Salida salida) {
        this.scanner = new Scanner(System.in);
        this.salida = salida;
    }

    @Override
    public int leerEntero(String mensaje) {
        salida.mostrarSinSalto(mensaje);
        return scanner.nextInt();
    }

    @Override
    public void cerrar() {
        scanner.close();
    }
}
