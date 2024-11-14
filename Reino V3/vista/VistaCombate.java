package vista;

import modelo.Combate;
import modelo.Criatura;
import modelo.Personaje;

import javax.swing.*;
import java.awt.*;

public class VistaCombate extends JFrame {

    private JTextArea areaCombate;

    public VistaCombate(Personaje heroe, Criatura criatura) {
        setTitle("Combate");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        areaCombate = new JTextArea();
        areaCombate.setEditable(false);
        areaCombate.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaCombate.setLineWrap(true);
        areaCombate.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(areaCombate);
        add(scrollPane, BorderLayout.CENTER);

        iniciarCombate(heroe, criatura);
    }

    private void iniciarCombate(Personaje heroe, Criatura criatura) {
        Combate combate = new Combate(heroe, criatura);
        String resultadoCombate = combate.iniciarCombate();
        areaCombate.setText(resultadoCombate);
    }

    public static void mostrar(Personaje heroe, Criatura criatura) {
        SwingUtilities.invokeLater(() -> new VistaCombate(heroe, criatura).setVisible(true));
    }
}




