package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.ControladorJuego;
import modelo.Misiones;
import modelo.Personaje;

public class VistaHub extends JPanel {
    private Personaje heroe;
    private ControladorJuego controlador;

    public VistaHub(ControladorJuego controlador) {
        this.controlador = controlador;
        this.heroe = controlador.getPersonaje();

        // Configuración principal del panel
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes externos

        // Título
        JLabel titulo = new JLabel("Hub Principal", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); // Espaciado con el resto del contenido
        add(titulo, BorderLayout.NORTH);

        // Panel central para los botones
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 20, 20));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes internos

        // Crear y configurar botones
        JButton botonMapa = crearBoton("Mapa","");
        botonMapa.addActionListener(e -> controlador.cambiarVista(new VistaMapa(controlador, controlador.getMapa())));
        panelBotones.add(botonMapa);

        JButton botonMisiones = crearBoton("Misiones Secundarias","");
        botonMisiones.addActionListener(e -> controlador.cambiarVista(
            new VistaMisionesSecundarias(controlador, Misiones.getInstancia(null).getObjetos())
        ));
        panelBotones.add(botonMisiones);

        JButton botonEstado = crearBoton("Estado del Personaje","");
        botonEstado.addActionListener(e -> controlador.cambiarVista(new VistaEstadoPersonaje(controlador)));
        panelBotones.add(botonEstado);

        JButton botonInventario = crearBoton("Inventario","");
        botonInventario.addActionListener(e -> controlador.cambiarVista(new VistaInventario(controlador, heroe.obtenerObjetos())));
        panelBotones.add(botonInventario);

        add(panelBotones, BorderLayout.CENTER);

        // Panel inferior con el botón para cerrar el programa
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton botonCerrar = crearBoton("Salir","");
        botonCerrar.setBackground(new Color(178, 34, 34)); // Fondo rojo oscuro
        botonCerrar.addActionListener(e -> System.exit(0)); // Cierra la aplicación
        panelInferior.add(botonCerrar);

        add(panelInferior, BorderLayout.SOUTH);
    }

    /**
     * Método para crear un botón estilizado con espacio para agregar imágenes.
     * @param texto Texto del botón.
     * @return JButton estilizado.
     */
    private JButton crearBoton(String texto,String pathString) {
        JButton boton = new JButton(texto);

        // Estilo del botón
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setPreferredSize(new Dimension(150, 50));
        boton.setFocusPainted(false); // Quitar bordes de enfoque
        boton.setBackground(new Color(70, 130, 180)); // Azul claro
        boton.setForeground(Color.WHITE); // Texto blanco
        boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.DARK_GRAY, 2), // Borde externo
            BorderFactory.createEmptyBorder(10, 10, 10, 10) // Espaciado interno
        ));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        boton.setIcon(new ImageIcon(pathString));

        return boton;
    }

    /**
     * Método estático para mostrar esta vista desde el controlador.
     * @param controlador Controlador principal.
     */
    public static void mostrar(ControladorJuego controlador) {
        controlador.cambiarVista(new VistaHub(controlador));
    }
}
