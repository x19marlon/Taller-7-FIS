package soliddip;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DescubridorOperacionesPaqueteTest {

    @Test
    void debeDescubrirOperacionesConcretasDelPaquete() {
        CargadorOperaciones cargador = new DescubridorOperacionesPaquete("soliddip");

        List<String> nombres = cargador.cargar()
                .stream()
                .map(Operacion::getNombre)
                .collect(Collectors.toList());

        assertFalse(nombres.isEmpty());
        assertTrue(nombres.contains("Suma"));
        assertTrue(nombres.contains("División"));
        assertTrue(nombres.contains("Raíz cuadrada"));
        assertTrue(nombres.contains("Logaritmo natural"));
    }
}
