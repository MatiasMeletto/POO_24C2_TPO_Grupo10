package vista;

import modelo.Personaje;
import controlador.ControladorJuego;
import javax.swing.*;
import java.awt.*;

public class VistaEstadoPersonaje extends JFrame {

    private JLabel labelNombre;
    private JLabel labelVida;
    private JLabel labelAtaque;
    private JLabel labelDefensa;
    private JLabel labelExperiencia;

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

        // Crear y configurar etiquetas de estado
        labelNombre = new JLabel("Nombre: " + personaje.getNombre(), JLabel.CENTER);
        labelVida = new JLabel("Vida: " + personaje.getPuntosVida(), JLabel.CENTER);
        labelAtaque = new JLabel("Ataque: " + personaje.getNivelAtaque(), JLabel.CENTER);
        labelDefensa = new JLabel("Defensa: " + personaje.getNivelDefensa(), JLabel.CENTER);
        labelExperiencia = new JLabel("Experiencia: " + personaje.getExperiencia(), JLabel.CENTER);

        // Añadir las etiquetas al panel
        panel.add(labelNombre);
        panel.add(labelVida);
        panel.add(labelAtaque);
        panel.add(labelDefensa);
        panel.add(labelExperiencia);

        return panel;
    }

    // Método para actualizar los datos del personaje si fuera necesario
    public void mostrarEstado(Personaje personaje) {
        labelNombre.setText("Nombre: " + personaje.getNombre());
        labelVida.setText("Vida: " + personaje.getPuntosVida());
        labelAtaque.setText("Ataque: " + personaje.getNivelAtaque());
        labelDefensa.setText("Defensa: " + personaje.getNivelDefensa());
        labelExperiencia.setText("Experiencia: " + personaje.getExperiencia());

        setVisible(true);
    }
}

