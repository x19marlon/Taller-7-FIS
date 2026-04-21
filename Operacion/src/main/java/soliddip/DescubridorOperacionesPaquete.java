package soliddip;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

public class DescubridorOperacionesPaquete implements CargadorOperaciones {
    private final String nombrePaquete;

    public DescubridorOperacionesPaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    @Override
    public List<Operacion> cargar() {
        List<Operacion> operaciones = new ArrayList<>();
        String rutaPaquete = nombrePaquete.replace('.', '/');

        try {
            Enumeration<URL> recursos = Thread.currentThread().getContextClassLoader().getResources(rutaPaquete);

            while (recursos.hasMoreElements()) {
                URL recurso = recursos.nextElement();

                if ("file".equals(recurso.getProtocol())) {
                    File directorio = new File(decodificarRuta(recurso.getFile()));
                    descubrirEnDirectorio(directorio, operaciones);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("No fue posible descubrir las operaciones del paquete.", e);
        }

        Collections.sort(operaciones, Comparator.comparing(Operacion::getNombre));
        return operaciones;
    }

    private void descubrirEnDirectorio(File directorio, List<Operacion> operaciones) throws Exception {
        if (!directorio.exists() || !directorio.isDirectory()) {
            return;
        }

        File[] archivos = directorio.listFiles();
        if (archivos == null) {
            return;
        }

        for (File archivo : archivos) {
            String nombre = archivo.getName();

            if (!nombre.endsWith(".class")) {
                continue;
            }

            String nombreClase = nombrePaquete + "." + nombre.substring(0, nombre.length() - 6);
            Class<?> clase = Class.forName(nombreClase);

            if (esOperacionConcreta(clase)) {
                Operacion operacion = (Operacion) clase.getDeclaredConstructor().newInstance();
                operaciones.add(operacion);
            }
        }
    }

    private boolean esOperacionConcreta(Class<?> clase) {
        return Operacion.class.isAssignableFrom(clase)
                && !clase.isInterface()
                && !Modifier.isAbstract(clase.getModifiers());
    }

    private String decodificarRuta(String ruta) throws UnsupportedEncodingException {
        return URLDecoder.decode(ruta, StandardCharsets.UTF_8.name());
    }
}
