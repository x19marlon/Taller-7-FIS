package soliddip;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AplicacionCalculadoraTest {

    @Test
    void siNoHayOperacionesDebeAvisarYCerrarLaEntrada() {
        EntradaFake entrada = new EntradaFake();
        SalidaFake salida = new SalidaFake();
        MenuFake menu = new MenuFake();
        CatalogoOperaciones catalogo = new CatalogoOperacionesMemoria(List.of());
        ServicioCalculadora servicio = new ServicioCalculadoraBasico();

        AplicacionCalculadora app = new AplicacionCalculadora(entrada, salida, menu, servicio, catalogo);
        app.ejecutar();

        assertEquals(List.of("No hay operaciones disponibles."), salida.mensajes);
        assertTrue(entrada.fueCerrada);
        assertEquals(0, menu.vecesMostrado);
    }

    @Test
    void debeEjecutarOperacionBinariaYMostrarResultado() {
        EntradaFake entrada = new EntradaFake(1, 7, 5, 0);
        SalidaFake salida = new SalidaFake();
        MenuFake menu = new MenuFake();
        CatalogoOperaciones catalogo = new CatalogoOperacionesMemoria(List.of(new Suma()));
        ServicioCalculadora servicio = new ServicioCalculadoraBasico();

        AplicacionCalculadora app = new AplicacionCalculadora(entrada, salida, menu, servicio, catalogo);
        app.ejecutar();

        assertEquals(List.of(
                "Resultado: 12.0",
                "",
                "Saliendo de la calculadora...",
                ""
        ), salida.mensajes);
        assertEquals(2, menu.vecesMostrado);
        assertTrue(entrada.fueCerrada);
    }

    @Test
    void debeEjecutarOperacionUnariaYMostrarResultado() {
        EntradaFake entrada = new EntradaFake(1, 16, 0);
        SalidaFake salida = new SalidaFake();
        MenuFake menu = new MenuFake();
        CatalogoOperaciones catalogo = new CatalogoOperacionesMemoria(List.of(new RaizCuadrada()));
        ServicioCalculadora servicio = new ServicioCalculadoraBasico();

        AplicacionCalculadora app = new AplicacionCalculadora(entrada, salida, menu, servicio, catalogo);
        app.ejecutar();

        assertEquals(List.of(
                "Resultado: 4.0",
                "",
                "Saliendo de la calculadora...",
                ""
        ), salida.mensajes);
    }

    @Test
    void debeMostrarMensajeSiLaOpcionNoEsValida() {
        EntradaFake entrada = new EntradaFake(8, 0);
        SalidaFake salida = new SalidaFake();
        MenuFake menu = new MenuFake();
        CatalogoOperaciones catalogo = new CatalogoOperacionesMemoria(List.of(new Suma()));
        ServicioCalculadora servicio = new ServicioCalculadoraBasico();

        AplicacionCalculadora app = new AplicacionCalculadora(entrada, salida, menu, servicio, catalogo);
        app.ejecutar();

        assertEquals(List.of(
                "Opción no válida.",
                "",
                "Saliendo de la calculadora...",
                ""
        ), salida.mensajes);
    }

    @Test
    void debeCapturarErroresDeDominioYMostrarlos() {
        EntradaFake entrada = new EntradaFake(1, 9, 0, 0);
        SalidaFake salida = new SalidaFake();
        MenuFake menu = new MenuFake();
        CatalogoOperaciones catalogo = new CatalogoOperacionesMemoria(List.of(new Division()));
        ServicioCalculadora servicio = new ServicioCalculadoraBasico();

        AplicacionCalculadora app = new AplicacionCalculadora(entrada, salida, menu, servicio, catalogo);
        app.ejecutar();

        assertEquals(List.of(
                "Error: no se puede dividir entre cero.",
                "",
                "Saliendo de la calculadora...",
                ""
        ), salida.mensajes);
    }

    private static class EntradaFake implements Entrada {
        private final Queue<Integer> valores = new ArrayDeque<>();
        private boolean fueCerrada;

        private EntradaFake(int... datos) {
            for (int dato : datos) {
                valores.add(dato);
            }
        }

        @Override
        public int leerEntero(String mensaje) {
            return valores.remove();
        }

        @Override
        public void cerrar() {
            fueCerrada = true;
        }
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

    private static class MenuFake implements VistaMenu {
        private int vecesMostrado;

        @Override
        public void mostrar() {
            vecesMostrado++;
        }
    }
}
