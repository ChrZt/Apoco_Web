package co.edu.udistrital.model.sort;

import co.edu.udistrital.model.structures.*;
import java.util.Comparator;

/**
 * Algoritmo Odd-Even Sort o Burbuja Par-Impar
 *
 * @author Jimmy86gb
 * @param <T> el tipo de dato
 */
public class OddEvenSort<T> implements Sorter<T> {

    /**
     * Ordena verificando parejas en posiciones pares y luego en impares
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

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;

            // Pasada Impar (compara posiciones 1 con 2, 3 con 4, etc.)
            for (int i = 1; i <= n - 2; i += 2) {
                Node<T> n1 = list.getNodeAt(i);
                Node<T> n2 = n1.getNext();
                iterations++;

                if (comparator.compare(n1.getData(), n2.getData()) > 0) {
                    T temp = n1.getData();
                    n1.setData(n2.getData());
                    n2.setData(temp);
                    isSorted = false;
                }
            }

            // Pasada Par (compara posiciones 0 con 1, 2 con 3, etc.)
            for (int i = 0; i <= n - 2; i += 2) {
                Node<T> n1 = list.getNodeAt(i);
                Node<T> n2 = n1.getNext();
                iterations++;

                if (comparator.compare(n1.getData(), n2.getData()) > 0) {
                    T temp = n1.getData();
                    n1.setData(n2.getData());
                    n2.setData(temp);
                    isSorted = false;
                }
            }
        }
        return iterations;
    }
}
