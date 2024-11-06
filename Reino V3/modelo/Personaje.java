package modelo;

import controlador.*;

public abstract class Personaje {
    protected String nombre;
    protected int puntosVida;
    protected int nivelAtaque;
    protected int nivelDefensa;
    protected int experiencia;

    public Personaje(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.experiencia = 0;  // Inicializamos la experiencia en 0
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    public int getExperiencia() {
        return experiencia;
    }

    //Sistema de combate
    public void recibirDanio(int danio) {
        if (danio >= nivelDefensa) {
            danio -= nivelDefensa;
            puntosVida = Math.max(0, puntosVida - danio);
            nivelDefensa = 0;
        } else {
            nivelDefensa -= danio;
        }
    }
    
    public void ganarExperiencia(int experiencia) {
        this.experiencia += experiencia;
    }

    // Método abstracto para habilidades especiales, implementado en subclases
    public abstract void habilidadEspecial();

    // Método abstracto para restaurar la vida, cada clase puede definir su propio comportamiento
    public abstract void restaurarVida();
}
