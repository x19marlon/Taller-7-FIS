package soliddip;

public class AplicacionCalculadora {
    private final Entrada entrada;
    private final Salida salida;
    private final VistaMenu menu;
    private final ServicioCalculadora servicioCalculadora;
    private final CatalogoOperaciones catalogo;

    public AplicacionCalculadora(
            Entrada entrada,
            Salida salida,
            VistaMenu menu,
            ServicioCalculadora servicioCalculadora,
            CatalogoOperaciones catalogo) {
        this.entrada = entrada;
        this.salida = salida;
        this.menu = menu;
        this.servicioCalculadora = servicioCalculadora;
        this.catalogo = catalogo;
    }

    public void ejecutar() {
        if (catalogo.estaVacio()) {
            salida.mostrar("No hay operaciones disponibles.");
            entrada.cerrar();
            return;
        }

        int opcion;

        do {
            menu.mostrar();
            opcion = entrada.leerEntero("Elige una opción: ");
            procesarOpcion(opcion);
            salida.mostrar("");
        } while (opcion != 0);

        entrada.cerrar();
    }

    private void procesarOpcion(int opcion) {
        if (opcion == 0) {
            salida.mostrar("Saliendo de la calculadora...");
            return;
        }

        Operacion operacion = catalogo.buscarPorOpcion(opcion);

        if (operacion == null) {
            salida.mostrar("Opción no válida.");
            return;
        }

        int[] operandos = leerOperandos(operacion.getCantidadOperandos());

        try {
            double resultado = servicioCalculadora.ejecutar(operacion, operandos);
            salida.mostrar("Resultado: " + resultado);
        } catch (IllegalArgumentException e) {
            salida.mostrar("Error: " + e.getMessage());
        }
    }

    private int[] leerOperandos(int cantidadOperandos) {
        int[] operandos = new int[cantidadOperandos];

        for (int i = 0; i < cantidadOperandos; i++) {
            operandos[i] = entrada.leerEntero("Ingresa el operando " + (i + 1) + ": ");
        }

        return operandos;
    }
}
