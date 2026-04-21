package soliddip;

public class Multiplicacion implements OperacionBinaria {
    @Override
    public String getNombre() {
        return "Multiplicación";
    }

    @Override
    public double calcular(int a, int b) {
        return a * b;
    }
}
