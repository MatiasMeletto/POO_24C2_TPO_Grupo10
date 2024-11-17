package vista;

import modelo.Combate;
import modelo.Criatura;
import modelo.Personaje;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaCombate extends JFrame {

    private JTextArea areaCombate;
    private boolean victoria;

    public VistaCombate(Personaje heroe, List<Criatura> criaturas) {
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

        iniciarCombate(heroe, criaturas);
    }

    private void iniciarCombate(Personaje heroe, List<Criatura> criaturas) {
        Combate combate = new Combate(heroe, criaturas, true);
        String resultadoCombate = combate.iniciarCombate();
        victoria = combate.getVictoria();  // Almacenamos el resultado (victoria o derrota)
        areaCombate.setText(resultadoCombate);
        
        mostrarResultado();
    }

    private void mostrarResultado() {
        // Si el héroe ha perdido, mostramos el mensaje de derrota
        if (!victoria) {
            areaCombate.append("\n¡Has sido derrotado! Fin del juego.");
        } else {
            areaCombate.append("\n¡Has ganado el combate! Felicitaciones.");
        }

        // Al final, mostramos el botón para continuar
        JButton continuarButton = new JButton("Continuar");
        continuarButton.addActionListener(e -> {
            // Mostrar mensaje de "Game Over"
            JOptionPane.showMessageDialog(
                this,
                "Game Over",
                "Fin del Juego",
                JOptionPane.INFORMATION_MESSAGE
            );
            // Cerramos la ventana de combate
            this.dispose();  // Cierra la ventana activa
        });

        add(continuarButton, BorderLayout.SOUTH);
        validate();  // Revalidamos la ventana para que el botón se muestre correctamente
    }

    // Método estático para mostrar la vista de combate
    public static void mostrar(Personaje heroe, List<Criatura> criaturas) {
        SwingUtilities.invokeLater(() -> new VistaCombate(heroe, criaturas).setVisible(true));
    }
}
