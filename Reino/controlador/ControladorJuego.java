package controlador;

import modelo.*;
import vista.*;
import java.awt.Frame;

public class ControladorJuego {
    private Personaje personaje;
    private Mapa mapa;

    public ControladorJuego() {
        // El mapa se inicializa después de seleccionar el personaje
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
        VistaHub.mostrar(this);
        iniciarMapa();
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void iniciarMapa() {
        mapa = new Mapa(personaje, this); // Se pasa el controlador al mapa
    }
      
    public Personaje getPersonaje() {
        return personaje;
    }

    public void mostrarMapa() {
        if (mapa == null) {
            mapa = new Mapa(personaje, this); // Crea el mapa si no existe.
        }
        VistaMapa.mostrar(this, mapa); // Muestra la vista del mapa.
    }

    public void reiniciarJuego() {
        // Eliminar referencias estáticas de VistaMapa
        VistaMapa.getInstancia(null, null).derrotado(); // Llama a derrotado() para liberar recursos
        
        // Reiniciar referencias de juego
        personaje = null;
        mapa = null;
    
        // Cerrar todas las ventanas activas
        Frame[] frames = Frame.getFrames();
        for (Frame frame : frames) {
            frame.dispose();
        }
    
        // Mostrar la pantalla de ingreso de nombre nuevamente
        javax.swing.SwingUtilities.invokeLater(() -> {
            IngresoNombre ingresoNombre = new IngresoNombre(this);
            ingresoNombre.setVisible(true);
        });
    }
    
    
}
