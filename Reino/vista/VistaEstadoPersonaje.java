package vista;

import modelo.Personaje;
import controlador.ControladorJuego;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class VistaEstadoPersonaje extends JPanel {

    private ControladorJuego controlador;

    public VistaEstadoPersonaje(ControladorJuego controlador) {
        this.controlador = controlador;

        // Configuración del panel
        setLayout(new BorderLayout());

        // Panel central con el estado del personaje
        add(getPanelEstado(), BorderLayout.CENTER);

        // Botón para volver al Hub
        JButton botonVolverHub = new JButton("Volver al Hub");
        botonVolverHub.addActionListener(e -> controlador.cambiarVista(new VistaHub(controlador)));
        add(botonVolverHub, BorderLayout.SOUTH);
    }

    // Método para crear y devolver el panel con el estado del personaje
    public JPanel getPanelEstado() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        // Obtener el personaje desde el controlador
        Personaje personaje = controlador.getPersonaje();

        // Crear las etiquetas con los datos del personaje
        List<JLabel> labels = personaje.obtenerLabels();

        for (JLabel jLabel : labels) {
            panel.add(jLabel);
        }
        return panel;
    }
}
