package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.ControladorJuego;
import modelo.Personaje;

public class VistaEstadoPersonaje extends JPanel {

    private ControladorJuego controlador;

    public VistaEstadoPersonaje(ControladorJuego controlador) {
        this.controlador = controlador;

        // Configuración del panel principal
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240)); // Fondo claro

        // Título
        JLabel titulo = new JLabel("Estado del Personaje", JLabel.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 24));
        titulo.setForeground(new Color(0, 51, 102)); // Azul oscuro
        add(titulo, BorderLayout.NORTH);

        // Panel central con el estado del personaje
        add(getPanelEstado(), BorderLayout.CENTER);

        // Botón para volver al Hub
        JButton botonVolverHub = new JButton("Volver al Hub");
        botonVolverHub.setFont(new Font("Arial", Font.PLAIN, 16));
        botonVolverHub.setBackground(new Color(173, 216, 230)); // Azul claro
        botonVolverHub.setForeground(new Color(0, 51, 102)); // Azul oscuro
        botonVolverHub.setFocusPainted(false);
        botonVolverHub.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonVolverHub.addActionListener(e -> controlador.cambiarVista(new VistaHub(controlador)));
        add(botonVolverHub, BorderLayout.SOUTH);
    }

    // Método para crear y devolver el panel con el estado del personaje
    private JPanel getPanelEstado() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10)); // Espaciado entre elementos
        panel.setBackground(new Color(255, 255, 255)); // Fondo blanco
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margen interno

        // Obtener el personaje desde el controlador
        Personaje personaje = controlador.getPersonaje();

        // Crear las etiquetas con los datos del personaje
        List<JLabel> labels = personaje.obtenerLabels();
        for (JLabel jLabel : labels) {
            jLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            jLabel.setForeground(new Color(0, 51, 102)); // Azul oscuro
            panel.add(jLabel);
        }

        return panel;
    }
}
