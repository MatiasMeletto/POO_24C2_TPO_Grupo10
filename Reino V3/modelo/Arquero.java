package modelo;

import java.util.Random;

public class Arquero extends Personaje {
    private int punteria;
    private int agilidad;

    public Arquero(String nombre) {
        super(nombre, 90, 90, 18,12);  // Valores de vida, ataque y defensa iniciales para Arquero
        this.punteria = 75;  // Probabilidad inicial de acierto en ataque
        this.agilidad = 20;  // Probabilidad inicial de esquivar golpes
    }

    @Override
    public void recibirDanio(int danio, Criatura c) {
        if (Math.random() >  (float)(agilidad/100)) {
            puntosVida -= (danio - nivelDefensa);
        }

    }

    @Override
    public int hacerDanio(Criatura c) {
        if (c instanceof Dragon) {
            return nivelAtaque;
        }
        if (Math.random() < (float)(punteria/100)){
            return nivelAtaque;
        }
        return 0;
    }

    @Override
    public void restaurarVida() {
        // Arquero no tiene restauración de vida especial
    }
}
