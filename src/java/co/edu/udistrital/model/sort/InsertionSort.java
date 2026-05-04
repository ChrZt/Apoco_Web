package co.edu.udistrital.model.sort;

import co.edu.udistrital.model.structures.*;
import java.util.Comparator;

/**
 * Algoritmo de ordenamiento por insercion
 * @author Jimmy86gb
 * @param <T> el tipo de dato que vamos a ordenar
 */
public class InsertionSort<T> implements Sorter<T> {

    /**
     * Ordena la lista insertando cada elemento en su posicion correcta
     * @param list la lista que queremos ordenar
     * @param comparator las reglas para saber quien es mayor
     * @return el numero de iteraciones realizadas
     */
    @Override
    public int sort(SimpleList<T> list, Comparator<T> comparator) {
        int iterations = 0;
        if (list.isEmpty() || list.getSize() <= 1) {
            return iterations;
        }
        
        Node<T> current = list.getNextNodeToHead();
        while (current != null) {
            Node<T> search = list.getHead();
            
            // Busca desde el inicio hasta el nodo actual
            while (search != current) {
                iterations++;
                if (comparator.compare(search.getData(), 
                        current.getData()) > 0) {
                    // Intercambia los datos para ir empujando el valor
                    T temp = current.getData();
                    current.setData(search.getData());
                    search.setData(temp);
                }
                search = search.getNext();
            }
            current = current.getNext();
        }
        return iterations;
    }
}