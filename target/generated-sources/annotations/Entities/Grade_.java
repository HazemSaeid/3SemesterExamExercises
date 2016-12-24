package Entities;

import Entities.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-24T17:58:10")
@StaticMetamodel(Grade.class)
public class Grade_ { 

    public static volatile SingularAttribute<Grade, Person> person;
    public static volatile SingularAttribute<Grade, String> name;
    public static volatile SingularAttribute<Grade, Long> id;
    public static volatile SingularAttribute<Grade, Integer> value;
    public static volatile SingularAttribute<Grade, Person> personObject;

}