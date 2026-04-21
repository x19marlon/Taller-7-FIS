package soliddip;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CatalogoOperacionesMemoriaTest {

    @Test
    void debeRetornarLaOperacionAsociadaALaOpcion() {
        CatalogoOperaciones catalogo = new CatalogoOperacionesMemoria(List.of(new Suma(), new Resta()));

        Operacion operacion = catalogo.buscarPorOpcion(2);

        assertEquals("Resta", operacion.getNombre());
    }

    @Test
    void debeRetornarNullSiLaOpcionNoExiste() {
        CatalogoOperaciones catalogo = new CatalogoOperacionesMemoria(List.of(new Suma()));

        assertNull(catalogo.buscarPorOpcion(0));
        assertNull(catalogo.buscarPorOpcion(2));
    }

    @Test
    void debeSaberSiEstaVacio() {
        CatalogoOperaciones vacio = new CatalogoOperacionesMemoria(List.of());
        CatalogoOperaciones conDatos = new CatalogoOperacionesMemoria(List.of(new Suma()));

        assertTrue(vacio.estaVacio());
        assertFalse(conDatos.estaVacio());
    }

    @Test
    void obtenerTodasDebeSerInmodificable() {
        CatalogoOperaciones catalogo = new CatalogoOperacionesMemoria(List.of(new Suma()));

        List<Operacion> operaciones = catalogo.obtenerTodas();

        assertThrows(UnsupportedOperationException.class, () -> operaciones.add(new Resta()));
    }
}
