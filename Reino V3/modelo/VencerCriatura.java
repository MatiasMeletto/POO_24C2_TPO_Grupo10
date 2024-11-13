package modelo;
import java.util.List;

public class VencerCriatura extends MisionSecundaria {
    private List<Criatura> criaturasObjetivo;

    public VencerCriatura(Ubicacion ubicacion, int recompensa, List<Criatura> criaturasObjetivo) {
        super(ubicacion, recompensa);
        this.criaturasObjetivo = criaturasObjetivo;
    }

    public boolean verificarCompletada() {
        return ubicacion.getCriaturas().containsAll(criaturasObjetivo) && criaturasObjetivo.isEmpty();
    }

    public void criaturaDerrotada(Criatura criatura) {
        criaturasObjetivo.remove(criatura);
    }
}
