package soliddip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogoOperacionesMemoria implements CatalogoOperaciones {
    private final List<Operacion> operaciones;

    public CatalogoOperacionesMemoria(List<Operacion> operaciones) {
        this.operaciones = new ArrayList<>(operaciones);
    }

    @Override
    public List<Operacion> obtenerTodas() {
        return Collections.unmodifiableList(operaciones);
    }

    @Override
    public Operacion buscarPorOpcion(int opcion) {
        if (opcion < 1 || opcion > operaciones.size()) {
            return null;
        }

        return operaciones.get(opcion - 1);
    }

    @Override
    public boolean estaVacio() {
        return operaciones.isEmpty();
    }
}
