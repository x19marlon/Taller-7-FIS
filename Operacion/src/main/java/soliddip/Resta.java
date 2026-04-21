package soliddip;

public class Resta implements OperacionBinaria {
    @Override
    public String getNombre() {
        return "Resta";
    }

    @Override
    public double calcular(int a, int b) {
        return a - b;
    }
}
