package modelo;

public class Guerrero extends Personaje {
    private boolean dobleAtaqueActivado = false;

    public Guerrero(String nombre) {
        super(nombre, 120, 20, 15);  // Valores de vida, ataque y defensa iniciales para Guerrero
    }

    @Override
    public void habilidadEspecial() {
        // Duplica el nivel de ataque después del tercer golpe en un combate
        this.dobleAtaqueActivado = true;
        this.nivelAtaque *= 2;
    }

    @Override
    public void restaurarVida() {
        // Guerrero no tiene restauración de vida especial
    }
}
