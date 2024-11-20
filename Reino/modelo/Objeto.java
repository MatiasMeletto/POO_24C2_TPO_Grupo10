package  modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class Objeto {
    private String nombre;
    private String descripcion;
    private Ubicacion ubicacion;
    private Personaje heroe;
    private List<Criatura> criaturas;

    public Objeto(String nombre, String descripcion, Ubicacion ubicacion, List<Criatura> criaturas){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.criaturas = criaturas;
    }
    public List<JLabel> obtenerLabels(){
        List<JLabel> aux = new ArrayList<>();
        JLabel n = new JLabel("Nombre: " + nombre,JLabel.CENTER);
        JLabel v = new JLabel("Se encuentra en: " + String.valueOf(ubicacion.getNombre()),JLabel.CENTER);
        JLabel a = new JLabel("Descrpcion: " + descripcion,JLabel.CENTER); 
        aux.add(n);
        aux.add(v);
        aux.add(a);
        if (!criaturas.isEmpty()){
            JLabel r = new JLabel("Custodiado por: " + String.valueOf(criaturas.size()) + criaturas.get(0).getClass().getName(),JLabel.CENTER);
            aux.add(r);
        }       
        return aux;
    }
}
