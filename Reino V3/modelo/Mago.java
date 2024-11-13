package modelo;

public class Mago extends Personaje {

    public Mago(String nombre) {
        super(nombre, 100, 15, 10,3);  // Valores de vida, ataque y defensa iniciales para Mago
    }

    @Override
    public void recibirDanio(int danio, Criatura c) {
        if (!(c instanceof Espectro)){
            puntosVida -= (danio - nivelDefensa);
        }
    }

    @Override
    public int hacerDanio(Criatura c) {
        return nivelAtaque;
    }

    @Override
    public void restaurarVida() {
        this.puntosVida = 100;  // Cura al 100% al final de cada combate
    }
}
