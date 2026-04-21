package soliddip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContratosOperacionesTest {

    @Test
    void operacionBinariaDebeExigirExactamenteDosOperandos() {
        Operacion operacion = new Suma();

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> operacion.calcular(5));

        assertEquals("La operación binaria requiere exactamente 2 operandos.", ex.getMessage());
    }

    @Test
    void operacionUnariaDebeExigirExactamenteUnOperando() {
        Operacion operacion = new RaizCuadrada();

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> operacion.calcular(4, 9));

        assertEquals("La operación unaria requiere exactamente 1 operando.", ex.getMessage());
    }

    @Test
    void operacionBinariaDebeReportarDosOperandos() {
        Operacion operacion = new Multiplicacion();
        assertEquals(2, operacion.getCantidadOperandos());
    }

    @Test
    void operacionUnariaDebeReportarUnOperando() {
        Operacion operacion = new LogaritmoNatural();
        assertEquals(1, operacion.getCantidadOperandos());
    }
}
