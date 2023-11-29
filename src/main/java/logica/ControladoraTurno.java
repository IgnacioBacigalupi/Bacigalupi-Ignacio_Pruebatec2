package logica;

import java.time.LocalDate;
import persistencia.ControladoraTurnoPersistencia;
import java.util.List;
import java.util.stream.Collectors;

public class ControladoraTurno {

    ControladoraTurnoPersistencia controlPersisTurno = new ControladoraTurnoPersistencia();

    /* Turno */
    public void crearTurno(Turno turno) {
        controlPersisTurno.crearTurno(turno);
    }

    public void eliminarTurno(int id) {
        controlPersisTurno.eliminarTurno(id);
    }

    public List<Turno> traerTurno() {
        return controlPersisTurno.traerTurno();
    }

    public void editarTurno(Turno turno) {
        turno.setEstado(true);
        controlPersisTurno.editarTurno(turno);
    }
    
    public List<Turno> buscarTurnoEstadoFecha( LocalDate fecha , Boolean estado){
        List<Turno> turnoEstado = controlPersisTurno.traerTurno()
                .stream()
                .filter(turno -> turno.getFecha().equals(fecha) && turno.isEstado()==estado)
                  .collect(Collectors.toList());
        return turnoEstado;
                
    }
     
}
