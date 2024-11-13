package modelo;

public class Guerrero extends Personaje {
    private boolean dobleAtaqueActivado = false;

    public Guerrero(String nombre) {
        super(nombre, 120, 120, 20,15);  // Valores de vida, ataque y defensa iniciales para Guerrero
    }

    @Override
    public void recibirDanio(int danio, Criatura c) {
        puntosVida -= (danio - nivelDefensa);
    }

    @Override
    public int hacerDanio(Criatura c) {
        if (c instanceof Troll){
            return 9999;
        }
        return nivelAtaque;
    }

    @Override
    public void restaurarVida() {
        // Guerrero no tiene restauración de vida especial
    }
}
