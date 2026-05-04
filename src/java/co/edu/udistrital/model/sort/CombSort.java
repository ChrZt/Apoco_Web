package co.edu.udistrital.model.sort;

import co.edu.udistrital.model.structures.*;
import java.util.Comparator;

/**
 * Algoritmo Comb Sort o de Peine
 * @author Jimmy86gb
 * @param <T> el tipo de dato
 */
public class CombSort<T> implements Sorter<T> {

    /**
     * Ordena dando saltos largos que se van haciendo pequenos
     * @param list la lista a ordenar
     * @param comparator la regla de comparacion
     * @return el numero de iteraciones
     */
    @Override
    public int sort(SimpleList<T> list, Comparator<T> comparator) {
        int iterations = 0;
        int n = list.getSize();
        if (n <= 1){
            return iterations;
        }
        
        int gap = n;
        boolean swapped = true;
        
        while (gap != 1 || swapped) {
            // Factor de reduccion del peine es 1.3
            gap = (int) (gap / 1.3);
            if (gap < 1) gap = 1;
            
            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                Node<T> n1 = list.getNodeAt(i);
                Node<T> n2 = list.getNodeAt(i + gap);
                iterations++;
                
                if (comparator.compare(n1.getData(), n2.getData()) > 0) {
                    T temp = n1.getData();
                    n1.setData(n2.getData());
                    n2.setData(temp);
                    swapped = true;
                }
            }
        }
        return iterations;
    }
}