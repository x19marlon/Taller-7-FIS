package soliddip;

public class ServicioCalculadoraBasico implements ServicioCalculadora {
    @Override
    public double ejecutar(Operacion operacion, int[] operandos) {
        return operacion.calcular(operandos);
    }
}
