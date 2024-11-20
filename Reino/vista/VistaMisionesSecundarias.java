package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controlador.ControladorJuego;
import modelo.Objeto;

public class VistaMisionesSecundarias extends JPanel {

    private ControladorJuego controlador;

    public VistaMisionesSecundarias(ControladorJuego controlador, List<Objeto> misiones) {
        this.controlador = controlador;

        // Configuración del panel
        setLayout(new BorderLayout());

        // Panel central con la lista de misiones
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(misiones.size(), 1));

        panelCentral.setLayout(new GridLayout(misiones.size(), 1));
            for (Objeto o : misiones){
                JPanel panelMision = new JPanel(new BorderLayout());
                JButton botonReclamar = new JButton("Reclamar");
                List<JLabel> j = o.obtenerLabels();
                for (JLabel l : j) {
                    panelMision.add(l, BorderLayout.CENTER); // Agregar cada objeto como JLabel
                    
                }
                // Habilitar o deshabilitar el botón según si la misión está completada
                botonReclamar.setEnabled(o.Reclamable());
                botonReclamar.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Recompensa reclamada: " + o.getNombre());
                botonReclamar.setEnabled(false); // Deshabilitar el botón después de reclamar
                });
                panelMision.add(botonReclamar, BorderLayout.EAST);
                panelCentral.add(panelMision);
            }

        add(new JScrollPane(panelCentral), BorderLayout.CENTER); // Hacer scrollable si hay muchas misiones

        // Botón para volver al Hub
        JButton botonVolverHub = new JButton("Volver al Hub");
        botonVolverHub.addActionListener(e -> controlador.cambiarVista(new VistaHub(controlador)));
        add(botonVolverHub, BorderLayout.SOUTH);
    }
}