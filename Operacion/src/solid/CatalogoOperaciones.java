package soliddip;

import java.util.List;

public interface CatalogoOperaciones {
    java.util.List<Operacion> obtenerTodas();
    Operacion buscarPorOpcion(int opcion);
    boolean estaVacio();
}
