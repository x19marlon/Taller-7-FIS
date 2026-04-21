package solid;

public class Main {
    public static void main(String[] args) {
        ConsolaEntrada consolaEntrada = new ConsolaEntrada();
        MenuCalculadora menu = new MenuCalculadora();
        CalculadoraService calculadoraService = new CalculadoraService();
        AplicacionCalculadora app = new AplicacionCalculadora(consolaEntrada, menu, calculadoraService);
        app.ejecutar();
    }
}
