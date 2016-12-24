/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entities.Student;

import Facade.Facade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author HazemSaeid
 */
public class main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpqlDemo");
        EntityManager em = emf.createEntityManager();
        Persistence.generateSchema("jpqlDemo", null);
        Facade f = new Facade();
        Student s = new Student("Hazem", "Saeid");
//        em.getTransaction().begin();
//        f.addStudent(s);
//        em.persist(s);
//        em.getTransaction().commit();
//        em.close();
    }
}
