package vista;

import modelo.Combate;
import modelo.Criatura;
import modelo.Personaje;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaCombate extends JFrame {

    private JEditorPane areaCombate;  // Usar JEditorPane en lugar de JTextArea
    private boolean victoria;

    public VistaCombate(Personaje heroe, List<Criatura> criaturas) {
        setTitle("Combate");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Usamos JEditorPane que soporta HTML
        areaCombate = new JEditorPane();
        areaCombate.setEditable(false);  // No editable por el usuario
        areaCombate.setContentType("text/html");  // Establecemos el tipo de contenido a HTML
        areaCombate.setFont(new Font("Monospaced", Font.PLAIN, 14));  // Puedes cambiar la fuente aquí
        areaCombate.setText("");  // Limpiamos el área de texto inicial
        JScrollPane scrollPane = new JScrollPane(areaCombate);
        add(scrollPane, BorderLayout.CENTER);

        iniciarCombate(heroe, criaturas);
    }

    private void iniciarCombate(Personaje heroe, List<Criatura> criaturas) {
        Combate combate = new Combate(heroe, criaturas, true);
        String resultadoCombate = combate.iniciarCombate();
        victoria = combate.getVictoria();
        
        // Establecer el texto HTML en el JEditorPane
        areaCombate.setText(resultadoCombate);
        
        mostrarResultado();
    }

    private void mostrarResultado() {
        

        // Al final, mostramos el botón para continuar
        JButton continuarButton = new JButton("Continuar");
        continuarButton.addActionListener(e -> {
            // Si el héroe ha perdido, mostramos el mensaje de derrota
        if (!victoria) {
            areaCombate.setText(areaCombate.getText() + "<br>¡Has sido derrotado! Fin del juego.");
            JOptionPane.showMessageDialog(
                this,
                "Game Over",
                "Fin del Juego",
                JOptionPane.INFORMATION_MESSAGE
            );
            VistaMapa.getInstancia(null, null).derrotado();
        } else {
            areaCombate.setText(areaCombate.getText() + "<br>¡Has ganado el combate! Felicitaciones.");
        }// Mostrar mensaje de "Game Over"
            
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
