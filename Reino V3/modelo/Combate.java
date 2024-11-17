package modelo;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import vista.VistaCombate;
import vista.VistaSeleccionClase;

import java.awt.*;

public class Combate {
    private Personaje heroe;
    private List<Criatura> criaturas;
    private boolean turnoHeroe;
    private boolean victoria;

    public Combate(Personaje heroe, List<Criatura> criaturas, boolean emboscada) {
        this.heroe = heroe;
        this.criaturas = criaturas;
        this.turnoHeroe = emboscada; 
    }

    public String iniciarCombate() {
        StringBuilder resultado = new StringBuilder();
        for (Criatura criatura : criaturas) {
           while (heroe.sigueVivo() && criatura.sigueVivo()) {
                if (turnoHeroe) {
                    resultado.append(ataqueHeroe(criatura)).append("\n");
                } else {
                    resultado.append(ataqueCriatura(criatura)).append("\n");
                }
                turnoHeroe = !turnoHeroe;
            }

            // Determinar el resultado del combate
            if (heroe.sigueVivo()) {
                resultado.append(heroe.getNombre()).append(" ha vencido a ").append(criatura.getClass().getSimpleName()).append("!\n");
                heroe.ganarExperiencia(criatura.getExperienciaOtorgada());
                victoria = true;
            } else {
                resultado.append(heroe.getNombre()).append(" ha sido derrotado por ").append(criatura.getClass().getSimpleName()).append(".\n");
                victoria = false;
                // Mostrar el resumen del combate
            } 
        }
        
        return resultado.toString();
    }

    private String ataqueHeroe(Criatura criatura) {
        int danio = heroe.hacerDanio(criatura);
        int d = criatura.recibirDanio(danio, heroe);
        return heroe.getNombre() + " ataca a " + criatura.getClass().getSimpleName() + " causando " + d + " puntos de daño.";
    }

    private String ataqueCriatura(Criatura criatura) {
        int danio = criatura.hacerDanio(heroe);
        int d = heroe.recibirDanio(danio,criatura);
        return criatura.getClass().getSimpleName() + " ataca a " + heroe.getNombre() + " causando " + d + " puntos de daño.";
    }
    public Boolean getVictoria(){
        return victoria;
    }
}

