package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public abstract class Personaje {
    protected String nombre;
    protected int puntosVida;
    protected int maxVida;
    protected int nivelAtaque;
    protected int nivelDefensa;
    protected int experiencia;
    
    public Personaje(String nombre, int puntosVida, int maxVida, int nivelAtaque, int nivelDefensa) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.maxVida = maxVida;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.experiencia = 0;  // Inicializamos la experiencia en 0
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public List<JLabel> obtenerLabels(){
        List<JLabel> aux = new ArrayList<>();
        JLabel n = new JLabel("Nombre: "+nombre,JLabel.CENTER); // Asumiendo que `nombre` ya es un String
        JLabel v = new JLabel("Vida: "+String.valueOf(puntosVida),JLabel.CENTER);
        JLabel a = new JLabel("Ataque: "+String.valueOf(nivelAtaque),JLabel.CENTER); 
        JLabel d = new JLabel("Defensa: "+String.valueOf(nivelDefensa),JLabel.CENTER); 
        JLabel e = new JLabel("Experiencia: "+String.valueOf(experiencia),JLabel.CENTER); 
        aux.add(n);
        aux.add(v);
        aux.add(a);
        aux.add(d);
        aux.add(e);
        return aux;
    }

    //Sistema de combate
    public abstract int recibirDanio(int danio, Criatura c) ;

    public abstract int hacerDanio(Criatura c) ;
    public boolean sigueVivo() {
        return puntosVida > 0;
    }

    public void ganarExperiencia(int experiencia) {
        this.experiencia += experiencia;
    }
    
    public void subirNivel(){
        if (this.experiencia > 100) { 
            this.experiencia = experiencia - 100;
            String mensaje = "¡Felicidades, " + nombre + "!\n" + "Has subido de nivel!" ;

            JOptionPane.showMessageDialog(
                null,              // Componente padre (null significa sin componente)
                mensaje,           // Mensaje que se mostrará
                "¡Subida de Nivel!", // Título del pop-up
                JOptionPane.INFORMATION_MESSAGE // Tipo de mensaje (información)
            );
        }
    }
    // Método abstracto para restaurar la vida, cada clase puede definir su propio comportamiento
    public abstract void restaurarVida();
}