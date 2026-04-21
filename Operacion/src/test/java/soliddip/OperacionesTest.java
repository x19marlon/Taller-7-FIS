package soliddip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperacionesTest {

    @Test
    void sumaDebeRetornarLaSumaCorrecta() {
        Suma suma = new Suma();
        assertEquals(8.0, suma.calcular(3, 5));
    }

    @Test
    void restaDebeRetornarLaRestaCorrecta() {
        Resta resta = new Resta();
        assertEquals(7.0, resta.calcular(10, 3));
    }

    @Test
    void multiplicacionDebeRetornarElProductoCorrecto() {
        Multiplicacion multiplicacion = new Multiplicacion();
        assertEquals(24.0, multiplicacion.calcular(4, 6));
    }

    @Test
    void divisionDebeRetornarElCocienteCorrecto() {
        Division division = new Division();
        assertEquals(2.5, division.calcular(5, 2));
    }

    @Test
    void divisionDebeLanzarExcepcionSiDivideEntreCero() {
        Division division = new Division();

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> division.calcular(8, 0));

        assertEquals("no se puede dividir entre cero.", ex.getMessage());
    }

    @Test
    void moduloDebeRetornarElResiduoCorrecto() {
        Modulo modulo = new Modulo();
        assertEquals(1.0, modulo.calcular(10, 3));
    }

    @Test
    void moduloDebeLanzarExcepcionSiElDivisorEsCero() {
        Modulo modulo = new Modulo();

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> modulo.calcular(10, 0));

        assertEquals("no se puede calcular módulo entre cero.", ex.getMessage());
    }

    @Test
    void raizCuadradaDebeRetornarLaRaizCorrecta() {
        RaizCuadrada raiz = new RaizCuadrada();
        assertEquals(4.0, raiz.calcular(16));
    }

    @Test
    void raizCuadradaDebeLanzarExcepcionConNegativos() {
        RaizCuadrada raiz = new RaizCuadrada();

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> raiz.calcular(-4));

        assertEquals("no se puede calcular la raíz cuadrada de un número negativo.", ex.getMessage());
    }

    @Test
    void logaritmoNaturalDebeRetornarElValorCorrecto() {
        LogaritmoNatural logaritmo = new LogaritmoNatural();
        assertEquals(Math.log(5), logaritmo.calcular(5), 0.000001);
    }

    @Test
    void logaritmoNaturalDebeLanzarExcepcionConCeroONegativos() {
        LogaritmoNatural logaritmo = new LogaritmoNatural();

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> logaritmo.calcular(0));

        assertEquals("el logaritmo natural solo existe para números mayores que cero.", ex.getMessage());
    }
}
