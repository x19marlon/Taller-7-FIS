package soliddip;

public class Suma implements OperacionBinaria {
    @Override
    public String getNombre() {
        return "Suma";
    }

    @Override
    public double calcular(int a, int b) {
        return a + b;
    }
}
