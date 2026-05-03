package co.edu.udistrital.model.sort;

import co.edu.udistrital.model.structures.*;
import java.util.Comparator;

/**
 * Algoritmo de ordenamiento rapido (Quick Sort) para lista enlazada
 * @author Jimmy86gb
 * @param <T> el tipo de dato que guarda la lista
 */
public class QuickSort<T> implements Sorter<T> {

    private int iterations; // var global para no perder cuenta en recursvidiad

    /**
     * Inicia el proceso de ordenar la lista partiendo por mitades
     * @param list la lista desordenada
     * @param comparator las reglas de comparacion
     * @return la cantidad de iteraciones que le tomo ordenar todo
     */
    @Override
    public int sort(SimpleList<T> list, Comparator<T> comparator) {
        iterations = 0;
        if (list.isEmpty() || list.getSize() <= 1) {
            return iterations;
        }
        quickSortRec(list.getHead(), list.getTail(), comparator);
        return iterations;
    }

    // recursivo
    private void quickSortRec(Node<T> start, Node<T> end, Comparator<T> comparator) {
        if (start != end && start != null && end != null) {
            
            // encontrar el pivote y acomodarlo
            Node<T> pivot = partition(start, end, comparator);

            // ordenar mitad izquierda desde start hasta antes del pivot
            Node<T> temp = start;
            if (temp != pivot) {
                // nodo anterior al pivote
                while (temp.getNext() != pivot) {
                    temp = temp.getNext();
                }
                quickSortRec(start, temp, comparator);
            }

            // ordenar mitad derecha desde despues del pivote hasta el final
            if (pivot != null && pivot.getNext() != null) {
                quickSortRec(pivot.getNext(), end, comparator);
            }
        }
    }

    // metodo que divide la lista y pone los menores a la izquierda
    private Node<T> partition(Node<T> start, Node<T> end, Comparator<T> comparator) {
        T pivotData = end.getData(); // se toma el ultimo nodo como pivote
        Node<T> i = start;
        Node<T> j = start;

        while (j != end) {
            iterations++;
            
            // si el elemento actual es menor que el pivote
            if (comparator.compare(j.getData(), pivotData) < 0) {
                // intercambia i con j
                T temp = i.getData();
                i.setData(j.getData());
                j.setData(temp);
                
                i = i.getNext(); // avanza el limite
            }
            j = j.getNext();
        }
        
        // coloca el pivote en su posicion final correcta
        T temp = i.getData();
        i.setData(end.getData());
        end.setData(temp);

        return i; // devuelve el nodo que ahora es el pivote
    }
}