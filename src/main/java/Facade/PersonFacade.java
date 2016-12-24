/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.Person;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author HazemSaeid
 */
public class PersonFacade implements iFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA2_PU");
    EntityManager em = emf.createEntityManager();
    @Override
    public void add(Person p) {
        em.getTransaction().begin();
        try {
            p.setAge(12); p.setBirthDate(new Date()); p.setFirstName("Hazem"); p.setLastName("Saeid"); p.setIsMarried(false); 
            em.persist(p);
        } finally {
            em.close();
        }
    }

    @Override
    public Person find() {
        Person p = new Person();
        try {
            em.getTransaction().begin();
            return em.find(Person.class, p);
        } finally {
            em.close();
        }
    }

    @Override
    public void edit(Person p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Person p) {
        try {
            em.getTransaction().begin();
            em.remove(p);
        } finally {
            em.close();
        }
    }

}
