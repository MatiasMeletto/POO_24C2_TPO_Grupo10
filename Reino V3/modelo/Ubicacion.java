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
    public Ubicacion(String nombre, boolean esNeutral, ControladorJuego controlador) {
        this.nombre = nombre;
        this.esNeutral = esNeutral;
        this.caminosPosibles = new ArrayList<>();
        this.criaturas = new ArrayList<>();
        if (!this.esNeutral) {
            double tipoEnemigo = Math.random();
            if (tipoEnemigo >= 0 && tipoEnemigo <= 0.37) {
                for (int i = 0; i < 3; i++) {
                    if (Math.random() > 0.6){
                        Criatura c = new Troll();
                        this.criaturas.add(c);
                    }
                }
            }else if (tipoEnemigo >= 0.38 && tipoEnemigo <= 0.74) {
                for (int i = 0; i < 3; i++) {
                    if (Math.random() > 0.35){
                        Criatura c = new Espectro();
                        this.criaturas.add(c);
                    }
                }
            }else if (tipoEnemigo >= 0.75 && tipoEnemigo <= 1) {
                for (int i = 0; i < 3; i++) {
                    if (Math.random() > 0.75){
                        Criatura c = new Dragon();
                        this.criaturas.add(c);
                    }
                }
            }
        }
        if (criaturas.isEmpty()){
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

    public void crearCombate(Personaje heroe, ControladorJuego controlador) {
        if (!esNeutral && controlador != null) { // Verifica que controlador no sea nulo
            VistaCombate.mostrar(controlador, heroe, criaturas);
        }
    }
}
