package co.edu.udistrital.controller;

import co.edu.udistrital.view.MainView;
import co.edu.udistrital.model.generator.DataGenerator;
import co.edu.udistrital.model.structures.*;
import co.edu.udistrital.model.entities.*;
import co.edu.udistrital.model.sort.*;
import java.util.Comparator;
        
/**
 * Controlador principal que maneja la logica y une la vista con el modelo
 * @author Jimmy86gb
 */
public class MainController {
    private MainView view;
    private DataGenerator generator;

    /**
     * Constructor del controlador, prepara la vista y el generador de datos
     */
    public MainController(){
        view = new MainView();
        generator= new DataGenerator();
    }
    
    /**
     * Metodo que mantiene el menu principal corriendo hasta que el usuario decida salir
     */
    public void run(){
        System.out.println("hola");
        String option = "0";
        String msg = "";
        do{
            msg ="""
                 --MENU--
                 1.Problema Apoco
                 2.Problema Hampones
                 Elija una opcion:""";
            option = view.readData(msg);
            switch(option){
                case "1":
                    menuApoco();
                    
            }
        }while(!option.equals("6"));
    }
    
    private void menuApoco(){
        String msg;
        msg ="""
             --MENU APOCO--
             1.Elegir Numero de Corrupos y Generar Aleatoriamente
             2. Volver
             Elija una opcion:""";
        String option1 = view.readData(msg);
        switch(option1){
            case "1":
                SimpleList<Politician> listP = new SimpleList<>();
                msg ="""
                     --MENU APOCO--
                     Elija un tamano de corruptos:""";
                int size = Integer.parseInt(view.readData(msg));
                listP = generator.generatePoliticians(size);
                Node<Politician> actual = listP.getHead();
                while(actual != null){
                    Politician p = actual.getData();
                    msg = "\n" + p.getName() + "  " + p.getMoneyToSteal();
                    view.showMsg(msg);
                    actual = actual.getNext();
                }
                msg = """
                      --MENU APOCO--
                      1. Ordenar con Bubble Sort
                      2. Ordenar con Quick Sort
                      Elija un ordenamiento:""";
                String option2 = view.readData(msg);

                // se usa la interfaz sorter
                Sorter<Politician> algorithm = null;

                switch(option2){
                    case "1":
                        algorithm = new BubbleSort<>();
                        break;
                    case "2":
                        algorithm = new QuickSort<>();
                        break;
                    default:
                        view.showMsg("Opcion no valida.");
                        return; 
                }
                // se envia la lista haciendo uso del comparator
                int iterations = algorithm.sort(listP, new Comparator<Politician>() {
                    @Override
                    public int compare(Politician p1, Politician p2) {
                        // orden de menor a mayor dinero a robar
                        return Double.compare(p1.getMoneyToSteal(), p2.getMoneyToSteal());
                    }
                });

                // mostrar resultados
                view.showMsg("\n--RESULTADOS DEL ORDENAMIENTO--");
                view.showMsg("Iteraciones realizadas: " + iterations);

                Node<Politician> current = listP.getHead();
                while(current != null) {
                    Politician p = current.getData();
                    view.showMsg(p.getName() + " | Dinero: $" + p.getMoneyToSteal());
                    current = current.getNext();
                }

        }
    }
}