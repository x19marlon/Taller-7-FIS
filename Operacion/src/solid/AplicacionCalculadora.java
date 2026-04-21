package solid;

public class AplicacionCalculadora {
    private final ConsolaEntrada consolaEntrada;
    private final MenuCalculadora menu;
    private final CalculadoraService calculadoraService;

    public AplicacionCalculadora(ConsolaEntrada consolaEntrada, MenuCalculadora menu, CalculadoraService calculadoraService) {
        this.consolaEntrada = consolaEntrada;
        this.menu = menu;
        this.calculadoraService = calculadoraService;
    }

    public void ejecutar() {
        int opcion;

        do {
            menu.mostrar();
            opcion = consolaEntrada.leerEntero("Elige una opción: ");
            procesarOpcion(opcion);
            System.out.println();
        } while (opcion != 0);

        consolaEntrada.cerrar();
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                ejecutarOperacionBinaria(new Suma());
                break;
            case 2:
                ejecutarOperacionBinaria(new Resta());
                break;
            case 3:
                ejecutarOperacionBinaria(new Multiplicacion());
                break;
            case 4:
                ejecutarOperacionBinaria(new Division());
                break;
            case 5:
                ejecutarOperacionBinaria(new Modulo());
                break;
            case 6:
                ejecutarOperacionUnaria(new RaizCuadrada());
                break;
            case 7:
                ejecutarOperacionUnaria(new LogaritmoNatural());
                break;
            case 0:
                System.out.println("Saliendo de la calculadora...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void ejecutarOperacionBinaria(OperacionBinaria operacion) {
        int a = consolaEntrada.leerEntero("Ingresa el primer número entero: ");
        int b = consolaEntrada.leerEntero("Ingresa el segundo número entero: ");

        try {
            double resultado = calculadoraService.ejecutarOperacionBinaria(operacion, a, b);
            System.out.println("Resultado: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void ejecutarOperacionUnaria(OperacionUnaria operacion) {
        int n = consolaEntrada.leerEntero("Ingresa un número entero: ");

        try {
            double resultado = calculadoraService.ejecutarOperacionUnaria(operacion, n);
            System.out.println("Resultado: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
