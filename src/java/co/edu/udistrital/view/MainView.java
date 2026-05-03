package co.edu.udistrital.view;

import java.util.Scanner;

/**
 * Clase que se encarga de mostrar todo en la consola
 * @author Jimmy86gb
 */
public class MainView {
    private Scanner sc;
    
    /**
     * Prepara la herramienta para leer lo que el usuario escriba
     */
    public MainView(){
        sc = new Scanner(System.in);
    }

    /**
     * Muestra un texto y espera a que el usuario conteste
     * @param msg la pregunta o menu a mostrar
     * @return lo que el usuario digito
     */
    public String readData(String msg){
        showMsg(msg);
        String option = sc.nextLine();
        return option;
    }

    /**
     * Sirve para imprimir rapido un mensaje recibido como parametro
     * @param msg lo que queremos que salga en pantalla
     */
    public void showMsg(String msg){
        System.out.println(msg);
    }
}