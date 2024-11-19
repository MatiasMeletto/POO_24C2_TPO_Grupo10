package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VistaCinematica extends JFrame {
    private static VistaCinematica instancia; // Singleton

    private VistaCinematica() {
        setTitle("Cinemática Final");
        setSize(1280, 768);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    public static VistaCinematica getInstancia() {
        if (instancia == null) {
            instancia = new VistaCinematica();
        }
        return instancia;
    }

    public void mostrarCinematica(String videoPath) {
        JFXPanel fxPanel = new JFXPanel();
        add(fxPanel, BorderLayout.CENTER);

        Platform.runLater(() -> {
            // Crear MediaPlayer y MediaView para el video
            Media media = new Media(videoPath); // Ruta del video
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);

            // Layout JavaFX
            VBox root = new VBox(10);
            root.getChildren().addAll(mediaView);
            root.setStyle("-fx-alignment: center; -fx-padding: 10;");

            Scene scene = new Scene(root, 800, 600);

            // Asignar la escena al JFXPanel
            fxPanel.setScene(scene);

            // Configurar acción al finalizar el video
            mediaPlayer.setOnEndOfMedia(() -> {
                // Esperar 1 segundo antes de mostrar el cartel
                Platform.runLater(() -> {
                    try {
                        Thread.sleep(1000); // 1 segundo de espera
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mostrarCartelFelicitaciones();
                });
            });
            mediaPlayer.play();
        });

        setVisible(true);
    }

    private void mostrarCartelFelicitaciones() {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(
                this,
                "<html><h2 style='color:green;'>¡Felicidades!</h2><p>Has completado el juego. Gracias por jugar.</p></html>",
                "Juego Completado",
                JOptionPane.INFORMATION_MESSAGE
            );
            dispose();
            instancia = null; // Liberar instancia para el Singleton
        });
    }
}

