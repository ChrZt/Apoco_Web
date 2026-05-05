<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sistema APOCO</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <h2>Menú APOCO - Políticos</h2>
        <form action="ApocoServlet" method="POST">
            
            <label for="size">Cantidad de corruptos:</label>
            <input type="number" id="size" name="size" required min="1">
            
            <label for="algorithm">Algoritmo de ordenamiento (Menor a Mayor):</label>
            <select id="algorithm" name="algorithm" required>
                <option value="bubble">Bubble Sort</option>
                <option value="quick">Quick Sort</option>
            </select>
            
            <button type="submit">Generar y Ordenar</button>
        </form>
    </div>
</body>
</html>