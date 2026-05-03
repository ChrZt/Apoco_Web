package co.edu.udistrital.model.sort;

import co.edu.udistrital.model.structures.*;
import java.util.Comparator;

public class BubbleSort<T> implements Sorter<T> {

    @Override
    public int sort(SimpleList<T> list, Comparator<T> comparator) {
        int iterations = 0;
        
        if (list.isEmpty() || list.getSize() <= 1) {
            return iterations;
        }
        
        boolean swapped;
        do {
            swapped = false;
            Node<T> current = list.getHead();
            
            while (current != null && current.getNext() != null) {
                iterations++; // cuenta la iteracion de la comparacion
                
                if (comparator.compare(current.getData(), current.getNextData()) > 0) {
                    // intercambio de datos
                    T temp = current.getData();
                    current.setData(current.getNextData());
                    current.getNext().setData(temp);
                    swapped = true;
                }
                
                // avanza al siguiente par
                current = current.getNext(); 
            }
        } while (swapped);
        
        return iterations;
    }
}