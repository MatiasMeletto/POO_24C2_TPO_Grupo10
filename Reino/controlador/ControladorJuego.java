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
    private VistaMapa vistaMapa;
    private VistaHub vistaHub;

    private ControladorJuego() {
        ventanaPrincipal = new JFrame("Reino de Uadengard");
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaPrincipal.setUndecorated(true);
        ventanaPrincipal.setVisible(true);  
        ventanaPrincipal.setLayout(new BorderLayout()); // Usa BorderLayout para centrar el contenido
        
        personaje = new Mago("Temporal");
        mapa = new Mapa(personaje, this);
        vistaMapa = new VistaMapa(this, mapa);

    }

    public static ControladorJuego getInstancia() {
        if (instancia == null) {
            instancia = new ControladorJuego();
        }
        return instancia;
    }

    public void cambiarVista(JPanel nuevaVista) {
        if (nuevaVista == null) {
            throw new IllegalArgumentException("La vista proporcionada no puede ser null");
        }
        if (nuevaVista instanceof VistaMapa) {
            vistaMapa.setVisible(true); // Asegúrate de que sea visible
        }
        ventanaPrincipal.getContentPane().removeAll(); // Limpia el contenido actual
        ventanaPrincipal.getContentPane().add(nuevaVista, BorderLayout.CENTER); // Añade la nueva vista
        nuevaVista.setVisible(true); // Asegúrate de que sea visible
        ventanaPrincipal.revalidate();
        ventanaPrincipal.repaint();
    }
    
    public void iniciarJuego() {
        
            // Asegúrate de reiniciar todo correctamente
        personaje = null;
        mapa = null;

        // Inicia con la pantalla de ingreso de nombre
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
        mapa = new Mapa(personaje, this);
        vistaMapa = new VistaMapa(this, mapa); // Inicializa VistaMapa
        vistaHub = new VistaHub(this); // Inicializa VistaHub
        cambiarVista(new VistaHub(this)); // Muestra el hub
    }

    public void mostrarMapa() {
        if (vistaMapa == null) {
            vistaMapa = new VistaMapa(this, mapa); // Reasegura la inicialización si es null
        }
        cambiarVista(vistaMapa); // Cambia a la vista del mapa
    }

    public void actualizarMapaVista() {
        if (vistaMapa != null) {
            vistaMapa.actualizarVisibilidadUbicaciones(); // Refresca las ubicaciones disponibles
        }
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void mostrarHub() {
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
