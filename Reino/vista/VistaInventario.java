package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

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

        // Configuración del panel
        setLayout(new BorderLayout());
        JPanel panelCentral = new JPanel();
        if(!inventario.isEmpty()){       
            panelCentral.setLayout(new GridLayout(inventario.size(), 1));
            for (Objeto o : inventario){
                JLabel j = new JLabel(o.getNombre(),JLabel.CENTER);
                panelCentral.add(j); 

            }
        }else {
            JLabel a = new JLabel("Aun no tienes objetos",JLabel.CENTER); 
            panelCentral.add(a);
        }
        
        add(new JScrollPane(panelCentral), BorderLayout.CENTER); // Hacer scrollable si la lista es grande

        // Botón para volver al Hub
        JButton botonVolverHub = new JButton("Volver al Hub");
        botonVolverHub.addActionListener(e -> controlador.cambiarVista(new VistaHub(controlador)));
        add(botonVolverHub, BorderLayout.SOUTH);
    }
}