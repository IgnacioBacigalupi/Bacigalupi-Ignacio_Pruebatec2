
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Turno;
import persistencia.TurnoJpaController;

@WebServlet(name = "CambiarEstadoSV", urlPatterns = {"/CambiarEstadoSV"})
public class CambiarEstadoSV extends HttpServlet {

    TurnoJpaController turnoController = new TurnoJpaController();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idTurnoStr = request.getParameter("idTurno");

        if (idTurnoStr != null && !idTurnoStr.isEmpty()) {
            int idTurno = Integer.parseInt(idTurnoStr);

            Turno turno = turnoController.findTurno(idTurno);

            if (turno != null) {
                // Cambiar el estado del turno
                boolean nuevoEstado = !turno.isEstado();
                turno.setEstado(nuevoEstado);

                // Guardar los cambios en la base de datos
                try {
                    turnoController.edit(turno); // Método para editar un turno en el controlador JPA
                } catch (Exception e) {
                    
                }

                // Redireccionar de vuelta a la página de turnos después de actualizar
                response.sendRedirect("index.jsp");
            }
        }
    }
}