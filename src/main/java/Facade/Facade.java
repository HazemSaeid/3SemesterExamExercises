/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.City;
import Entity.Country;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author HazemSaeid
 */
public class Facade implements iFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAREST_PU");

    @Override
    public List<Country> getAllCountries() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            return em.createQuery("SELECT c.code,c.name,c.continent FROM Country c", Country.class).getResultList();
        } finally{
            em.close();
        }

    }

    @Override
    public List<Country> getAllCountriesPopulation(int population) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            return (List<Country>) em.createQuery("SELECT c.name, c.population FROM Country c WHERE c.population > :population", Country.class).setParameter("population", population).getResultList();
            
        } finally {
            em.close();
        }
    }

    @Override
    public ArrayList<City> getCitiesFromCountry(String code) {
        Country c = new Country();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            c = getCountryFromCode(code);
            return new ArrayList(c.getCityCollection());
        } finally {
            em.close();
        }
    }
    public Country getCountryFromCode(String code) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
        TypedQuery<Country> country = em.createNamedQuery("Country.findByCode", Country.class);
        return country.setParameter("code", code).getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public void addCityforCountry(String name, String countryCode, String district, int population) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Country country = getCountryFromCode(countryCode);
        City c = new City(name, district, population, country);
        try {
           em.persist(c);
           em.getTransaction().commit();
        } finally {
           em.close();
        }
    }


}
