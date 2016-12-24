/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author HazemSaeid
 */
public class Facade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpqlDemo", null);
    EntityManager em = emf.createEntityManager();
    public List<Student> findAllStudents() {
        Student s = new Student();
        try {
        em.getTransaction().begin();
       return (List) em.createQuery("SELECT s FROM Student s");
            
        } finally {
       em.close();
        }

    }
    public List<Student> findByFirstName() {
        Student s = new Student();
        try {
            em.getTransaction().begin();
            return (List) em.createQuery("SELECT s.firstname FROM Student s WHERE s.firstname = 'jan'");
        } finally {
            em.close();
        }
    }
    public List<Student> FindByLastName() {
            Student s = new Student();
        try {
            em.getTransaction().begin();
            return (List) em.createQuery("SELECT s.lastname FROM Student s WHERE s.lastname = 'olsen'");
        } finally {
            em.close();
        }
    }
    
    public int findSPCountForSpecificID() {
        try {
            em.getTransaction().begin();
            return em.createQuery("SELECT COUNT(s.score) FROM Studypoint s WHERE s.studentId = 2").getFirstResult();
        } finally {
            em.close();
        }
    }
    public int findSPCount() {
        try {
            em.getTransaction().begin();
        return em.createQuery("SELECT COUNT(s.score) FROM Studypoint s").getFirstResult();
        } finally {
            em.close();
        }
       
    }
    public void addStudent(Student s) {
        em.getTransaction().begin();
          em.persist(s);
            
        em.getTransaction().commit();
        em.close();
        }
//    public static void main(String[] args) {
//        
//        Facade f = new Facade();
//        Student s = new Student();
//        s.setFirstname("Hazem");
//        s.setLastname("dasnjknajk");
//        f.addStudent(s);
//        System.out.println("Added student!");
//    }
    }
    

