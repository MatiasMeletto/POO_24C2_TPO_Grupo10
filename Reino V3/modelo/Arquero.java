package modelo;

import java.util.Random;

public class Arquero extends Personaje {
    private int punteria;
    private int agilidad;

    public Arquero(String nombre) {
        super(nombre, 90, 18, 12);  // Valores de vida, ataque y defensa iniciales para Arquero
        this.punteria = 75;  // Probabilidad inicial de acierto en ataque
        this.agilidad = 20;  // Probabilidad inicial de esquivar golpes
    }

    @Override
    public void habilidadEspecial() {
        // Aumenta la puntería al 100% contra Dragones
        this.punteria = 100;
    }

    @Override
    public void restaurarVida() {
        // Arquero no tiene restauración de vida especial
    }

    public boolean esquivarAtaque() {
        // Determina si esquiva el ataque según su agilidad
        Random rand = new Random();
        return rand.nextInt(100) < this.agilidad;
    }

    public int getPunteria() {
        return punteria;
    }

    public void setPunteria(int punteria) {
        this.punteria = punteria;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }
}
