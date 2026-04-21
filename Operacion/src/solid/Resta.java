package solid;

public class Resta implements OperacionBinaria {
    @Override
    public double calcular(int a, int b) {
        return a - b;
    }
}
