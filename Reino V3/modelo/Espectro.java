package modelo;

public class Espectro extends Criatura {

    public Espectro() {
        super("Espectro", 80, 20, 10, 40);  // Valores iniciales de vida, ataque, defensa y recompensa de experiencia
    }

    @Override
    public void habilidadEspecial(Personaje personaje) {
        // Incrementa el nivel de ataque en un 20% cuando lucha contra un Arquero
        if (personaje instanceof Arquero) {
            this.nivelAtaque *= 1.2;
        }
    }
}
