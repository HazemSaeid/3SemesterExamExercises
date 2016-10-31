/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import exceptions.NoAcronymFoundException;
import interfaces.AcronymInterface;


/**
 *
 * @author HazemSaeid
 */
public class facade implements AcronymInterface{

    @Override
    public String getInitialPhrase(String Acronym) throws NoAcronymFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
