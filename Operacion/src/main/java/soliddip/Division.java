package soliddip;

public class Division implements OperacionBinaria {
    @Override
    public String getNombre() {
        return "División";
    }

    @Override
    public double calcular(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("no se puede dividir entre cero.");
        }

        return (double) a / b;
    }
}
