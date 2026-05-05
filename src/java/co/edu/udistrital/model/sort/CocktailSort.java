package co.edu.udistrital.model.sort;

import co.edu.udistrital.model.structures.*;
import java.util.Comparator;

/**
 * Algoritmo Cocktail Sort o Burbuja Bidireccional
 *
 * @author Jimmy86gb
 * @param <T> el tipo de dato
 */
public class CocktailSort<T> implements Sorter<T> {

    /**
     * Ordena empujando los mayores al final y luego los menores al principio
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

        boolean swapped;
        int start = 0;
        int end = n - 1;

        do {
            swapped = false;

            // viaje hacia la derecha
            for (int i = start; i < end; i++) {
                Node<T> current = list.getNodeAt(i);
                Node<T> next = current.getNext();
                iterations++;

                if (comparator.compare(current.getData(),
                        next.getData()) > 0) {
                    T temp = current.getData();
                    current.setData(next.getData());
                    next.setData(temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }

            swapped = false;
            end--;

            // viaje hacia la izquierda
            for (int i = end - 1; i >= start; i--) {
                Node<T> current = list.getNodeAt(i);
                Node<T> next = current.getNext();
                iterations++;

                if (comparator.compare(current.getData(), next.getData()) > 0) {
                    T temp = current.getData();
                    current.setData(next.getData());
                    next.setData(temp);
                    swapped = true;
                }
            }
            start++;
        } while (swapped);

        return iterations;
    }
}
