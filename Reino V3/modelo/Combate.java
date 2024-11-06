package modelo;

public class Combate {
    private Personaje heroe;
    private Criatura criatura;
    private boolean turnoHeroe;

    public Combate(Personaje heroe, Criatura criatura) {
        this.heroe = heroe;
        this.criatura = criatura;
        this.turnoHeroe = true; // El héroe comienza siempre atacando
    }

    public String iniciarCombate() {
        StringBuilder resultado = new StringBuilder();

        while (heroe.getPuntosVida() > 0 && criatura.getPuntosVida() > 0) {
            if (turnoHeroe) {
                resultado.append(ataqueHeroe()).append("\n");
            } else {
                resultado.append(ataqueCriatura()).append("\n");
            }
            turnoHeroe = !turnoHeroe;
        }

        // Determinar el resultado del combate
        if (heroe.getPuntosVida() > 0) {
            resultado.append(heroe.getNombre()).append(" ha vencido a ").append(criatura.getNombre()).append("!\n");
            heroe.ganarExperiencia(criatura.getExperienciaOtorgada());
        } else {
            resultado.append(heroe.getNombre()).append(" ha sido derrotado por ").append(criatura.getNombre()).append(".\n");
        }
        return resultado.toString();
    }

    private String ataqueHeroe() {
        int danio = Math.max(0, heroe.getNivelAtaque() - criatura.getNivelDefensa());
        criatura.recibirDanio(danio);
        return heroe.getNombre() + " ataca a " + criatura.getNombre() + " causando " + danio + " puntos de daño.";
    }

    private String ataqueCriatura() {
        int danio = Math.max(0, criatura.getNivelAtaque() - heroe.getNivelDefensa());
        heroe.recibirDanio(danio);
        return criatura.getNombre() + " ataca a " + heroe.getNombre() + " causando " + danio + " puntos de daño.";
    }
}

