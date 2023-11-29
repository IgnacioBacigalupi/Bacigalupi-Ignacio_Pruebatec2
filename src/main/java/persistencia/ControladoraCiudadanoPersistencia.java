package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Ciudadano;
import logica.exceptions.NonexistentEntityException;
public class ControladoraCiudadanoPersistencia {

    CiudadanoJpaController ciudadanoJpa = new CiudadanoJpaController();

    /*Turno*/
    public void crearCiudadano(Ciudadano ciudadano) {
        ciudadanoJpa.create(ciudadano);
    }

    public void eliminarCiudadano(int id) {
        try {
            ciudadanoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraTurnoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Ciudadano> traerCiudadano() {
        return ciudadanoJpa.findCiudadanoEntities();
    }

    public void editarCiudadano(Ciudadano ciudadano) {
        try {
            ciudadanoJpa.edit(ciudadano);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraTurnoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Ciudadano ObtenerCiudadano(int id) {
        return ciudadanoJpa.findCiudadano(id);
    }

}
