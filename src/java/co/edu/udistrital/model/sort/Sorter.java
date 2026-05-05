package co.edu.udistrital.model.sort;

import co.edu.udistrital.model.structures.SimpleList;
import java.util.Comparator;

/**
 * Plantilla principal que todos los metodos de ordenamiento deben seguir
 *
 * @author Jimmy86gb
 * @param <T> el tipo de dato generico
 */
public interface Sorter<T> {

    // Todas las clases que implementen esta interfaz DEBEN tener este metodo
    /**
     * Obliga a los algoritmos a tener un metodo que ordene y cuente
     *
     * @param list la lista que pasamos para ordenar
     * @param comparator la regla para comparar los datos
     * @return el numero de iteraciones
     */
    int sort(SimpleList<T> list, Comparator<T> comparator);

}
