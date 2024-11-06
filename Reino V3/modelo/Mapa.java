package modelo;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private Ubicacion ubicacionActual;
    private List<Ubicacion> ubicaciones;

    public Mapa() {
        ubicaciones = new ArrayList<>();
        configurarMapa();
        ubicacionActual = ubicaciones.get(0); // Asegurar que la primera ubicación es la actual
    }

    private void configurarMapa() {
        // Crear ubicaciones principales y bifurcaciones
        Ubicacion entradaReino = new Ubicacion("Entrada del Reino", true);
        Ubicacion caminoBosque = new Ubicacion("Camino del Bosque", false);
        Ubicacion bosqueEncantado = new Ubicacion("Bosque Encantado", false);
        Ubicacion colinaViento = new Ubicacion("Colina del Viento", false);
        Ubicacion lagoCristal = new Ubicacion("Lago de Cristal", false);
        Ubicacion cavernaOscura = new Ubicacion("Caverna Oscura", true);
        Ubicacion puenteAntiguo = new Ubicacion("Puente Antiguo", false);
        Ubicacion llanuraRocosa = new Ubicacion("Llanura Rocosa", false);
        Ubicacion montanaHelada = new Ubicacion("Montaña Helada", false);
        Ubicacion pantanoNiebla = new Ubicacion("Pantano de la Niebla", false);
        Ubicacion puebloAbandonado = new Ubicacion("Pueblo Abandonado", false);
        Ubicacion torreVigilancia = new Ubicacion("Torre de Vigilancia", true);
        Ubicacion bosqueSombrio = new Ubicacion("Bosque Sombrío", false);
        Ubicacion ruinasAntiguas = new Ubicacion("Ruinas Antiguas", false);
        Ubicacion campoBatalla = new Ubicacion("Campo de Batalla", false);
        Ubicacion valleEcos = new Ubicacion("Valle de los Ecos", false);
        Ubicacion altarOscuro = new Ubicacion("Altar Oscuro", false);
        Ubicacion fosoProfundo = new Ubicacion("Foso Profundo", false);
        Ubicacion cuevaTesoros = new Ubicacion("Cueva de los Tesoros", false);
        Ubicacion tronoRey = new Ubicacion("Trono del Rey Olvidado", true);
        Ubicacion bosqueProfundo = new Ubicacion("Bosque Profundo", false);
        Ubicacion altarSagrado = new Ubicacion("Altar Sagrado", false);
        Ubicacion colinaBrumosa = new Ubicacion("Colina Brumosa", false);
        Ubicacion desiertoSombrio = new Ubicacion("Desierto Sombrío", false);
        Ubicacion cascadaSilenciosa = new Ubicacion("Cascada Silenciosa", false);
        Ubicacion torreEspectral = new Ubicacion("Torre Espectral", true);      

        // Asignar criaturas a algunas ubicaciones enemigas
        bosqueEncantado.setCriatura(new Espectro());
        cavernaOscura.setCriatura(new Troll());
        montanaHelada.setCriatura(new Dragon());
        pantanoNiebla.setCriatura(new Espectro());
        torreVigilancia.setCriatura(new Troll());
        altarOscuro.setCriatura(new Espectro());
        cuevaTesoros.setCriatura(new Dragon());  // Lugar final del tesoro

        // Configurar caminos y bifurcaciones correctamente
        entradaReino.agregarCamino(caminoBosque);       //Lineal
        caminoBosque.agregarCamino(bosqueEncantado);    //Lineal
        
        bosqueEncantado.agregarCamino(colinaViento);  // Bifurcación izquierda
        bosqueEncantado.agregarCamino(lagoCristal);   // Bifurcación derecha

        colinaViento.agregarCamino(cavernaOscura);      //Union
        lagoCristal.agregarCamino(cavernaOscura);       //Union
        
        cavernaOscura.agregarCamino(puenteAntiguo);   // Bifurcación izquierda
        cavernaOscura.agregarCamino(llanuraRocosa);   // Bifurcación derecha
        
        puenteAntiguo.agregarCamino(montanaHelada);     //Union
        llanuraRocosa.agregarCamino(montanaHelada);     //Union  

        montanaHelada.agregarCamino(pantanoNiebla);     //Lineal

        pantanoNiebla.agregarCamino(puebloAbandonado);  //Lineal

        puebloAbandonado.agregarCamino(torreVigilancia);    //Lineal

        torreVigilancia.agregarCamino(bosqueSombrio);  // Bifurcación izquierda
        torreVigilancia.agregarCamino(ruinasAntiguas); // Bifurcación derecha

        bosqueSombrio.agregarCamino(campoBatalla);      //Union
        ruinasAntiguas.agregarCamino(campoBatalla);     //Union

        campoBatalla.agregarCamino(valleEcos);  // Bifuracion Izquierda
        campoBatalla.agregarCamino(altarOscuro);  // Bifurcacion Derecha

        valleEcos.agregarCamino(fosoProfundo);  // Lineal
        altarOscuro.agregarCamino(cuevaTesoros); // Lineal

        fosoProfundo.agregarCamino(tronoRey); //Union
        cuevaTesoros.agregarCamino(tronoRey); //Union

        tronoRey.agregarCamino(bosqueProfundo); //Lineal

        bosqueProfundo.agregarCamino(altarSagrado); //Lineal

        altarSagrado.agregarCamino(colinaBrumosa); //Bifurcacion izquierda
        altarSagrado.agregarCamino(desiertoSombrio); //Bifurcacion derecha

        colinaBrumosa.agregarCamino(cascadaSilenciosa); //Union
        desiertoSombrio.agregarCamino(cascadaSilenciosa); //Union

        cascadaSilenciosa.agregarCamino(torreEspectral); //Final

        // Agregar todas las ubicaciones a la lista
        ubicaciones.add(entradaReino);
        ubicaciones.add(caminoBosque);
        ubicaciones.add(bosqueEncantado);
        ubicaciones.add(colinaViento);
        ubicaciones.add(lagoCristal);
        ubicaciones.add(cavernaOscura);
        ubicaciones.add(puenteAntiguo);
        ubicaciones.add(llanuraRocosa);
        ubicaciones.add(montanaHelada);
        ubicaciones.add(pantanoNiebla);
        ubicaciones.add(puebloAbandonado);
        ubicaciones.add(torreVigilancia);
        ubicaciones.add(bosqueSombrio);
        ubicaciones.add(ruinasAntiguas);
        ubicaciones.add(campoBatalla);
        ubicaciones.add(valleEcos);
        ubicaciones.add(altarOscuro);
        ubicaciones.add(fosoProfundo);
        ubicaciones.add(cuevaTesoros);
        ubicaciones.add(tronoRey);
        ubicaciones.add(bosqueProfundo);
        ubicaciones.add(altarSagrado);
        ubicaciones.add(colinaBrumosa);
        ubicaciones.add(desiertoSombrio);
        ubicaciones.add(cascadaSilenciosa);
        ubicaciones.add(torreEspectral);

        // Establecer la primera ubicación como la actual
        ubicacionActual = entradaReino;
    }

    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public List<Ubicacion> getCaminosDisponibles() {
        return ubicacionActual.getCaminosPosibles();
    }

    public void avanzar(Ubicacion nuevaUbicacion) {
        ubicacionActual = nuevaUbicacion;
    }

    public Ubicacion getUbicacionActual() {
        return ubicacionActual;
    }
}
