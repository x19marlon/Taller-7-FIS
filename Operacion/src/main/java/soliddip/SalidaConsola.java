package soliddip;

public class SalidaConsola implements Salida {
    @Override
    public void mostrar(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void mostrarSinSalto(String mensaje) {
        System.out.print(mensaje);
    }
}
