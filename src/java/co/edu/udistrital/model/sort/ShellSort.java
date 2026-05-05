package co.edu.udistrital.model.sort;

import co.edu.udistrital.model.structures.*;
import java.util.Comparator;

/**
 * Algoritmo Shell Sort
 *
 * @author Jimmy86gb
 * @param <T> el tipo de dato
 */
public class ShellSort<T> implements Sorter<T> {

    /**
     * Ordena usando sublistas separadas por una distancia que disminuye
     *
     * @param list la lista a ordenar
     * @param comparator la regla de comparacion
     * @return el numero de iteraciones
     */
    @Override
    public int sort(SimpleList<T> list, Comparator<T> comparator) {
        int iterations = 0;
        int n = list.getSize();
        if (n <= 1) {
            return iterations;
        }

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                // Se pide el nodo directamente a la lista
                T temp = list.getNodeAt(i).getData();
                int j;

                for (j = i; j >= gap; j -= gap) {
                    // Se pide el nodo previo directamente a la lista
                    Node<T> prev = list.getNodeAt(j - gap);
                    iterations++;

                    if (comparator.compare(prev.getData(), temp) > 0) {
                        // Actualiza el dato pidiendole el nodo a la lista
                        list.getNodeAt(j).setData(prev.getData());
                    } else {
                        break;
                    }
                }
                // Coloca el dato temporal en su posicion final
                list.getNodeAt(j).setData(temp);
            }
        }
        return iterations;
    }
}
