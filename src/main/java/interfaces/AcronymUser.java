/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import exceptions.NoAcronymFoundException;

/**
 *
 * @author HazemSaeid
 */
public class AcronymUser {

    AcronymInterface acr;

    public void setAcronoym(AcronymInterface acr) {
        this.acr = acr;
    }

    public String getInitialPhrase(String Acronym) throws NoAcronymFoundException {
        return acr.getInitialPhrase(Acronym);
    }

}
