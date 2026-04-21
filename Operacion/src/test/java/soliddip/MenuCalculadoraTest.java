package soliddip;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuCalculadoraTest {

    @Test
    void debeMostrarTituloOperacionesYOpcionSalir() {
        CatalogoOperaciones catalogo = new CatalogoOperacionesMemoria(List.of(new Division(), new Suma()));
        SalidaFake salida = new SalidaFake();

        VistaMenu menu = new MenuCalculadora(catalogo, salida);
        menu.mostrar();

        assertEquals(List.of(
                "===== CALCULADORA SoLiD =====",
                "1. División",
                "2. Suma",
                "0. Salir"
        ), salida.mensajes);
    }

    private static class SalidaFake implements Salida {
        private final List<String> mensajes = new ArrayList<>();

        @Override
        public void mostrar(String mensaje) {
            mensajes.add(mensaje);
        }

        @Override
        public void mostrarSinSalto(String mensaje) {
            mensajes.add(mensaje);
        }
    }
}
