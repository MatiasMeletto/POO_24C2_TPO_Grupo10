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
    private Runnable eventoEspecial;
    
    public Ubicacion(String nombre, boolean esNeutral, ControladorJuego controlador) {
        this.nombre = nombre;
        this.esNeutral = esNeutral;
        this.caminosPosibles = new ArrayList<>();
        this.criaturas = new ArrayList<>();
        if (!this.esNeutral) {
            double tipoEnemigo = Math.random();
            if (tipoEnemigo >= 0 && tipoEnemigo <= 0.425) {
                Criatura cr = new Troll();
                this.criaturas.add(cr);
                for (int i = 0; i < 2; i++) {
                    if (Math.random() > 0.6){
                        Criatura c = new Troll();
                        this.criaturas.add(c);
                    }
                }
            }else if (tipoEnemigo > 0.425 && tipoEnemigo <= 0.85) {
                Criatura cr = new Espectro();
                this.criaturas.add(cr);
                for (int i = 0; i < 3; i++) {
                    if (Math.random() > 0.35){
                        Criatura c = new Espectro();
                        this.criaturas.add(c);
                    }
                }
            }else if (tipoEnemigo > 0.85 && tipoEnemigo <= 1) {
                Criatura cr = new Dragon();
                this.criaturas.add(cr);
                if (Math.random() > 0.75){
                    Criatura c = new Dragon();
                    this.criaturas.add(c);
                }
            }
        }
        //if (nombre.contains("Torre Espectral")){
        //    for (int i = 0; i < 4; i++) {
        //        Criatura c = new Dragon();
        //        this.criaturas.add(c);
        //    }
        //    this.esNeutral = false;
        //}
    }
    
    public void setEventoEspecial(Runnable eventoEspecial) {
        this.eventoEspecial = eventoEspecial;
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
        if (eventoEspecial != null) {
            eventoEspecial.run(); // Ejecutar el evento especial si está configurado.
        } else if (!esNeutral && controlador != null) {
            VistaCombate.mostrar(controlador, heroe, criaturas); // Mostrar combate si no es neutral.
        } else if (esNeutral) {
            heroe.restaurarVida(); // Restaurar vida en ubicaciones neutrales.
        }
    }
}
