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
     * Metodo que mantiene el menu principal corriendo hasta que el usuario
     * decida salir
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
                
                // Mostrar lista original generada
                Node<Politician> actual = listP.getHead();
                while(actual != null){
                    Politician p = actual.getData();
                    msg = "\n" + p.getName() + "  " + p.getMoneyToSteal();
                    view.showMsg(msg);
                    actual = actual.getNext();
                }
                
                msg = """
                      --MENU APOCO--
                      Ordenar por:
                      1. Insertion Sort
                      2. Selection Sort
                      3. Bubble Sort
                      4. Cocktail Sort
                      5. Comb Sort
                      6. Shell Sort
                      7. Batcher odd-even mergesort
                      8. Quick Sort
                      9. EJECUTAR TODOS (Comparativa de Iteraciones)
                      Elija un ordenamiento:""";
                String option2 = view.readData(msg);

                // Instanciamos el comparador que todos usaran
                Comparator<Politician> comparator 
                        = new Comparator<Politician>() {
                    @Override
                    public int compare(Politician p1, Politician p2) {
                        return Double.compare(p1.getMoneyToSteal(), 
                                p2.getMoneyToSteal());
                    }
                };

                /**antes de todo para evitar carga y envio de lista con 
                 *comparador segun requieren las otras opciones
                 */
                if (option2.equals("9")) {
                    view.showMsg("\n-- TABLA COMPARATIVA DE ITERACIONES --");
                    view.showMsg("Tamano de la lista: " + size
                            + " elementos\n");
                    
                    /* Metemos todos los algoritmos en un arreglo para
                     * recorrerlos
                     */
                    Sorter<Politician>[] algorithms = new Sorter[]{
                        new InsertionSort<>(), new SelectionSort<>(), 
                        new BubbleSort<>(), new CocktailSort<>(), 
                        new CombSort<>(), new ShellSort<>(),
                        new OddEvenSort<>(), new QuickSort<>()
                    };
                    
                    String[] names = {
                        "Insertion Sort", "Selection Sort", "Bubble Sort",
                        "Cocktail Sort ", "Comb Sort     ", "Shell Sort    ",
                        "Odd-Even Sort ", "Quick Sort    "
                    };

                    for (int i = 0; i < algorithms.length; i++) {
                        // clonar para no usar una ya ordenada
                        SimpleList<Politician> copyListP 
                                = copyList(listP);
                        
                        // ejecutar el algoritmo
                        int iteraciones = algorithms[i].sort(copyListP, 
                                comparator);
                        
                        // imprimir el resultado
                        view.showMsg(names[i] + " -> Iteraciones: " 
                                + iteraciones);
                    }
                    // Salir del metodo para no ejecutar el codigo de abajo
                    return; 
                }

                // flujo normal
                Sorter<Politician> algorithm = null;

                switch(option2){
                    case "1": 
                        algorithm = new InsertionSort<>(); 
                        break;
                    case "2": 
                        algorithm = new SelectionSort<>(); 
                        break;
                    case "3": 
                        algorithm = new BubbleSort<>(); 
                        break;
                    case "4": 
                        algorithm = new CocktailSort<>(); 
                        break;
                    case "5": 
                        algorithm = new CombSort<>(); 
                    break;
                    case "6": 
                        algorithm = new ShellSort<>(); 
                    break;   
                    case "7": 
                        algorithm = new OddEvenSort<>(); 
                    break;
                    case "8": 
                        algorithm = new QuickSort<>(); 
                    break;
                    default:
                        view.showMsg("Opcion no valida.");
                        return; 
                }
                
                // se envia la lista haciendo uso del comparator
                int iterations = algorithm.sort(listP, comparator);

                // mostrar resultados
                view.showMsg("\n--RESULTADOS DEL ORDENAMIENTO--");
                view.showMsg("Iteraciones realizadas: " + iterations);

                Node<Politician> current = listP.getHead();
                while(current != null) {
                    Politician p = current.getData();
                    view.showMsg(p.getName() + " | Dinero: $" + 
                            p.getMoneyToSteal());
                    current = current.getNext();
                }
        }
    }

    /**
     * crea una copia de la lista
     * 
     */
    private SimpleList<Politician> copyList(SimpleList<Politician> original) {
        SimpleList<Politician> copia = new SimpleList<>();
        Node<Politician> actual = original.getHead();
        while (actual != null) {
            copia.add(actual.getData());
            actual = actual.getNext();
        }
        return copia;
    }
}