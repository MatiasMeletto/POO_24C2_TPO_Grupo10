package modelo;

public abstract class Criatura {
    protected String nombre;
    protected int puntosVida;
    protected int nivelAtaque;
    protected int nivelDefensa;
    protected int experienciaOtorgada; // Consistentemente usamos esta variable

    public Criatura(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, int experienciaOtorgada) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.experienciaOtorgada = experienciaOtorgada; // Inicializar correctamente
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

    public int getExperienciaOtorgada() {
        return experienciaOtorgada; // Usamos esta variable en todo el código
    }
    
    // Sistema de combate
    public void recibirDanio(int danio) {
        puntosVida = Math.max(0, puntosVida - danio);
    }

    // Método abstracto para habilidades especiales
    public abstract void habilidadEspecial(Personaje personaje);
}
