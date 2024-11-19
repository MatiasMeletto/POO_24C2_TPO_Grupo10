package modelo;

public class Guerrero extends Personaje {

    public Guerrero(String nombre) {
        super(nombre, 12000 , 1200, 50,35);  // Valores de vida, ataque y defensa iniciales para Guerrero
    }

    @Override
    public int recibirDanio(int danio, Criatura c) {
        if(danio != 0 && (danio-nivelDefensa) > 0){
            puntosVida -= (danio - nivelDefensa);
            return (int)(danio-nivelDefensa);
        }
        return 0;
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
        puntosVida += (int)(maxVida * 0.20);
    }
}
