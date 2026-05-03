package co.edu.udistrital.model.sort;

import co.edu.udistrital.model.structures.SimpleList;
import java.util.Comparator;

public interface Sorter<T> {
    
    // Todas las clases que implementen esta interfaz DEBEN tener este método
    int sort(SimpleList<T> list, Comparator<T> comparator);
    
}