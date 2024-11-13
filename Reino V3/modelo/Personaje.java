package modelo;

import controlador.*;

public abstract class Personaje {
    protected String nombre;
    protected int puntosVida;
    protected int maxVida;
    protected int nivelAtaque;
    protected int nivelDefensa;
    protected int experiencia;

    public Personaje(String nombre, int puntosVida, int maxVida, int nivelAtaque, int nivelDefensa) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.maxVida = maxVida;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.experiencia = 0;  // Inicializamos la experiencia en 0
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    //Sistema de combate
    public abstract void recibirDanio(int danio, Criatura c) ;

    public abstract int hacerDanio(Criatura c) ;
    public boolean sigueVivo() {
        return puntosVida > 0;
    }

    public void ganarExperiencia(int experiencia) {
        this.experiencia += experiencia;
        if (this.experiencia > 100) { //ejemplo con 100 recordar ajustar el juego
            this.experiencia = experiencia - 100;
        }
    }

    // Método abstracto para restaurar la vida, cada clase puede definir su propio comportamiento
    public abstract void restaurarVida();
}
