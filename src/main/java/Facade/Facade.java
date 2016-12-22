/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.Project;
import Entities.ProjectUser;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author HazemSaeid
 */
public class Facade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1_PU");
    EntityManager em = emf.createEntityManager();

    public String FindUser(String userName) {
        try {
            em.getTransaction().begin();
            return em.createQuery("SELECT p from ProjectUser WHERE p.userName =: userName", ProjectUser.class).setParameter("userName", userName).toString();
        } finally {
            em.close();
        }

    }
    
    public List<ProjectUser> getAllUsers() {
        try {
            em.getTransaction().begin();
            return (List) em.createQuery("SELECT p.userName FROM ProjectUser p", ProjectUser.class).getResultList();
        } finally {
            em.close();
        }
    }
    
    public void createProject(Project p) {
        try {
            em.getTransaction().begin();
            p.setName("Project1");
            p.setCreated(new Date());
            p.setDescription("Boring ass project");
            p.setLastModified((Timestamp) new Date());
            em.persist(p);
            
        } finally {
            em.close();
        }
    }
    
}
