package vista;

import controlador.ControladorJuego;
import modelo.Combate;
import modelo.Criatura;
import modelo.Personaje;

import javax.swing.*;
import java.awt.*;

public class VistaCombate extends JFrame {

    private JTextArea areaCombate;

    public VistaCombate(ControladorJuego controlador, Personaje heroe, Criatura criatura) {
        // Configuración de la ventana
        setTitle("Combate");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área de texto para mostrar el combate
        areaCombate = new JTextArea();
        areaCombate.setEditable(false);
        areaCombate.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaCombate.setLineWrap(true);
        areaCombate.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(areaCombate);
        add(scrollPane, BorderLayout.CENTER);

        // Ejecutar el combate y mostrar el resultado
        mostrarCombate(controlador, heroe, criatura);
    }

    private void mostrarCombate(ControladorJuego controlador, Personaje heroe, Criatura criatura) {
        Combate combate = new Combate(heroe, criatura);
        StringBuilder resultadoCombate = new StringBuilder("¡Comienza el combate!\n");

        // Ejecutar el combate completo y registrar los eventos
        while (!combate.estaTerminado()) {
            resultadoCombate.append(combate.ejecutarTurno());
            resultadoCombate.append("\n");
        }

        // Mostrar el resultado final del combate
        resultadoCombate.append(combate.getResultadoFinal());
        
        // Mostrar el resultado del combate en el área de texto
        areaCombate.setText(resultadoCombate.toString());
    }
}

