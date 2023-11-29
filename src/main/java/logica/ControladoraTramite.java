
package logica;

import persistencia.ControladoraPersistenciaTramite;

public class ControladoraTramite {
    ControladoraPersistenciaTramite controladora = new ControladoraPersistenciaTramite();
    
    public void crearNuevoTramite (Tramite tramite){
        controladora.crearTramite(tramite);
    }
    
}
