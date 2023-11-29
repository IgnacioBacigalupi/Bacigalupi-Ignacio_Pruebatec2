
package persistencia;

import logica.Tramite;


public class ControladoraPersistenciaTramite {
    TramiteJpaController tramiteJpa = new TramiteJpaController();
    
    public void crearTramite(Tramite tramite){
        tramiteJpa.create(tramite);
    }
    
}
