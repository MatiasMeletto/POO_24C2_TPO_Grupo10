package vista;

import modelo.Combate;
import modelo.Criatura;
import modelo.Personaje;
import controlador.ControladorJuego;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaCombate extends JFrame {

    private JEditorPane areaCombate;  // Usar JEditorPane en lugar de JTextArea
    private boolean victoria;
    private ControladorJuego controlador;

    public VistaCombate(ControladorJuego controlador, Personaje heroe, List<Criatura> criaturas) {
        this.controlador = controlador;
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
        JButton continuarButton = new JButton("Continuar");
        continuarButton.addActionListener(e -> {
            if (!victoria) {
                areaCombate.setText(areaCombate.getText() + "<br>¡Has sido derrotado! Fin del juego.");
                JOptionPane.showMessageDialog(
                    this,
                    "Game Over",
                    "Fin del Juego",
                    JOptionPane.INFORMATION_MESSAGE
                );
                if (controlador != null) {
                    controlador.reiniciarJuego(); // Asegúrate de que controlador no es nulo
                }
            } else {
                areaCombate.setText(areaCombate.getText() + "<br>¡Has ganado el combate! Felicitaciones.");
                this.dispose();
            }
        });
        
    
        add(continuarButton, BorderLayout.SOUTH);
        validate();
    }    

    public static void mostrar(ControladorJuego controlador, Personaje heroe, List<Criatura> criaturas) {
        SwingUtilities.invokeLater(() -> new VistaCombate(controlador, heroe, criaturas).setVisible(true));
    }    
}