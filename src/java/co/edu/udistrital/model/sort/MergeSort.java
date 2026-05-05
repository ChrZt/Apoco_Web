package co.edu.udistrital.model.sort;

import co.edu.udistrital.model.structures.*;
import java.util.Comparator;

/**
 * Algoritmo Merge Sort (Ordenamiento por mezcla)
 *
 * @author Jimmy86gb (Adaptado a MergeSort)
 * @param <T> el tipo de dato
 */
public class MergeSort<T> implements Sorter<T> {

    /**
     * Ordena la lista dividiéndola en mitades y mezclándolas de forma ordenada.
     *
     * @param list la lista a ordenar
     * @param comparator la regla de comparacion
     * @return el numero de iteraciones (comparaciones)
     */
    @Override
    public int sort(SimpleList<T> list, Comparator<T> comparator) {
        int n = list.getSize();
        if (n <= 1) {
            return 0;
        }
        return mergeSort(list, 0, n - 1, comparator);
    }

    /**
     * Método recursivo que divide la lista.
     */
    private int mergeSort(SimpleList<T> list, int left, int right, Comparator<T> comparator) {
        int iterations = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Ordenar la primera y segunda mitad, sumando sus iteraciones
            iterations += mergeSort(list, left, mid, comparator);
            iterations += mergeSort(list, mid + 1, right, comparator);

            // Mezclar ambas mitades
            iterations += merge(list, left, mid, right, comparator);
        }
        return iterations;
    }

    /**
     * Mezcla dos sublistas ordenadas de nuevo en la lista principal.
     */
    @SuppressWarnings("unchecked")
    private int merge(SimpleList<T> list, int left, int mid, int right, Comparator<T> comparator) {
        int iterations = 0;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Arreglos temporales para almacenar los datos
        Object[] leftArray = new Object[n1];
        Object[] rightArray = new Object[n2];

        // Extraer datos de la mitad izquierda usando getNext() para eficiencia
        Node<T> currentLeft = list.getNodeAt(left);
        for (int i = 0; i < n1; i++) {
            leftArray[i] = currentLeft.getData();
            currentLeft = currentLeft.getNext();
        }

        // Extraer datos de la mitad derecha
        Node<T> currentRight = list.getNodeAt(mid + 1);
        for (int j = 0; j < n2; j++) {
            rightArray[j] = currentRight.getData();
            currentRight = currentRight.getNext();
        }

        int i = 0, j = 0;
        // Nodo desde el cual empezaremos a sobrescribir los datos ordenados
        Node<T> currentMerge = list.getNodeAt(left);

        // Mezclar los arreglos temporales de vuelta a la lista
        while (i < n1 && j < n2) {
            iterations++; // Contamos cada comparación
            T leftVal = (T) leftArray[i];
            T rightVal = (T) rightArray[j];

            if (comparator.compare(leftVal, rightVal) <= 0) {
                currentMerge.setData(leftVal);
                i++;
            } else {
                currentMerge.setData(rightVal);
                j++;
            }
            currentMerge = currentMerge.getNext();
        }

        // Copiar los elementos restantes del arreglo izquierdo, si los hay
        while (i < n1) {
            currentMerge.setData((T) leftArray[i]);
            i++;
            currentMerge = currentMerge.getNext();
        }

        // Copiar los elementos restantes del arreglo derecho, si los hay
        while (j < n2) {
            currentMerge.setData((T) rightArray[j]);
            j++;
            currentMerge = currentMerge.getNext();
        }

        return iterations;
    }
}
