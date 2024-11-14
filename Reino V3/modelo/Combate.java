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

        while (heroe.sigueVivo() && criatura.sigueVivo()) {
            if (turnoHeroe) {
                resultado.append(ataqueHeroe()).append("\n");
            } else {
                resultado.append(ataqueCriatura()).append("\n");
            }
            turnoHeroe = !turnoHeroe;
        }

        // Determinar el resultado del combate
        if (heroe.sigueVivo()) {
            resultado.append(heroe.getNombre()).append(" ha vencido a ").append(criatura.getClass().getSimpleName()).append("!\n");
            heroe.ganarExperiencia(criatura.getExperienciaOtorgada());
        } else {
            resultado.append(heroe.getNombre()).append(" ha sido derrotado por ").append(criatura.getClass().getSimpleName()).append(".\n");
        }
        return resultado.toString();
    }

    private String ataqueHeroe() {
        int danio = heroe.hacerDanio(criatura);
        int d = criatura.recibirDanio(danio, heroe);
        return heroe.getNombre() + " ataca a " + criatura.getClass().getSimpleName() + " causando " + d + " puntos de daño.";
    }

    private String ataqueCriatura() {
        int danio = criatura.hacerDanio(heroe);
        int d = heroe.recibirDanio(danio,criatura);
        return criatura.getClass().getSimpleName() + " ataca a " + heroe.getNombre() + " causando " + d + " puntos de daño.";
    }
}

