package controlador;

import modelo.*;
import vista.*;

public class ControladorJuego {
    private Personaje personaje;
    private Mapa mapa;

    public ControladorJuego() {
        // El mapa se inicializa después de seleccionar el personaje
    }

    // Método para crear el personaje basado en la clase seleccionada
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

        // Inicializar el mapa con el personaje seleccionado
        mapa = new Mapa(personaje);

        // Iniciar el mapa directamente después de seleccionar el personaje
        iniciarMapa();
    }

    // Método para mostrar la pantalla del mapa
    public void iniciarMapa() {
        VistaMapa.getInstancia(this, mapa);  // Mostrar la vista del mapa
    }

    // Método para obtener el personaje actual (para uso en otras vistas)
    public Personaje getPersonaje() {
        return personaje;
    }

    public Mapa getMapa() {
        return mapa;
    }
}
