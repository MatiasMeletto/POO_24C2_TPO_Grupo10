package modelo;

public class Dragon extends Criatura {

    public Dragon() {
        super("Dragon", 150, 25, 20, 100);  // Valores iniciales de vida, ataque, defensa y recompensa de experiencia
    }

    @Override
    public void habilidadEspecial(Personaje personaje) {
        // Incrementa el nivel de ataque en un 30% cuando lucha contra un Guerrero
        if (personaje instanceof Guerrero) {
            this.nivelAtaque *= 1.3;
        }
    }
}
