package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controlador.ControladorJuego;
import modelo.Arquero;
import modelo.Combate;
import modelo.Criatura;
import modelo.Dragon;
import modelo.Guerrero;
import modelo.Mago;
import modelo.Personaje;
import modelo.Ubicacion;

public class VistaCombate extends JPanel {

    private JEditorPane areaCombate; // Usar JEditorPane en lugar de JTextArea
    private boolean victoria;
    private ControladorJuego controlador;
    private Personaje heroe;
    private boolean combateFinal;
    private Ubicacion ubicacion;

    public VistaCombate(ControladorJuego controlador, Personaje heroe, List<Criatura> criaturas, Ubicacion u) {
        this.heroe = heroe;
        this.controlador = controlador;
        this.victoria = false;
        this.ubicacion = u;

        if (criaturas.size() == 4 && criaturas.get(0) instanceof Dragon) {
            combateFinal = true; // Determina si es el combate final
        }

        // Configuración del panel
        setLayout(new BorderLayout());

        // Usamos JEditorPane que soporta HTML
        areaCombate = new JEditorPane();
        areaCombate.setEditable(false); // No editable por el usuario
        areaCombate.setContentType("text/html"); // Establecemos el tipo de contenido a HTML
        areaCombate.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Puedes cambiar la fuente aquí
        areaCombate.setText(""); // Limpiamos el área de texto inicial
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
        JPanel panelBotones = new JPanel();

        // Botón Continuar
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
                    controlador.reiniciarJuego(); // Reiniciar el juego
                }
            } else {
                areaCombate.setText(areaCombate.getText() + "<br>¡Has ganado el combate! Felicitaciones.");
                heroe.subirNivel();
                ubicacion.iniciarEvento(heroe);

                if (controlador != null) {
                    controlador.mostrarMapa(); // Vuelve al mapa
                    //controlador.actualizarMapaVista();
                }
                
            }
            if (combateFinal) {
                String videoPath = "";
                if (heroe instanceof Mago) {
                    videoPath = "file:///C:/re/mago.mp4";
                } else if (heroe instanceof Arquero) {
                    videoPath = "file:///C:/re/ar.mp4";
                } else if (heroe instanceof Guerrero) {
                    videoPath = "file:///C:/re/gu.mp4";
                }
                VistaCinematica.getInstancia().mostrarCinematica(videoPath);
            }
        });

        // Botón Volver al Hub
        JButton volverHubButton = new JButton("Volver al Hub");
        volverHubButton.addActionListener(e -> controlador.cambiarVista(new VistaHub(controlador)));

        panelBotones.add(continuarButton);
        panelBotones.add(volverHubButton);
        add(panelBotones, BorderLayout.SOUTH);

        validate();
    }

    // Método para mostrar esta vista desde el controlador
    public static void mostrar(ControladorJuego controlador, Personaje heroe, List<Criatura> criaturas,Ubicacion ubicacion) {
        controlador.cambiarVista(new VistaCombate(controlador, heroe, criaturas,ubicacion));
    }
}
