<%@page contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Prueba Tecnica 2</title>
        <!-- Agregar estilos de Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/superhero/bootstrap.min.css">

    </head>
    <body>
        <div class="container mt-4">
            <h2>Crear ciudadano</h2>

            <!-- Mensajes de error para nombre, apellido y teléfono -->
            <% if (request.getAttribute("errorNombreApellido") != null) { %>
            <p style="color: red;">El nombre y el apellido deben contener solo letras.</p>
            <% } %>

            <% if (request.getAttribute("errorTelefono") != null) { %>
            <p style="color: red;">El teléfono debe contener solo números.</p>
            <% }%>

            <form action="CiudadanoSV" method="POST">
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>
                <div class="form-group">
                    <label for="apellido">Apellido</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" required>
                </div>       

                <div class="form-group">
                    <label for="telefono">Teléfono</label>
                    <input type="text" class="form-control" id="telefono" name="telefono" required>
                </div>         

                <button type="submit" class="btn btn-primary btn-rounded">Guardar</button>
            </form>
        </div>
    </body>
</html>
