package main;

import controlador.ControladorJuego;
import vista.IngresoNombre;
//Main
public class Main {
    public static void main(String[] args) {
        // Inicializar el controlador del juego
        ControladorJuego controlador = new ControladorJuego();

        // Mostrar la pantalla de ingreso de nombre
        javax.swing.SwingUtilities.invokeLater(() -> {
            IngresoNombre ingresoNombre = new IngresoNombre(controlador);
            ingresoNombre.setVisible(true);
        });
    }
}
