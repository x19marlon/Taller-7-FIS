package solid;

public class CalculadoraService {
    public double ejecutarOperacionBinaria(OperacionBinaria operacion, int a, int b) {
        return operacion.calcular(a, b);
    }

    public double ejecutarOperacionUnaria(OperacionUnaria operacion, int n) {
        return operacion.calcular(n);
    }
}
