package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JOptionPane;

import controlador.ControladorJuego;
import vista.VistaCombate;


public class Mapa {
    private Ubicacion ubicacionActual;
    private Ubicacion ubicacionFinal;
    private List<Ubicacion> ubicaciones;
    private Personaje heroe;
    private ControladorJuego controlador;

    public Mapa(Personaje heroe, ControladorJuego controlador) {
        this.heroe = heroe;
        this.controlador = controlador;  // Se guarda referencia al controlador
        ubicaciones = new ArrayList<>();
        configurarMapa();                // Configura las ubicaciones del mapa
        ubicacionActual = ubicaciones.get(0); // Establece la primera ubicación como inicial
    }
    

    private void configurarMapa() {
        // Crear ubicaciones principales y bifurcaciones
        Ubicacion entradaReino = new Ubicacion("Entrada del Reino", true, controlador);
        Ubicacion caminoBosque = new Ubicacion("Camino del Bosque", false, controlador);
        Ubicacion bosqueEncantado = new Ubicacion("Bosque Encantado", false, controlador);
        Ubicacion colinaViento = new Ubicacion("Colina del Viento", false, controlador);
        Ubicacion lagoCristal = new Ubicacion("Lago de Cristal", false, controlador);
        Ubicacion cavernaOscura = new Ubicacion("Caverna Oscura (Hoguera)", true, controlador);
        Ubicacion puenteAntiguo = new Ubicacion("Puente Antiguo", false, controlador);
        Ubicacion llanuraRocosa = new Ubicacion("Llanura Rocosa", false, controlador);
        Ubicacion montanaHelada = new Ubicacion("Montaña Helada", true, controlador);
        Ubicacion pantanoNiebla = new Ubicacion("Pantano de la Niebla", false, controlador);
        Ubicacion puebloAbandonado = new Ubicacion("Pueblo Abandonado", false, controlador);
        Ubicacion torreVigilancia = new Ubicacion("Torre de Vigilancia (Hoguera)", true, controlador);
        Ubicacion bosqueSusurros = new Ubicacion("Bosque de los Susurros", true, controlador);
        Ubicacion ruinasAntiguas = new Ubicacion("Ruinas Antiguas", false, controlador);
        Ubicacion campoBatalla = new Ubicacion("Campo de Batalla", false, controlador);
        Ubicacion valleEcos = new Ubicacion("Valle de los Ecos", false, controlador);
        Ubicacion altarOscuro = new Ubicacion("Altar Oscuro", false, controlador);
        Ubicacion fosoProfundo = new Ubicacion("Foso Profundo", false, controlador);
        Ubicacion pantanoOscuro = new Ubicacion("Pantano Oscuro", true, controlador);
        Ubicacion tronoRey = new Ubicacion("Trono del Rey Olvidado (Hoguera)", true, controlador);
        Ubicacion bosqueProfundo = new Ubicacion("Bosque Profundo", false, controlador);
        Ubicacion aldeaSirith = new Ubicacion("Aldea de los Sirith", true, controlador);
        Ubicacion colinaBrumosa = new Ubicacion("Colina Brumosa", false, controlador);
        Ubicacion desiertoSombrio = new Ubicacion("Desierto Sombrío", false, controlador);
        Ubicacion cascadaSilenciosa = new Ubicacion("Cascada Silenciosa", false, controlador);
        Ubicacion torreEspectral = new Ubicacion("Torre Espectral", true, controlador);

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

        torreVigilancia.agregarCamino(bosqueSusurros);  // Bifurcación izquierda
        torreVigilancia.agregarCamino(ruinasAntiguas); // Bifurcación derecha

        bosqueSusurros.agregarCamino(campoBatalla);      //Union
        ruinasAntiguas.agregarCamino(campoBatalla);     //Union

        campoBatalla.agregarCamino(valleEcos);  // Bifuracion Izquierda
        campoBatalla.agregarCamino(altarOscuro);  // Bifurcacion Derecha

        valleEcos.agregarCamino(fosoProfundo);  // Lineal
        altarOscuro.agregarCamino(pantanoOscuro); // Lineal

        fosoProfundo.agregarCamino(tronoRey); //Union
        pantanoOscuro.agregarCamino(tronoRey); //Union

        tronoRey.agregarCamino(bosqueProfundo); //Lineal

        bosqueProfundo.agregarCamino(aldeaSirith); //Lineal

        aldeaSirith.agregarCamino(colinaBrumosa); //Bifurcacion izquierda
        aldeaSirith.agregarCamino(desiertoSombrio); //Bifurcacion derecha

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
        ubicaciones.add(bosqueSusurros);
        ubicaciones.add(ruinasAntiguas);
        ubicaciones.add(campoBatalla);
        ubicaciones.add(valleEcos);
        ubicaciones.add(altarOscuro);
        ubicaciones.add(fosoProfundo);
        ubicaciones.add(pantanoOscuro);
        ubicaciones.add(tronoRey);
        ubicaciones.add(bosqueProfundo);
        ubicaciones.add(aldeaSirith);
        ubicaciones.add(colinaBrumosa);
        ubicaciones.add(desiertoSombrio);
        ubicaciones.add(cascadaSilenciosa);
        ubicaciones.add(torreEspectral);
        
        // Cambiar la lógica de estas ubicaciones para que actúen como "eventos especiales":
        montanaHelada.setEventoEspecial(() -> {
            Criatura dragon = new Dragon();
            VistaCombate.mostrar(controlador, heroe, List.of(dragon));
        });

        bosqueSusurros.setEventoEspecial(() -> {
            JOptionPane.showMessageDialog(null, "¡Has encontrado el Amuleto Perdido!");
        });

        pantanoOscuro.setEventoEspecial(() -> {
            List<Criatura> espectros = IntStream.range(0, 5)
                .mapToObj(i -> new Espectro())
                .collect(Collectors.toList());
            VistaCombate.mostrar(controlador, heroe, espectros);
        });

        aldeaSirith.setEventoEspecial(() -> {
            List<Criatura> trolls = IntStream.range(0, 3)
                .mapToObj(i -> new Troll())
                .collect(Collectors.toList());
            VistaCombate.mostrar(controlador, heroe, trolls);
        });

        // Establecer la primera ubicación como la actual
        ubicacionActual = entradaReino;
        ubicacionFinal = torreEspectral;
    }
    
    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public List<Ubicacion> getCaminosDisponibles() {
        return ubicacionActual.getCaminosPosibles();
    }

    public void avanzar(Ubicacion nuevaUbicacion, ControladorJuego controlador) {          
        ubicacionActual = nuevaUbicacion;
        nuevaUbicacion.crearCombate(heroe, controlador);
    }    

    public Ubicacion getUbicacionActual() {
        return ubicacionActual;
    }
}
