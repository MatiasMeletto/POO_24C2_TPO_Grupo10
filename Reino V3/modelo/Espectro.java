package modelo;

public class Espectro extends Criatura {

    public Espectro() {
        super(60, 10, 3, 40);  // Valores iniciales de vida, ataque, defensa y recompensa de experiencia
    }

    @Override
    public int recibirDanio(int danio, Personaje p) {
        puntosVida = (puntosVida - (danio - nivelDefensa));
        return (int)(danio-nivelDefensa);
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
