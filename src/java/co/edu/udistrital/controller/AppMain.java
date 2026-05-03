package co.edu.udistrital.controller;

/**
 * Clase principal para arrancar todo el proyecto
 * @author Jimmy86gb
 */
public class AppMain {

    /**
     * Metodo principal donde inicia la ejecucion del programa
     * @param args los argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        
        MainController control;
        control = new MainController();
        control.run();

    }

}