package modelo;

public class Mago extends Personaje {

    public Mago(String nombre) {
        super(nombre, 500, 500, 70,30);  // Valores de vida, ataque y defensa iniciales para Mago
    }

    @Override
    public int recibirDanio(int danio, Criatura c) {
        if (!(c instanceof Espectro)){
            if(danio != 0 && (danio-nivelDefensa) > 0){
                puntosVida -= (danio - nivelDefensa);
                return (int)(danio-nivelDefensa);
            }
        }
        return 0;
    }

    @Override
    public int hacerDanio(Criatura c) {
        return nivelAtaque;
    }

    @Override
    public void restaurarVida() {
        this.puntosVida = maxVida;  // Cura al 100% al final de cada combate
    }
}
