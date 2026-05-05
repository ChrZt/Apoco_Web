package co.edu.udistrital.controller;

import co.edu.udistrital.model.entities.Politician;
import co.edu.udistrital.model.generator.DataGenerator;
import co.edu.udistrital.model.sort.*;
import co.edu.udistrital.model.structures.SimpleList;
import co.edu.udistrital.model.structures.Node;
import java.io.IOException;
import java.util.Comparator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet principal que funciona como el controlador de la pagina web. Recibe
 * las peticiones del formulario, ejecuta los ordenamientos y devuelve los
 * datos.
 *
 * @author Jimmy86gb
 */
@WebServlet(name = "ApocoServlet", urlPatterns = {"/ApocoServlet"})
public class ApocoServlet extends HttpServlet {

    /**
     * Metodo que procesa la peticion POST enviada desde el formulario
     * index.jsp. Se encarga de leer la configuracion, ejecutar uno o todos los
     * algoritmos y preparar la informacion que se va a pintar en la tabla de
     * resultados.
     *
     * @param request la peticion HTTP que contiene lo que el usuario digito
     * @param response la respuesta HTTP que mandaremos de vuelta al navegador
     * @throws ServletException si ocurre un error interno manejando el servlet
     * @throws IOException si hay un error de entrada o salida de datos
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Leer lo que digito el usuario 
        String sizeParam = request.getParameter("size");
        String algorithmParam = request.getParameter("algorithm");

        int size = 50;
        if (sizeParam != null && !sizeParam.isEmpty()) {
            size = Integer.parseInt(sizeParam);
        }

        // generar la lista aleatoria original
        SimpleList<Politician> listP = DataGenerator.generatePoliticians(size);

        // Arreglo para guardar las iteraciones de los algoritmos
        int[] iterations = new int[8];
        SimpleList<Politician> finalSortedList = null;

        Comparator<Politician> comparator = new Comparator<Politician>() {
            @Override
            public int compare(Politician p1, Politician p2) {
                return Double.compare(p1.getMoneyToSteal(),
                        p2.getMoneyToSteal());
            }
        };

        // arreglo con todos los algoritmos instanciados
        Sorter<Politician>[] algorithms = new Sorter[]{
            new InsertionSort<>(), new SelectionSort<>(), new BubbleSort<>(),
            new CocktailSort<>(), new CombSort<>(), new ShellSort<>(),
            new OddEvenSort<>(), new QuickSort<>()
        };

        // logica de ejecucion
        if ("all".equals(algorithmParam)) {
            // Si eligio todos, recorre los 8
            for (int i = 0; i < algorithms.length; i++) {
                SimpleList<Politician> copy = copyList(listP);
                iterations[i] = algorithms[i].sort(copy, comparator);
                finalSortedList = copy;
            }
        } else {
            // Si eligio solo uno, convierte el texto a numero entero
            int index = Integer.parseInt(algorithmParam);
            SimpleList<Politician> copy = copyList(listP);

            // ejecuta solo el algoritmo de esa posicion
            iterations[index] = algorithms[index].sort(copy, comparator);
            finalSortedList = copy;
        }

        // envia los datos de vuelta a la vista
        request.setAttribute("iteraciones", iterations);
        request.setAttribute("listaOrdenada", finalSortedList);
        request.setAttribute("currentSize", size);
        request.setAttribute("currentAlgo", algorithmParam);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    /**
     * Metodo de apoyo para clonar la lista original nodo por nodo. Esto es
     * necesario para que cada algoritmo reciba el mismo nivel de desorden, o
     * sea mismo arreglo y las comparativas de iteraciones sean justas.
     *
     * @param original la lista desordenada que acaba de salir del generador
     * @return una nueva lista independiente pero con los mismos datos en el
     * mismo orden
     */
    private SimpleList<Politician> copyList(SimpleList<Politician> original) {
        SimpleList<Politician> copy = new SimpleList<>();
        Node<Politician> actual = original.getHead();
        while (actual != null) {
            copy.add(actual.getData());
            actual = actual.getNext();
        }
        return copy;
    }
}
