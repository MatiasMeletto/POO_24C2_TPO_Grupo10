package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public abstract class Personaje {
    protected String nombre;
    protected int puntosVida;
    protected int maxVida;
    protected int nivelAtaque;
    protected int nivelDefensa;
    protected int experiencia;
    protected List<Objeto> objetos;
    
    public Personaje(String nombre, int puntosVida, int maxVida, int nivelAtaque, int nivelDefensa) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.maxVida = maxVida;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.experiencia = 0;  // Inicializamos la experiencia en 0
        this.objetos = new ArrayList<>();
    }

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

    public void ObjetoEncontrado(Objeto o){
        objetos.add(o);
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
    
    public void subirNivel() {
        if (this.experiencia > 100) {
            this.experiencia = experiencia - 100;
    
            // Mensaje principal
            String mensaje = "¡Felicidades, " + nombre + "!\nHas subido de nivel.\n" +
                             "Elige una mejora:";
    
            String[] opciones = {"Vida", "Defensa", "Ataque"};
    
            // Mostrar el cuadro de diálogo con las opciones
            int eleccion = JOptionPane.showOptionDialog(
                null,         
                mensaje,            // Mensaje principal
                "¡Subida de Nivel!", // Título del pop-up
                JOptionPane.DEFAULT_OPTION, // Tipo de opción
                JOptionPane.INFORMATION_MESSAGE, // Tipo de mensaje
                null,               // Ícono personalizado (null para usar el predeterminado)
                opciones,           // Opciones que aparecerán
                opciones[0]         // Opción seleccionada por defecto
            );
    
            // Aplicar la mejora elegida
            switch (eleccion) {
                case 0 -> {
                    // Vida
                    this.puntosVida += 10;
                    this.maxVida += 10; 
                    JOptionPane.showMessageDialog(null, "¡Has mejorado tu vida!");
                }
                case 1 -> {
                    // Defensa
                    this.nivelDefensa += 5; // Ejemplo: Incrementar defensa en 5
                    JOptionPane.showMessageDialog(null, "¡Has mejorado tu defensa!");
                }
                case 2 -> {
                    // Ataque
                    this.nivelAtaque += 5; // Ejemplo: Incrementar ataque en 5
                    JOptionPane.showMessageDialog(null, "¡Has mejorado tu ataque!");
                }
                default -> // Ninguna opción seleccionada
                    JOptionPane.showMessageDialog(null, "No seleccionaste ninguna mejora.");
            }
        }
    }
    // Método abstracto para restaurar la vida, cada clase puede definir su propio comportamiento
    public abstract void restaurarVida();
}
