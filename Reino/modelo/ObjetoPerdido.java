package modelo;

public class ObjetoPerdido extends  MisionSecundaria{
    private String nombreObjeto;

    public ObjetoPerdido(Ubicacion ubicacion, int recompensa, String nombreObjeto) {
        super(ubicacion, recompensa);
        this.nombreObjeto = nombreObjeto;
    }

    public boolean verificarCompletada() {
        // Implementa la lógica para verificar si el objeto ha sido recuperado
        return true; // Cambia esto según la lógica de juego
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }
}
