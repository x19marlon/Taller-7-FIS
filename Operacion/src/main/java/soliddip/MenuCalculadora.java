package soliddip;

import java.util.List;

public class MenuCalculadora implements VistaMenu {
    private final CatalogoOperaciones catalogo;
    private final Salida salida;

    public MenuCalculadora(CatalogoOperaciones catalogo, Salida salida) {
        this.catalogo = catalogo;
        this.salida = salida;
    }

    @Override
    public void mostrar() {
        salida.mostrar("===== CALCULADORA SoLiD =====");

        List<Operacion> operaciones = catalogo.obtenerTodas();
        for (int i = 0; i < operaciones.size(); i++) {
            salida.mostrar((i + 1) + ". " + operaciones.get(i).getNombre());
        }

        salida.mostrar("0. Salir");
    }
}
