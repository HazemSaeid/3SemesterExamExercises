/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Entity.City;
import Entity.Country;
import Facade.Facade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author HazemSaeid
 */
@Path("all")
public class CountryResource {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CountryResource
     */
    public CountryResource() {
    }

    /**
     * Retrieves representation of an instance of REST.CountryResource
     *
     * @return an instance of java.lang.String
     */
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Facade f = new Facade();
        List<Country> list = f.getAllCountries();
        String json = gson.toJson(list);
        return json;
    }
    @Path("population/{population}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPopulation(@PathParam("population")int population) {
        Facade f = new Facade();
        List<Country> list = f.getAllCountriesPopulation(population);
        String json = gson.toJson(list);
        return json;
    }
    
    @Path("countrycode/{code}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCitiesFromCode(@PathParam("code")String code){
        Facade f = new Facade();
        List<City> list = f.getCitiesFromCountry(code);
        String json = gson.toJson(list);
        return json;
    }
    /**
     * PUT method for updating or creating an instance of CountryResource
     *
     * @param content representation for the resource
     */
    @Path("createCity/{city}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(@PathParam("city")String city) {
        Facade f = new Facade();
        f.addCityforCountry(city, city, city, 0);
    }
}
