package modelo;

public class Mago extends Personaje {

    public Mago(String nombre) {
        super(nombre, 100, 15, 10);  // Valores de vida, ataque y defensa iniciales para Mago
    }

    @Override
    public void habilidadEspecial() {
        // Inmune contra espectros, se define en el contexto de combate
    }

    @Override
    public void restaurarVida() {
        this.puntosVida = 100;  // Cura al 100% al final de cada combate
    }
}
