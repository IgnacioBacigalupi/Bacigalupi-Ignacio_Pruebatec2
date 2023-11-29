
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Tramite implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String descripcion; 
    
    @OneToMany(mappedBy ="tramite", cascade = CascadeType.ALL)
    private List<Turno> turnos;

    public Tramite() {
    }

    public Tramite(int id, String descripcion, List<Turno> turnos) {
        this.id = id;
        this.descripcion = descripcion;
        this.turnos = turnos;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
