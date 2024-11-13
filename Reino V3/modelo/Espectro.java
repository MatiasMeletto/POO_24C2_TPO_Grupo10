package modelo;

public class Espectro extends Criatura {

    public Espectro() {
        super(80, 20, 10, 40);  // Valores iniciales de vida, ataque, defensa y recompensa de experiencia
    }

    @Override
    public void recibirDanio(int danio, Personaje p) {
        puntosVida = (puntosVida - (danio - nivelDefensa));
    }

    @Override
    public int hacerDanio(Personaje p) {
        if (!(p instanceof Arquero)) {
            return nivelAtaque;
        }
        else {
            return (int)(nivelAtaque *1.20);
        }
    }
}
