package modelo;

public class Troll extends Criatura {

    public Troll() {
        super("Troll", 100, 15, 30, 50);  // Valores iniciales de vida, ataque, defensa y recompensa de experiencia
    }

    @Override
    public void habilidadEspecial(Personaje personaje) {
        // Incrementa el nivel de defensa en un 15% cuando lucha contra un Mago
        if (personaje instanceof Mago) {
            this.nivelDefensa *= 1.15;
        }
    }
}
