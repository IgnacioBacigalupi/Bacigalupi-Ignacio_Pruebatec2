package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Turno;
import logica.exceptions.NonexistentEntityException;

public class ControladoraTurnoPersistencia {

    TurnoJpaController turnoJpa = new TurnoJpaController();

    /*Turno*/
    public void crearTurno(Turno turno) {
        turnoJpa.create(turno);
    }

    public void eliminarTurno(int id) {
        try {
            turnoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraTurnoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Turno> traerTurno() {
        return turnoJpa.findTurnoEntities();
    }

    public void editarTurno(Turno turno) {
        try {
            turnoJpa.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraTurnoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Turno ObtenerTurno(int id) {
        return turnoJpa.findTurno(id);
    }

}
