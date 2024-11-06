package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.ControladorJuego;

public class IngresoNombre extends JFrame {

    private JTextField campoNombre;
    private JButton botonAceptar;
    private JButton botonCancelar;
    private ControladorJuego controlador;

    public IngresoNombre(ControladorJuego controlador) {
        this.controlador = controlador;

        // Configuración de la ventana
        setTitle("Bienvenido al Reino Encantado");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Título de bienvenida
        JLabel titulo = new JLabel("Bienvenido al Reino Encantado", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo, BorderLayout.NORTH);

        // Panel central para el campo de texto
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new FlowLayout());
        JLabel etiquetaNombre = new JLabel("Ingrese su nombre: ");
        campoNombre = new JTextField(20);
        panelCentral.add(etiquetaNombre);
        panelCentral.add(campoNombre);
        add(panelCentral, BorderLayout.CENTER);

        // Panel inferior para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        botonAceptar = new JButton("Aceptar");
        botonCancelar = new JButton("Cancelar");

        // Acciones de los botones
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText().trim();
                if (!nombre.isEmpty()) {
                    dispose();  // Cierra esta ventana
                    VistaSeleccionClase.mostrar(controlador, nombre);  // Abre la ventana de selección de clase
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese su nombre.");
                }
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Salir del juego
                System.exit(0);
            }
        });

        panelBotones.add(botonAceptar);
        panelBotones.add(botonCancelar);
        add(panelBotones, BorderLayout.SOUTH);
    }
}

