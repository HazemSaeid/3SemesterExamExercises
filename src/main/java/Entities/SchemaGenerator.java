/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author HazemSaeid
 */
public class SchemaGenerator {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1_PU");
        EntityManager em = emf.createEntityManager();
        Project p = new Project();
        em.getTransaction().begin();
        p.setName("hej");
        p.setDescription("hejhej");
        p.setCreated(new Date());
        System.out.println("persisted the object ");
        em.persist(p);
        em.close();
    }
}
