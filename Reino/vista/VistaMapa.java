package vista;

import controlador.ControladorJuego;
import modelo.Mapa;
import modelo.Ubicacion;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VistaMapa extends JPanel {

    private Mapa mapa;
    private JLabel titulo;
    private JPanel panelMapa;
    private Map<Ubicacion, JButton> botonesUbicaciones;
    private ControladorJuego controlador;

    // Constructor
    public VistaMapa(ControladorJuego controlador, Mapa mapa) {
        this.controlador = controlador;
        this.mapa = mapa;
        this.botonesUbicaciones = new HashMap<>();

        // Configuración del panel
        setLayout(new BorderLayout());

        // Título que muestra la ubicación actual
        titulo = new JLabel("Mapa del Reino de Uadengard", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo, BorderLayout.NORTH);

        // Panel para mostrar el mapa en una cuadrícula de 20 filas y 3 columnas
        panelMapa = new JPanel();
        panelMapa.setLayout(new GridLayout(20, 3, 10, 10));
        add(panelMapa, BorderLayout.CENTER);

        // Crear los botones y añadirlos en la disposición deseada
        inicializarBotonesUbicaciones();

        // Habilitar manualmente el primer botón después de la inicialización
        Ubicacion ubicacionInicial = mapa.getUbicacionActual();
        JButton primerBoton = botonesUbicaciones.get(ubicacionInicial);
        if (primerBoton != null) {
            primerBoton.setEnabled(true); // Habilitar el primer botón
        }

        // Botón para volver al Hub
        JButton botonVolverHub = new JButton("Volver al Hub");
        botonVolverHub.addActionListener(e -> controlador.cambiarVista(new VistaHub(controlador)));
        add(botonVolverHub, BorderLayout.SOUTH);
    }

    private void inicializarBotonesUbicaciones() {
        // Crear espacios vacíos en la cuadrícula
        for (int i = 0; i < 60; i++) {
            panelMapa.add(new JLabel(""));
        }

        // Añadir botones de ubicaciones en las posiciones específicas de acuerdo con las bifurcaciones
        agregarBotonUbicacion(mapa.getUbicaciones().get(0), 0, 1);   // Entrada del Reino
        agregarBotonUbicacion(mapa.getUbicaciones().get(1), 1, 1);   // Camino del Bosque
        agregarBotonUbicacion(mapa.getUbicaciones().get(2), 2, 1);   // Bosque Encantado
        agregarBotonUbicacion(mapa.getUbicaciones().get(3), 3, 0);   // Colina del Viento (bifurcación izquierda)
        agregarBotonUbicacion(mapa.getUbicaciones().get(4), 3, 2);   // Lago de Cristal (bifurcación derecha)
        agregarBotonUbicacion(mapa.getUbicaciones().get(5), 4, 1);   // Caverna Oscura
        agregarBotonUbicacion(mapa.getUbicaciones().get(6), 5, 0);   // Puente Antiguo (bifurcación izquierda)
        agregarBotonUbicacion(mapa.getUbicaciones().get(7), 5, 2);   // Llanura Rocosa (bifurcación derecha)
        agregarBotonUbicacion(mapa.getUbicaciones().get(8), 6, 1);   // Montaña Helada (en el centro)
        agregarBotonUbicacion(mapa.getUbicaciones().get(9), 7, 1);   // Pantano de la Niebla
        agregarBotonUbicacion(mapa.getUbicaciones().get(10), 8, 1);  // Pueblo Abandonado
        agregarBotonUbicacion(mapa.getUbicaciones().get(11), 9, 1);  // Torre de Vigilancia
        agregarBotonUbicacion(mapa.getUbicaciones().get(12), 10, 0); // Bosque Sombrío (bifurcación izquierda)
        agregarBotonUbicacion(mapa.getUbicaciones().get(13), 10, 2); // Ruinas Antiguas (bifurcación derecha)
        agregarBotonUbicacion(mapa.getUbicaciones().get(14), 11, 1); // Campo de Batalla
        agregarBotonUbicacion(mapa.getUbicaciones().get(15), 12, 0); // Valle de los Ecos (bifurcación izquierda)
        agregarBotonUbicacion(mapa.getUbicaciones().get(16), 12, 2); // Altar Oscuro (bifurcación derecha)
        agregarBotonUbicacion(mapa.getUbicaciones().get(17), 13, 0); // Foso Profundo (bifurcación izquierda)
        agregarBotonUbicacion(mapa.getUbicaciones().get(18), 13, 2); // Cueva de los Tesoros (bifurcación derecha)
        agregarBotonUbicacion(mapa.getUbicaciones().get(19), 14, 1); // Trono del Rey Olvidado
        agregarBotonUbicacion(mapa.getUbicaciones().get(20), 15, 1); // Bosque Profundo
        agregarBotonUbicacion(mapa.getUbicaciones().get(21), 16, 1); // Altar Sagrado
        agregarBotonUbicacion(mapa.getUbicaciones().get(22), 17, 0); // Colina Brumosa (bifurcación izquierda)
        agregarBotonUbicacion(mapa.getUbicaciones().get(23), 17, 2); // Desierto Sombrío (bifurcación derecha)
        agregarBotonUbicacion(mapa.getUbicaciones().get(24), 18, 1); // Cascada Silenciosa
        agregarBotonUbicacion(mapa.getUbicaciones().get(25), 19, 1); // Torre Espectral

        // Validar y repintar el panel para asegurar que se actualice visualmente
        panelMapa.revalidate();
        panelMapa.repaint();
    }

    private void agregarBotonUbicacion(Ubicacion ubicacion, int fila, int columna) {
        JButton botonUbicacion = new JButton(ubicacion.getNombre());
        botonUbicacion.setEnabled(false);

        botonUbicacion.addActionListener(e -> {
            mapa.avanzar(ubicacion, controlador);
            botonUbicacion.setEnabled(false);
            actualizarVisibilidadUbicaciones();
        });

        int posicion = fila * 3 + columna;
        panelMapa.remove(posicion);
        panelMapa.add(botonUbicacion, posicion);
        botonesUbicaciones.put(ubicacion, botonUbicacion);
    }

    public void actualizarVisibilidadUbicaciones() {
        Ubicacion ubicacionActual = mapa.getUbicacionActual();
        List<Ubicacion> caminosDisponibles = ubicacionActual.getCaminosPosibles();
    
        // Deshabilitar todos los botones
        for (Map.Entry<Ubicacion, JButton> entry : botonesUbicaciones.entrySet()) {
            entry.getValue().setEnabled(false); // Deshabilita todos los botones
        }
    
        // Habilitar solo los botones de los caminos disponibles
        for (Ubicacion ubicacion : caminosDisponibles) {
            JButton botonSiguiente = botonesUbicaciones.get(ubicacion);
            if (botonSiguiente != null) {
                botonSiguiente.setEnabled(true); // Habilita los botones accesibles
            }
        }
        
        titulo.setText("Ubicación actual: " + ubicacionActual.getNombre());

        panelMapa.revalidate();
        panelMapa.repaint();
    }
}
