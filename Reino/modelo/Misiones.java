package modelo;

import java.util.ArrayList;
import java.util.List;

public class Misiones {
    private static Misiones instancia;
    private List<Objeto> objetos = new ArrayList<>();;

    private Misiones(Objeto o){
        this.objetos.add(o);
    }

    public static Misiones getInstancia(Objeto o){
        if(instancia == null){
            instancia = new Misiones(o);
        }else if (o != null){
            if(instancia.objetos.size() > 3){
                instancia.objetos.clear();
            }
            instancia.objetos.add(o);

        }
        return instancia;
    }
    public List<Objeto> getObjetos(){
        return objetos;
    }
}
