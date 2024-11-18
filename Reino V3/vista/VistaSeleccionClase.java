package vista;

import controlador.ControladorJuego;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaSeleccionClase extends JFrame {
    private static VistaSeleccionClase instancia; // Instancia única de VistaSeleccionClase

    // Constructor privado para implementar el Singleton
    private VistaSeleccionClase(ControladorJuego controlador, String nombreJugador) {
        // Configuración de la ventana
        setTitle("Selecciona tu Clase");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Mensaje de bienvenida
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
                ocultarVentana();
            }
        });

        botonGuerrero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.seleccionarPersonaje(nombreJugador, "Guerrero");
                ocultarVentana();
            }
        });

        botonArquero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.seleccionarPersonaje(nombreJugador, "Arquero");
                ocultarVentana();
            }
        });

        panelBotones.add(botonMago);
        panelBotones.add(botonGuerrero);
        panelBotones.add(botonArquero);
        add(panelBotones, BorderLayout.CENTER);
    }

    // Método estático para obtener la instancia única
    public static VistaSeleccionClase getInstancia(ControladorJuego controlador, String nombreJugador) {
        if (instancia == null) {
            instancia = new VistaSeleccionClase(controlador, nombreJugador);  // Crear la instancia si no existe
        }
        return instancia;
    }

    // Método para mostrar la vista desde el controlador
    public static void mostrar(ControladorJuego controlador, String nombreJugador) {
        SwingUtilities.invokeLater(() -> getInstancia(controlador, nombreJugador).setVisible(true));
    }

    // Método para ocultar la ventana
    private void ocultarVentana() {
        this.dispose();
    }
}
