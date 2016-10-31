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
public interface AcronymInterface {

    String getInitialPhrase(String Acronym) throws NoAcronymFoundException;
}
