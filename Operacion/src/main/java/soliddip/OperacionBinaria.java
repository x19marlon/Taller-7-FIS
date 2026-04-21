package soliddip;

public interface OperacionBinaria extends Operacion {
    double calcular(int a, int b);

    @Override
    default int getCantidadOperandos() {
        return 2;
    }

    @Override
    default double calcular(int... operandos) {
        if (operandos == null || operandos.length != 2) {
            throw new IllegalArgumentException("La operación binaria requiere exactamente 2 operandos.");
        }

        return calcular(operandos[0], operandos[1]);
    }
}
