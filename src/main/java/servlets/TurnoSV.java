package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Ciudadano;
import logica.ControladoraTramite;
import logica.ControladoraTurno;
import logica.Tramite;
import logica.Turno;

@WebServlet(name = "TurnoSV", urlPatterns = {"/TurnoSV"})
public class TurnoSV extends HttpServlet {

    ControladoraTurno controlPersis = new ControladoraTurno();
    ControladoraTramite controladoraTramite = new ControladoraTramite();
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String fechaFiltrarStr = request.getParameter("fechaFiltrar");
    String estadoFiltrar = request.getParameter("estadoFiltrar");
    LocalDate fechaFiltrar = (fechaFiltrarStr != null && !fechaFiltrarStr.isEmpty()) ? LocalDate.parse(fechaFiltrarStr) : null;

    if (fechaFiltrar != null) {
        List<Turno> listaTurnos = controlPersis.traerTurno();
        List<Turno> turnosFiltrados = listaTurnos.stream()
                .filter(turno -> turno.getFecha().isEqual(fechaFiltrar))
                .collect(Collectors.toList());

        request.setAttribute("listaDeTurnos", turnosFiltrados);
    }

    if ("true".equals(request.getParameter("filtrarPorEstado")) && fechaFiltrar != null) {
        boolean estado = Boolean.parseBoolean(estadoFiltrar);
        List<Turno> turnosFiltradosEstadoFecha = controlPersis.buscarTurnoEstadoFecha(fechaFiltrar, estado);
        request.setAttribute("listaDeTurnos", turnosFiltradosEstadoFecha);
    }

    request.getRequestDispatcher("index.jsp").forward(request, response);
}




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Ciudadano ciudadano = new Ciudadano();

        String descripcion = request.getParameter("descripcion");
        String ciudadanoStr = request.getParameter("ciudadano");
        int idCiudadano = Integer.parseInt(ciudadanoStr);

        Tramite tramite = new Tramite();
        tramite.setDescripcion(descripcion);
        controladoraTramite.crearNuevoTramite(tramite);

        Turno turno = new Turno();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"), formatter);

        ciudadano.setId(idCiudadano);

        turno.setCiudadano(ciudadano);
        turno.setFecha(fecha);
        turno.setTramite(tramite);

        controlPersis.crearTurno(turno);

        response.sendRedirect("index.jsp");
    }
}
