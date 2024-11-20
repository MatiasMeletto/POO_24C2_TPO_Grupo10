package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controlador.ControladorJuego;
import modelo.Objeto;

public class VistaInventario extends JPanel {
    private ControladorJuego controlador;

    public VistaInventario(ControladorJuego controlador, List<Objeto> inventario) {
        this.controlador = controlador;

        // Configuración principal del panel
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen exterior

        // Título
        JLabel titulo = new JLabel("Inventario", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        // Panel central
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen interno

        if (!inventario.isEmpty()) {
            // Mostrar objetos del inventario
            for (Objeto o : inventario) {
                JPanel panelObjeto = new JPanel(new BorderLayout());
                panelObjeto.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.GRAY, 1), // Borde gris
                    BorderFactory.createEmptyBorder(10, 10, 10, 10) // Margen interno
                ));

                // Nombre del objeto
                JLabel etiquetaNombre = new JLabel(o.getNombre(), JLabel.LEFT);
                etiquetaNombre.setFont(new Font("Arial", Font.PLAIN, 14));
                panelObjeto.add(etiquetaNombre, BorderLayout.CENTER);

                panelCentral.add(panelObjeto);
                panelCentral.add(Box.createVerticalStrut(10)); // Espaciado entre objetos
            }
        } else {
            // Mensaje de inventario vacío
            JLabel etiquetaVacio = new JLabel("Aún no tienes objetos en tu inventario.", JLabel.CENTER);
            etiquetaVacio.setFont(new Font("Arial", Font.ITALIC, 14));
            panelCentral.add(etiquetaVacio);
        }

        // Hacer el panel central scrollable
        JScrollPane scrollPane = new JScrollPane(panelCentral);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Sin bordes adicionales
        add(scrollPane, BorderLayout.CENTER);

        // Botón para volver al Hub
        JButton botonVolverHub = new JButton("Volver al Hub");
        botonVolverHub.setFont(new Font("Arial", Font.BOLD, 14));
        botonVolverHub.addActionListener(e -> controlador.cambiarVista(new VistaHub(controlador)));
        add(botonVolverHub, BorderLayout.SOUTH);
    }
}
