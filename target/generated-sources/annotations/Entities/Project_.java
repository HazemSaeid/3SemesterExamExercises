package Entities;

import Entities.ProjectUser;
import Entities.Task;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-22T20:56:15")
@StaticMetamodel(Project.class)
public class Project_ { 

    public static volatile ListAttribute<Project, ProjectUser> pU;
    public static volatile SingularAttribute<Project, Date> created;
    public static volatile SingularAttribute<Project, String> name;
    public static volatile SingularAttribute<Project, String> description;
    public static volatile SingularAttribute<Project, Long> id;
    public static volatile SingularAttribute<Project, Timestamp> lastModified;
    public static volatile ListAttribute<Project, Task> tasks;

}