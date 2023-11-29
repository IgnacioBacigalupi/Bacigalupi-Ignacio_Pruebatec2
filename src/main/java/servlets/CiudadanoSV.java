package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Ciudadano;
import logica.ControladoraCiudadano;

@WebServlet(name = "CiudadanoSV", urlPatterns = {"/CiudadanoSV"})
public class CiudadanoSV extends HttpServlet {

    ControladoraCiudadano ciudadanoPersis = new ControladoraCiudadano();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Se obtienen los ciudadanos desde la BD
        List<Ciudadano> listCiudadanos = ciudadanoPersis.traerCiudadano();

        // Establecer los resultados en la solicitud para que se muestren en el JSP
        request.setAttribute("ciudadanos", listCiudadanos);

        // Redirigir de vuelta al formulario
        request.getRequestDispatcher("ciudadano.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");

        Ciudadano ciudadano = new Ciudadano();
                //Validacion de los datos ingresados
        if (nombre.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ]+") && apellido.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ]+")) {
            ciudadano.setNombre(nombre);
            ciudadano.setApellido(apellido);

            // Validar teléfono para que contenga solo números
            if (telefono.matches("\\d+")) {
                ciudadano.setTelefono(telefono);

                ciudadanoPersis.crearCiudadano(ciudadano);
                response.sendRedirect("index.jsp");
                return;
            } else {
                // Manejar error de teléfono
                request.setAttribute("errorTelefono", true);
            }
        } else {
            // Manejar error de nombre y apellido
            request.setAttribute("errorNombreApellido", true);
        }

        // Redirigir de vuelta al formulario con mensajes de error
        request.getRequestDispatcher("ciudadano.jsp").forward(request, response);
    }

}

