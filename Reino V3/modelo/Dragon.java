package modelo;

public class Dragon extends Criatura {

    public Dragon() {
        super(100, 15, 8, 100);  // Valores iniciales de vida, ataque, defensa y recompensa de experiencia
    }

    @Override
    public int recibirDanio(int danio, Personaje p) {
        puntosVida = (puntosVida - (danio - nivelDefensa));
        return (int)(danio-nivelDefensa);
    }

    @Override
    public int hacerDanio(Personaje p) {
        if (!(p instanceof Guerrero)) {
            return nivelAtaque;
        }
        else {
            return (int)(nivelAtaque *1.30);
        }
    }
}
