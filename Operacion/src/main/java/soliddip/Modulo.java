package soliddip;

public class Modulo implements OperacionBinaria {
    @Override
    public String getNombre() {
        return "Módulo";
    }

    @Override
    public double calcular(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("no se puede calcular módulo entre cero.");
        }

        return a % b;
    }
}
