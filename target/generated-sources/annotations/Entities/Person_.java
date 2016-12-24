package Entities;

import Entities.Employee;
import Entities.Grade;
import Entities.Student;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-24T17:58:10")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, Boolean> isMarried;
    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, Student> student;
    public static volatile ListAttribute<Person, Student> students;
    public static volatile SingularAttribute<Person, Long> id;
    public static volatile ListAttribute<Person, Grade> grades;
    public static volatile SingularAttribute<Person, Employee> employee;
    public static volatile ListAttribute<Person, Employee> employees;
    public static volatile SingularAttribute<Person, Date> birthDate;
    public static volatile SingularAttribute<Person, Integer> age;

}