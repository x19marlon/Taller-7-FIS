package solid;

public class Modulo implements OperacionBinaria {
    @Override
    public double calcular(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("no se puede calcular módulo entre cero.");
        }
        return a % b;
    }
}
