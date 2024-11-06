import java.util.List;

public class VencerCriaturas extends MisionSecundaria {
    private List<Criatura> criaturasObjetivo;

    public VencerCriaturas(Ubicacion ubicacion, int recompensa, List<Criatura> criaturasObjetivo) {
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
