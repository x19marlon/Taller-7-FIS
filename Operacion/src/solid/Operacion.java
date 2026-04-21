package soliddip;

public interface Operacion {
    String getNombre();
    int getCantidadOperandos();
    double calcular(int... operandos);
}
