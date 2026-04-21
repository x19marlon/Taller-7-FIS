package soliddip;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CargadorOperaciones cargadorOperaciones = new DescubridorOperacionesPaquete("soliddip");
        List<Operacion> operaciones = cargadorOperaciones.cargar();

        CatalogoOperaciones catalogo = new CatalogoOperacionesMemoria(operaciones);
        Salida salida = new SalidaConsola();
        Entrada entrada = new EntradaConsola(salida);
        VistaMenu menu = new MenuCalculadora(catalogo, salida);
        ServicioCalculadora servicioCalculadora = new ServicioCalculadoraBasico();

        AplicacionCalculadora app = new AplicacionCalculadora(
                entrada,
                salida,
                menu,
                servicioCalculadora,
                catalogo);

        app.ejecutar();
    }
}
