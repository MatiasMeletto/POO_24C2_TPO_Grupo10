package vista;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorJuego;

public class IngresoNombre extends JPanel {
    private JTextField campoNombre;
    private Image imagenFondo = new ImageIcon("C:/resources/imagenes/menuPrincipal.jpg").getImage();

    public IngresoNombre(ControladorJuego controlador) {
        File archivo = new File("C:/resources/imagenes/menuPrincipal.jpg");
        if (!archivo.exists()) {
            System.err.println("El archivo de imagen no se encuentra en la ruta especificada.");
        }
        // Configuración del layout principal
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes
    
        // Título de bienvenida
        JLabel titulo = new JLabel("Bienvenido al Reino Encantado", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 0; // Fila 0
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centrado
        add(titulo, gbc);
    
        // Etiqueta y campo de texto
        JLabel etiquetaNombre = new JLabel("Ingrese su nombre: ");
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 1; // Fila 1
        gbc.gridwidth = 1; // Ocupa una columna
        gbc.anchor = GridBagConstraints.EAST; // Alineado a la derecha
        add(etiquetaNombre, gbc);
    
        campoNombre = new JTextField(20);
        gbc.gridx = 1; // Columna 1
        gbc.gridy = 1; // Fila 1
        gbc.anchor = GridBagConstraints.WEST; // Alineado a la izquierda
        add(campoNombre, gbc);
    
        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonAceptar = new JButton("Aceptar");
        JButton botonCancelar = new JButton("Cancelar");
    
        botonAceptar.addActionListener(e -> {
            String nombre = campoNombre.getText().trim();
            if (!nombre.isEmpty()) {
                controlador.cambiarVista(new VistaSeleccionClase(controlador, nombre));
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese su nombre.");
            }
        });
    
        botonCancelar.addActionListener(e -> System.exit(0));
    
        panelBotones.add(botonAceptar);
        panelBotones.add(botonCancelar);
    
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 2; // Fila 2
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centrado
        add(panelBotones, gbc);
    }    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        } else {
            System.err.println("La imagen de fondo no se pudo cargar.");
        }
    }
}

