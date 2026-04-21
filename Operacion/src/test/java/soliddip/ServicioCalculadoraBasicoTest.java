package soliddip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCalculadoraBasicoTest {

    @Test
    void debeDelegarLaEjecucionEnLaOperacionRecibida() {
        ServicioCalculadora servicio = new ServicioCalculadoraBasico();

        double resultado = servicio.ejecutar(new Suma(), new int[]{4, 9});

        assertEquals(13.0, resultado);
    }
}
