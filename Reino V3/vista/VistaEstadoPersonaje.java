package vista;

import modelo.Personaje;
import controlador.ControladorJuego;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class VistaEstadoPersonaje extends JFrame {

    private JLabel labelNombre;

    private ControladorJuego controlador;

    public VistaEstadoPersonaje(ControladorJuego controlador) {
        this.controlador = controlador;

        // Configuración de la ventana
        setTitle("Estado del Personaje");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Agregar el panel de estado y el botón para cerrar
        add(getPanelEstado(), BorderLayout.CENTER);

        JButton botonContinuar = new JButton("Continuar");
        botonContinuar.addActionListener(e -> dispose()); // Cierra la ventana al continuar
        add(botonContinuar, BorderLayout.SOUTH);
    }

    // Método para crear y devolver solo el panel con el estado del personaje
    public JPanel getPanelEstado() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        // Obtener el personaje desde el controlador
        Personaje personaje = controlador.getPersonaje();

        List<JLabel> labels = personaje.obtenerLabels();

        for (JLabel jLabel : labels) {
            panel.add(jLabel);
        }
        return panel;
    }

    // Método para actualizar los datos del personaje si fuera necesario
    public void mostrarEstado(Personaje personaje) {
        labelNombre.setText("Nombre: " + personaje.getNombre());

        setVisible(true);
    }
}

