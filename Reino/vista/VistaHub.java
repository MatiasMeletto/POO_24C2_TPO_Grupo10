package vista;

import controlador.ControladorJuego;

import javax.swing.*;
import java.awt.*;

public class VistaHub extends JPanel {
    private ControladorJuego controlador;

    public VistaHub(ControladorJuego controlador) {
        this.controlador = controlador;

        // Configuración del panel
        setLayout(new GridLayout(2, 2, 10, 10)); // Disposición de los botones en una cuadrícula

        // Botón para el mapa
        JButton botonMapa = new JButton("Mapa");
        botonMapa.addActionListener(e -> controlador.cambiarVista(new VistaMapa(controlador, controlador.getMapa())));
        add(botonMapa);

        // Botón para misiones secundarias
        JButton botonMisiones = new JButton("Misiones Secundarias");
        botonMisiones.addActionListener(e -> {
            // Mostrar la vista de misiones (por implementar)
            JOptionPane.showMessageDialog(this, "Pantalla de misiones no implementada aún.");
        });
        add(botonMisiones);

        // Botón para el estado del personaje
        JButton botonEstado = new JButton("Estado del Personaje");
        botonEstado.addActionListener(e -> {
            // Mostrar la vista de estado del personaje
            JPanel panelEstado = new VistaEstadoPersonaje(controlador).getPanelEstado();
            controlador.cambiarVista(panelEstado); // Cambia la vista al estado del personaje
        });
        add(botonEstado);

        // Botón para el inventario
        JButton botonInventario = new JButton("Inventario");
        botonInventario.addActionListener(e -> {
            // Mostrar la vista de inventario (por implementar)
            JOptionPane.showMessageDialog(this, "Inventario no implementado aún.");
        });
        add(botonInventario);
    }

    // Método estático para mostrar esta vista desde el controlador
    public static void mostrar(ControladorJuego controlador) {
        controlador.cambiarVista(new VistaHub(controlador));
    }
}
