package modelo;

public abstract class MisionSecundaria {
    protected Ubicacion ubicacion;
    protected int recompensa;

    public MisionSecundaria(Ubicacion ubicacion, int recompensa) {
        this.ubicacion = ubicacion;
        this.recompensa = recompensa;
    }

    public abstract boolean verificarCompletada();
    
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public int getRecompensa() {
        return recompensa;
    }
}