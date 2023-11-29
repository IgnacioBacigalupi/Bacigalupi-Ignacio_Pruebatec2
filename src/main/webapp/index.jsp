<%@page import="logica.Ciudadano"%>
<%@page import="logica.Turno"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Prueba Tecnica 2</title>
        <!-- Agregar estilos de Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/superhero/bootstrap.min.css">

    </head>

    <div>
        <form  action="CiudadanoSV"  method="GET">
            <button type="submit" class="btn btn-primary">Menú ciudadano</button>
        </form>
        <br>

        <form  action="MostrarCiudadanoSV"  method="GET">
            <button type="submit" class="btn btn-primary">Mostrar Ciudadanos</button>
        </form>

    </div>
    <h3>Lista de Ciudadanos:</h3>
    <% List<Ciudadano> ciudadanos = (List<Ciudadano>) request.getAttribute("ciudadanos");
        if (ciudadanos != null && !ciudadanos.isEmpty()) { %>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
            </tr>
        </thead>
        <tbody>
            <% for (Ciudadano ciudadano : ciudadanos) {%>
            <tr>
                <td><%= ciudadano.getId()%></td>
                <td><%= ciudadano.getNombre()%></td>
                <td><%= ciudadano.getApellido()%></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <% }  %>
</div>
<br>
<h2>Solicitar turno</h2>
<form action="TurnoSV" method="POST">

    <div class="form-group">
        <label for="fecha">Fecha</label>
        <input type="date" class="form-control" id="fecha" name="fecha" required>
    </div>       

    <div class="form-group">
        <label for="descripcion">Descripcion</label>
        <input type="text" class="form-control" id="descripcion" name="descripcion" required>
    </div>         

    <div class="form-group">
        <label for="ciudadano">Ciudadano</label>
        <input type="text" class="form-control" id="ciudadano" name="ciudadano"  placeholder="Ingrese su ID" required>
    </div>                

    <button type="submit" class="btn btn-primary">Guardar</button>
</form>

<!-- Tabla de turnos -->
<br> 
<br>
<!-- Filtrado de turnos -->
<form action="TurnoSV" method="GET" class="mt-4 text-center">
    <div class="row">
        <div class="col-md-6">
            <label for="fechaFiltrar">Fecha a filtrar</label>
            <input type="date" class="form-control" name="fechaFiltrar" required>
        </div>
        <div class="col-md-6">
            <label for="estadoFiltrar">Estado a filtrar</label>
            <select class="form-control" name="estadoFiltrar" id="estadoFiltrar">
                <option value="true">Atendido</option>
                <option value="false">En espera</option>
            </select>
        </div>
    </div>
    <button type="submit" class="btn btn-primary mt-3">Filtrar</button>
    <button type="submit" class="btn btn-primary mt-3 ml-3" name="filtrarPorEstado" value="true">Filtrar por estado</button>
</form>

<div class="results-table">
    <h3>Turnos:</h3>
    <% if (request.getAttribute("listaDeTurnos") != null) { %>
    <table class="table">
        <thead>
            <tr>
                <th>Id</th>
                <th>Tramite</th>
                <th>Fecha</th>
                <th>Apellido</th>
                <th>Nombre</th>
                <th>Estado</th>
                <th>Cambiar estado</th>

            </tr>
        </thead>
        <tbody>
            <% for (Turno turno : (List<Turno>) request.getAttribute("listaDeTurnos")) {%>
            <tr>

                <td><%= turno.getId()%></td>
                <td><%= turno.getTramite().getDescripcion()%></td>
                <td><%= turno.getFecha()%></td>
                <td><%= turno.getCiudadano().getApellido()%></td>
                <td><%= turno.getCiudadano().getNombre()%></td>
                <td><%= turno.isEstado() ? "Atendido" : "En espera"%></td>
                <td>
                    <% if (turno.isEstado()) {%>
                    <form action="CambiarEstadoSV" method="POST">
                        <input type="hidden" name="idTurno" value="<%= turno.getId()%>">
                        <button type="submit" class="btn btn-success">Poner en espera</button>
                    </form>
                    <% } else {%>
                    <form action="CambiarEstadoSV" method="POST">
                        <input type="hidden" name="idTurno" value="<%= turno.getId()%>">
                        <button type="submit" class="btn btn-success">Marcar como Atendido</button>
                    </form>
                    <% } %>
                </td>
            </tr>
            <% } %>

        <br>

        </tbody>
    </table>
    <%  }%>

</div>      
</html>
