package vista;

import controlador.ControladorJuego;

import javax.swing.*;
import java.awt.*;

public class VistaHub extends JFrame {
    private ControladorJuego controlador;

    public VistaHub(ControladorJuego controlador) {
        this.controlador = controlador;

        // Configuración de la ventana
        setTitle("Hub del Reino de Uadengard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2, 10, 10)); // Disposición de los botones en una cuadrícula

        // Botón para el mapa
        JButton botonMapa = new JButton("Mapa");
        botonMapa.addActionListener(e -> {
            this.dispose();
            VistaMapa.mostrar(controlador, controlador.getMapa());
        });
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
            JDialog dialogoEstado = new JDialog(this, "Estado del Personaje", true);
            dialogoEstado.setSize(400, 300);
            dialogoEstado.setLocationRelativeTo(this);
            dialogoEstado.add(new VistaEstadoPersonaje(controlador).getPanelEstado());
            dialogoEstado.setVisible(true);
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

    // Método para mostrar esta vista desde el controlador
    public static void mostrar(ControladorJuego controlador) {
        SwingUtilities.invokeLater(() -> new VistaHub(controlador).setVisible(true));
    }
}
