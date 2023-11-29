package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Turno;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-29T21:05:01")
@StaticMetamodel(Tramite.class)
public class Tramite_ { 

    public static volatile SingularAttribute<Tramite, String> descripcion;
    public static volatile ListAttribute<Tramite, Turno> turnos;
    public static volatile SingularAttribute<Tramite, Integer> id;

}