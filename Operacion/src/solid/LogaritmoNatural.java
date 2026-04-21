package soliddip;

public class LogaritmoNatural implements OperacionUnaria {
    @Override
    public String getNombre() {
        return "Logaritmo natural";
    }

    @Override
    public double calcular(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("el logaritmo natural solo existe para números mayores que cero.");
        }

        return Math.log(n);
    }
}
