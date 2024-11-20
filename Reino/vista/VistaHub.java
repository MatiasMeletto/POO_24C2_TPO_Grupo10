package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controlador.ControladorJuego;
import modelo.Personaje;

public class VistaHub extends JPanel {
    private Personaje heroe;
    private ControladorJuego controlador;

    public VistaHub(ControladorJuego controlador) {
        this.controlador = controlador;
        this.heroe = controlador.getPersonaje();

        // Configuración del panel
        setLayout(new GridLayout(2, 2, 10, 10)); // Disposición de los botones en una cuadrícula

        // Botón para el mapa
        JButton botonMapa = new JButton("Mapa");
        botonMapa.addActionListener(e -> controlador.cambiarVista(new VistaMapa(controlador, controlador.getMapa())));
        add(botonMapa);

        // Botón para misiones secundarias
        JButton botonMisiones = new JButton("Misiones Secundarias");
        botonMisiones.addActionListener(e -> {
            controlador.cambiarVista(new VistaMisionesSecundarias(controlador, heroe.obtenerObjetos()));
        });
        add(botonMisiones);

        // Botón para el estado del personaje
        JButton botonEstado = new JButton("Estado del Personaje");
        botonEstado.addActionListener(e -> {
            // Mostrar la vista de estado del personaje
            controlador.cambiarVista(new VistaEstadoPersonaje(controlador));
        });
        add(botonEstado);

        // Botón para el inventario
        JButton botonInventario = new JButton("Inventario");
        botonInventario.addActionListener(e -> {
            controlador.cambiarVista(new VistaInventario(controlador, heroe.obtenerObjetos()));
        });
        add(botonInventario);
    }

    // Método estático para mostrar esta vista desde el controlador
    public static void mostrar(ControladorJuego controlador) {
        controlador.cambiarVista(new VistaHub(controlador));
    }
}
