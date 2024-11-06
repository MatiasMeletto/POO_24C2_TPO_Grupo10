package vista;

import controlador.ControladorJuego;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaSeleccionClase extends JFrame {

    private ControladorJuego controlador;

    public VistaSeleccionClase(ControladorJuego controlador, String nombreJugador) {
        this.controlador = controlador;

        // Configuración de la ventana
        setTitle("Selecciona tu Clase");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Mensaje de selección
        JLabel mensaje = new JLabel("Bienvenido, " + nombreJugador + ". Selecciona tu clase:", JLabel.CENTER);
        mensaje.setFont(new Font("Arial", Font.BOLD, 16));
        add(mensaje, BorderLayout.NORTH);

        // Panel central para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        JButton botonMago = new JButton("Mago");
        JButton botonGuerrero = new JButton("Guerrero");
        JButton botonArquero = new JButton("Arquero");

        // Agregar listeners a los botones
        botonMago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.seleccionarPersonaje(nombreJugador, "Mago");
                dispose();
            }
        });

        botonGuerrero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.seleccionarPersonaje(nombreJugador, "Guerrero");
                dispose();
            }
        });

        botonArquero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.seleccionarPersonaje(nombreJugador, "Arquero");
                dispose();
            }
        });

        panelBotones.add(botonMago);
        panelBotones.add(botonGuerrero);
        panelBotones.add(botonArquero);
        add(panelBotones, BorderLayout.CENTER);
    }

    // Método estático para crear y mostrar la instancia de VistaSeleccionClase
    public static void mostrar(ControladorJuego controlador, String nombreJugador) {
        SwingUtilities.invokeLater(() -> new VistaSeleccionClase(controlador, nombreJugador).setVisible(true));
    }
}


