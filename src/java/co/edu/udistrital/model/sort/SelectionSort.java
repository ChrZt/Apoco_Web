package co.edu.udistrital.model.sort;

import co.edu.udistrital.model.structures.*;
import java.util.Comparator;

/**
 * Algoritmo de ordenamiento por seleccion
 * @author Jimmy86gb
 * @param <T> el tipo de dato
 */
public class SelectionSort<T> implements Sorter<T> {

    /**
     * Ordena buscando el menor y poniendolo al inicio en cada pasada
     * @param list la lista a ordenar
     * @param comparator la regla de comparacion
     * @return el numero de iteraciones
     */
    @Override
    public int sort(SimpleList<T> list, Comparator<T> comparator) {
        int iterations = 0;
        if (list.isEmpty() || list.getSize() <= 1) {
            return iterations;
        }

        for (Node<T> current = list.getHead(); current != null; 
                current = current.getNext()) {
            Node<T> minNode = current;
            
            // Busca el mas pequeno en lo que queda de la lista
            for (Node<T> search = current.getNext(); search != null; 
                    search = search.getNext()) {
                iterations++;
                if (comparator.compare(search.getData(), 
                        minNode.getData()) < 0) {
                    minNode = search;
                }
            }
            
            // Si encontro uno menor, intercambia los datos
            if (minNode != current) {
                T temp = current.getData();
                current.setData(minNode.getData());
                minNode.setData(temp);
            }
        }
        return iterations;
    }
}