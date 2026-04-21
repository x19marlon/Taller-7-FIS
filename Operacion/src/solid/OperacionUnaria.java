package soliddip;

public interface OperacionUnaria extends Operacion {
    double calcular(int n);

    @Override
    default int getCantidadOperandos() {
        return 1;
    }

    @Override
    default double calcular(int... operandos) {
        if (operandos == null || operandos.length != 1) {
            throw new IllegalArgumentException("La operación unaria requiere exactamente 1 operando.");
        }

        return calcular(operandos[0]);
    }
}
