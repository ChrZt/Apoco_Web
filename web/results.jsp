<%@page import="co.edu.udistrital.model.entities.Politician"%>
<%@page import="co.edu.udistrital.model.structures.Node"%>
<%@page import="co.edu.udistrital.model.structures.SimpleList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Resultados APOCO</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Resultados del Análisis APOCO</h2>
    
    <%
        // Recuperar los datos del servlet
        SimpleList<Politician> lista = (SimpleList<Politician>) request.getAttribute("listaOrdenada");
        int iteraciones = (Integer) request.getAttribute("iteraciones");
        String algoritmo = (String) request.getAttribute("algoritmoUsado");
    %>
    
    <div class="stats">
        <p><strong>Algoritmo aplicado:</strong> <%= algoritmo.toUpperCase() %></p>
        <p><strong>Iteraciones realizadas:</strong> <%= iteraciones %></p>
        <p><strong>Total de registros:</strong> <%= lista.getSize() %></p>
    </div>

    <table>
        <thead>
            <tr>
                <th>Nombre del Político</th>
                <th>Dinero a Robar (USD)</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Recorrer lista enlazada usando nodos directamente en la vista
                Node<Politician> actual = lista.getHead();
                while(actual != null) {
                    Politician p = actual.getData();
            %>
            <tr>
                <td><%= p.getName() %></td>
                <td>$ <%= String.format("%.2f", p.getMoneyToSteal()) %></td>
            </tr>
            <%
                    actual = actual.getNext();
                }
            %>
        </tbody>
    </table>
    
    <a href="index.jsp" class="back-btn">Volver al Menú</a>
</body>
</html>