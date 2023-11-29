package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Turno;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-29T21:05:01")
@StaticMetamodel(Ciudadano.class)
public class Ciudadano_ { 

    public static volatile SingularAttribute<Ciudadano, String> apellido;
    public static volatile ListAttribute<Ciudadano, Turno> turnos;
    public static volatile SingularAttribute<Ciudadano, Integer> id;
    public static volatile SingularAttribute<Ciudadano, String> telefono;
    public static volatile SingularAttribute<Ciudadano, String> nombre;

}