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

/**
 *
 * @author HazemSaeid
 */
public interface iFacade {
    List<Country> getAllCountries();
    List<Country> getAllCountriesPopulation(int population);
    ArrayList<City> getCitiesFromCountry(String code);
    void addCityforCountry(String name, String countryCode, String district, int population);
    
}
