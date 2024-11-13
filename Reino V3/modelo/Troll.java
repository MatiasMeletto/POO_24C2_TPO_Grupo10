package modelo;

public class Troll extends Criatura {

    public Troll() {
        super(100, 15, 30, 50);  // Valores iniciales de vida, ataque, defensa y recompensa de experiencia
    }

    @Override
    public void recibirDanio(int danio, Personaje p) {
        // Incrementa el nivel de defensa en un 15% cuando lucha contra un Mago
        if (p instanceof Mago) {
            puntosVida = (int) (puntosVida - (danio - (nivelDefensa*1.15)));
        }
    }

    @Override
    public int hacerDanio(Personaje p) {
        return nivelAtaque;
    }
}
