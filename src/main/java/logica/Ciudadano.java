
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
public class Ciudadano implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    
    private String nombre;
    
    private  String apellido;
    
    private  String telefono;
    
    @OneToMany(mappedBy = "ciudadano", cascade = CascadeType.ALL)
    private List<Turno> turnos;

    public Ciudadano() {
    }

    public Ciudadano(String nombre, String apellido, String telefono, List<Turno> turnos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
