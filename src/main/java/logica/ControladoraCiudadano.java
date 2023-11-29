
package logica;


import persistencia.ControladoraCiudadanoPersistencia;
import java.util.List;



public class ControladoraCiudadano {
    
    ControladoraCiudadanoPersistencia  controlPersisciudadano = new ControladoraCiudadanoPersistencia();
    
    
    /* Ciudadano*/
    public void crearCiudadano(Ciudadano ciudadano) {
        controlPersisciudadano.crearCiudadano(ciudadano);
    }    
    
    public void eliminarCiudadano(int id) {
        controlPersisciudadano.eliminarCiudadano(id);
    }
    
    public List<Ciudadano> traerCiudadano() {
        return controlPersisciudadano.traerCiudadano();
    }
    
    public void editarCiudadano(Ciudadano ciudadano) {
        controlPersisciudadano.editarCiudadano(ciudadano);
    }

    
}
