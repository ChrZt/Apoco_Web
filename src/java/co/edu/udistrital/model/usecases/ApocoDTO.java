package co.edu.udistrital.model.usecases;

import co.edu.udistrital.model.entities.Politician;
import co.edu.udistrital.model.structures.SimpleList;

/**
 * Objeto encargado de servir de comuncionacion entre la logica y el controlador
 *
 * @author Juan David Diaz Perez
 */
public class ApocoDTO {

    private final int[] iterations;
    private final SimpleList<Politician> orderedList;
    private final int usedSize;

    /**
     *
     * @param iteraciones Numero de iterations de cada algoritmo usado
     * @param listaOrdenada Lista ya ordenada para mostrar en la vista
     * @param sizeUtilizado Numero de politicos usados en el ejemplo actual
     */
    public ApocoDTO(int[] iteraciones, SimpleList<Politician> listaOrdenada, int sizeUtilizado) {
        this.iterations = iteraciones;
        this.orderedList = listaOrdenada;
        this.usedSize = sizeUtilizado;
    }

    /**
     *
     * @return
     */
    public int[] getIterations() {
        return iterations;
    }

    /**
     *
     * @return
     */
    public SimpleList<Politician> getOrderedList() {
        return orderedList;
    }

    /**
     *
     * @return
     */
    public int getUsedSize() {
        return usedSize;
    }
}
