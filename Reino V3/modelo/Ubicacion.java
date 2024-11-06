package modelo;

import java.util.ArrayList;
import java.util.List;

public class Ubicacion {
    private String nombre;
    private boolean tieneCriatura;
    private Criatura criatura;
    private boolean esNeutral;
    private List<Ubicacion> caminosPosibles;

    public Ubicacion(String nombre, boolean esNeutral) {
        this.nombre = nombre;
        this.esNeutral = esNeutral;
        this.caminosPosibles = new ArrayList<>();
        this.tieneCriatura = false;
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

    public boolean tieneCriatura() {
        return tieneCriatura;
    }

    public Criatura getCriatura() {
        return criatura;
    }

    public void setCriatura(Criatura criatura) {
        this.criatura = criatura;
        this.tieneCriatura = true;
    }

    public boolean esNeutral() {
        return esNeutral;
    }
}
