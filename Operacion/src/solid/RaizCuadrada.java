package solid;

public class RaizCuadrada implements OperacionUnaria {
    @Override
    public double calcular(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("no se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(n);
    }
}
