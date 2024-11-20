package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controlador.ControladorJuego;
import vista.VistaCombate;

public class Ubicacion {
    private String nombre;
    private List<Criatura> criaturas;
    private boolean esNeutral;
    private Objeto objeto;
    private List<Ubicacion> caminosPosibles;
    private Runnable eventoEspecial;
    
    public Ubicacion(String nombre, boolean esNeutral, ControladorJuego controlador) {
        this.nombre = nombre;
        this.esNeutral = esNeutral;
        this.caminosPosibles = new ArrayList<>();
        this.criaturas = new ArrayList<>();
        if (!this.esNeutral) {
            double tipoEnemigo = Math.random();
            if (tipoEnemigo >= 0 && tipoEnemigo <= 0.425) {
                Criatura cr = new Troll();
                this.criaturas.add(cr);
                for (int i = 0; i < 2; i++) {
                    if (Math.random() > 0.6){
                        Criatura c = new Troll();
                        this.criaturas.add(c);
                    }
                }
            }else if (tipoEnemigo > 0.425 && tipoEnemigo <= 0.85) {
                Criatura cr = new Espectro();
                this.criaturas.add(cr);
                for (int i = 0; i < 3; i++) {
                    if (Math.random() > 0.35){
                        Criatura c = new Espectro();
                        this.criaturas.add(c);
                    }
                }
            }else if (tipoEnemigo > 0.85 && tipoEnemigo <= 1) {
                Criatura cr = new Dragon();
                this.criaturas.add(cr);
                if (Math.random() > 0.75){
                    Criatura c = new Dragon();
                    this.criaturas.add(c);
                }
            }
        }
        if (nombre.contains("Torre Espectral")){
            for (int i = 0; i < 4; i++) {
                Criatura c = new Dragon();
                this.criaturas.add(c);
            }
            this.esNeutral = false;
        }else if (nombre.contains("Montaña Helada")) {
            
            Criatura dragon = new Dragon();
            this.criaturas.add(dragon);
            this.objeto = new Objeto("Espada de fuego", "Aumenta el nivel de ataque del heroe en 20%", this, criaturas);
            this.esNeutral = false;
            this.eventoEspecial = (() -> {
                JOptionPane.showMessageDialog(null, "¡Has encontrado la Espada de fuego!");
            });
        } else if (nombre.contains("Pantano Oscuro")) {
            for (int i = 0; i < 5; i++) {
                Criatura espectro = new Espectro();
                this.criaturas.add(espectro);
            }
            this.objeto = new Objeto("Arco de luz", "Aumenta el nivel de ataque del heroe en 25%", this, criaturas);
            this.esNeutral = false;
        } else if (nombre.contains("Aldea de los Sirith")) {
            for (int i = 0; i < 3; i++) {
                Criatura troll = new Troll();
                this.criaturas.add(troll);
            }
            this.objeto = new Objeto("Escudo de titanio", "Aumenta la defensa en 30 puntos", this, criaturas);
            this.esNeutral = false;
        } else if (nombre.contains("Bosque de los Susurros")) {
            // Evento especial sin criaturas
            this.objeto = new Objeto("Amuleto de proteccion", "Aumenta el nivel de defensa del heroe en 15%", this, criaturas);
            this.esNeutral = true; // Neutral porque solo hay un evento
        }
        if (this.objeto != null){
            Misiones.getInstancia(objeto);
        }
    }

    public void agregarCamino(Ubicacion ubicacion) {
        caminosPosibles.add(ubicacion);
    }

    public List<Ubicacion> getCaminosPosibles() {
        return caminosPosibles;
    }

    public String getNombre() {
        return nombre;
    }

    public void iniciarEvento(Personaje heroe){ //recordar agregar esto a Vista combate --------------------------------------------------------------------
        if (eventoEspecial != null) {
            eventoEspecial.run(); // Ejecutar el evento especial si está configurado.
            this.objeto.Encontrado(heroe);
        }
    }

    private boolean combateRealizado = false;// Variable para controlar si el combate ya se realizó.

    public void crearCombate(Personaje heroe, ControladorJuego controlador) {
        if (!esNeutral && !combateRealizado && controlador != null) {
            combateRealizado = true;
            VistaCombate.mostrar(controlador, heroe, criaturas,this); 
        } else if (esNeutral) {
            heroe.restaurarVida(); // Restaurar vida en ubicaciones neutrales.
        }
        // Actualizar la vista del mapa después de cualquier acción
        controlador.actualizarMapaVista();
    }   
}
