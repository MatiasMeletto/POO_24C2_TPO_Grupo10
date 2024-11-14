package modelo;

import java.util.ArrayList;
import java.util.List;

public class Ubicacion {
    private String nombre;
    private List<Criatura> criaturas;
    private boolean esNeutral;
    private List<Ubicacion> caminosPosibles;

    public Ubicacion(String nombre, boolean esNeutral) {
        this.nombre = nombre;
        this.esNeutral = esNeutral;
        this.caminosPosibles = new ArrayList<>();
        this.criaturas = new ArrayList<>();
        if (!this.esNeutral) {
            for (int i = 0; i < 3; i++) {
                if (Math.random() < 0.50) {
                    Criatura c = new Espectro(); // Ejemplo con Dragon
                    this.criaturas.add(c);
                }
            }
        }
        if (this.criaturas.isEmpty()) {
            this.esNeutral = true;
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

    public boolean esNeutral() {
        return esNeutral;
    }

    public List<Criatura> getCriaturas() {
        return criaturas;
    }
}

