package logica;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Ciudadano;
import logica.Tramite;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-29T21:05:01")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, LocalDate> fecha;
    public static volatile SingularAttribute<Turno, Boolean> estado;
    public static volatile SingularAttribute<Turno, Tramite> tramite;
    public static volatile SingularAttribute<Turno, Integer> id;
    public static volatile SingularAttribute<Turno, Ciudadano> ciudadano;

}