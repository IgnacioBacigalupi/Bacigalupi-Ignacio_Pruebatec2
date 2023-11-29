
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


@WebServlet(name = "MostrarCiudadanoSV", urlPatterns = {"/MostrarCiudadanoSV"})
public class MostrarCiudadanoSV extends HttpServlet {
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
        request.getRequestDispatcher("index.jsp").forward(request, response);

        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
}
