package modelo;

public class Guerrero extends Personaje {
    private int contadorGolpes;

    public Guerrero(String nombre) {
        super(nombre, 1200 , 1200, 50,35);  // Valores de vida, ataque y defensa iniciales para Guerrero
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
        contadorGolpes++;
        //A partir del tercer golpe, se duplica el ataque
        if (contadorGolpes >= 3){
            return nivelAtaque * 2;
        }

        if (c instanceof Troll){
            return 9999;
        }
        return nivelAtaque;
    }

    @Override
    public void restaurarVida() {
        puntosVida += (int)(maxVida * 0.20);
    }

    public void iniciarNuevoCombate(){
        contadorGolpes = 0;
    }
}
