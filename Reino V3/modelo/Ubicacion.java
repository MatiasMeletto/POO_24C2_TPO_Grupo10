package modelo;

import java.util.ArrayList;
import java.util.List;

import controlador.ControladorJuego;
import vista.VistaCombate;

public class Ubicacion {
    private String nombre;
    private List<Criatura> criaturas;
    private boolean esNeutral;
    private List<Ubicacion> caminosPosibles;
    private ControladorJuego controlador; // Referencia al controlador

    public Ubicacion(String nombre, boolean esNeutral, ControladorJuego controlador) {
        this.nombre = nombre;
        this.esNeutral = esNeutral;
        this.caminosPosibles = new ArrayList<>();
        this.criaturas = new ArrayList<>();
        if (!this.esNeutral) {
            Criatura c = new Troll(); // Ejemplo con Troll
            this.criaturas.add(c);
        }
    }
    public void agregarCamino(Ubicacion ubicacion) {
        caminosPosibles.add(ubicacion);
    }

    public List<Ubicacion> getCaminosPosibles() {
        return caminosPosibles;
    }

    public String getNombre() {
        return nombre;
    }

    public void crearCombate(Personaje heroe, ControladorJuego controlador) {
        if (!esNeutral && controlador != null) { // Verifica que controlador no sea nulo
            VistaCombate.mostrar(controlador, heroe, criaturas);
        }
    }
    
    
}
