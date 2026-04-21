package solid;

public class Suma implements OperacionBinaria {
    @Override
    public double calcular(int a, int b) {
        return a + b;
    }
}
