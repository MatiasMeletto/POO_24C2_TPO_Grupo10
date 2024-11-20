package controlador;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Arquero;
import modelo.Guerrero;
import modelo.Mago;
import modelo.Mapa;
import modelo.Personaje;
import vista.IngresoNombre;
import vista.VistaHub;
import vista.VistaMapa;

public class ControladorJuego {
    private static ControladorJuego instancia;
    private JFrame ventanaPrincipal;
    private Personaje personaje;
    private Mapa mapa;

    private ControladorJuego() {
        ventanaPrincipal = new JFrame("Reino de Uadengard");
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(800, 600); // Tamaño fijo de la ventana
        ventanaPrincipal.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        ventanaPrincipal.setLayout(new BorderLayout()); // Usa BorderLayout para centrar el contenido
        ventanaPrincipal.setVisible(true);

    }
    public static ControladorJuego getInstancia() {
        if (instancia == null) {
            instancia = new ControladorJuego();
        }
        return instancia;
    }
    public void cambiarVista(JPanel nuevaVista) {
        ventanaPrincipal.getContentPane().removeAll(); // Limpia el contenido actual.
        ventanaPrincipal.add(nuevaVista, BorderLayout.CENTER); // Añade la vista centrada.
    
        nuevaVista.setBounds(0, 0, ventanaPrincipal.getWidth(), ventanaPrincipal.getHeight()); 
        ventanaPrincipal.revalidate();
        ventanaPrincipal.repaint();
    
        // Forzar el tamaño de la ventana principal
        ventanaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaPrincipal.setUndecorated(true);
        ventanaPrincipal.setVisible(true);  
    }
    
    public void iniciarJuego() {
        ventanaPrincipal.setSize(400, 150); // Tamaño reducido para ingresar el nombre
        cambiarVista(new IngresoNombre(this));
    }

    public void seleccionarPersonaje(String nombre, String claseSeleccionada) {
        switch (claseSeleccionada) {
            case "Mago":
                personaje = new Mago(nombre);
                break;
            case "Guerrero":
                personaje = new Guerrero(nombre);
                break;
            case "Arquero":
                personaje = new Arquero(nombre);
                break;
            default:
                throw new IllegalArgumentException("Clase de personaje no válida: " + claseSeleccionada);
        }
        iniciarMapa();
        cambiarVista(new VistaHub(this)); // Muestra el hub
    }

    public void mostrarMapa() {
        if (mapa == null) {
            mapa = new Mapa(personaje, this); // Crea el mapa si no existe.
        }
        ventanaPrincipal.setSize(1000, 1000); // Ajusta el tamaño para el mapa
        cambiarVista(new VistaMapa(this, mapa));
    }

    public void iniciarMapa() {
        mapa = new Mapa(personaje, this);
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void mostrarHub() {
        ventanaPrincipal.setSize(400, 300); // Tamaño reducido para el hub
        cambiarVista(new VistaHub(this));
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void reiniciarJuego() {
        personaje = null;
        mapa = null;
        cambiarVista(new IngresoNombre(this));
    }
}
