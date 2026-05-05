package co.edu.udistrital.controller;

import co.edu.udistrital.model.entities.Politician;
import co.edu.udistrital.model.generator.DataGenerator;
import co.edu.udistrital.model.sort.*;
import co.edu.udistrital.model.structures.SimpleList;
import java.io.IOException;
import java.util.Comparator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ApocoServlet", urlPatterns = {"/ApocoServlet"})
public class ApocoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // leer los datos enviados desde el index.jsp
        String sizeParam = request.getParameter("size");
        String algorithmParam = request.getParameter("algorithm");
        
        int size = Integer.parseInt(sizeParam);
        
        // uar el generador para generar la lista
        SimpleList<Politician> listP = DataGenerator.generatePoliticians(size);
        
        // seleccionar el algoritmo 
        Sorter<Politician> algorithm = null;
        if ("bubble".equals(algorithmParam)) {
            algorithm = new BubbleSort<>();
        } else if ("quick".equals(algorithmParam)) {
            algorithm = new QuickSort<>();
        }
        
        // ordenar y obtener iteraciones
        int iterations = algorithm.sort(listP, new Comparator<Politician>() {
            @Override
            public int compare(Politician p1, Politician p2) {
                return Double.compare(p1.getMoneyToSteal(), p2.getMoneyToSteal());
            }
        });
        
        // guardar los resultados en el request para que la vista los pueda leer
        request.setAttribute("listaOrdenada", listP);
        request.setAttribute("iteraciones", iterations);
        request.setAttribute("algoritmoUsado", algorithmParam);
        
        // redirigir a la pagina de resultados
        request.getRequestDispatcher("results.jsp").forward(request, response);
    }
}