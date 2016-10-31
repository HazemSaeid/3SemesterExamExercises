/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exceptions.NoAcronymFoundException;
import interfaces.AcronymInterface;
import interfaces.AcronymUser;
import interfaces.facade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author HazemSaeid
 */
public class Testing {

    static AcronymInterface ai;
    static AcronymUser au;

    public Testing() {
    }

    @BeforeClass
    public static void setUpClass() {
        au = new AcronymUser();
        ai = mock(AcronymInterface.class);
        au.setAcronoym(ai);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getInitialPhrase() throws exceptions.NoAcronymFoundException {
        //JUNIT
//        AcronymInterface acronym = new facade();
//        String result = acronym.getInitialPhrase("NATO");
//        assertTrue(result.equals("North Atlantic Treaty Organization"));
    
    //MOCKITO
    when(ai.getInitialPhrase("NATO")).thenReturn("North Atlantic Trade Organizaton");
    String result = au.getInitialPhrase("NATO");
    assertTrue(result.equals("North Atlantic Trade Organizaton"));

    }

    @Test(expected = NoAcronymFoundException.class)
    public void NoAcronymFoundException() throws exceptions.NoAcronymFoundException {
        //JUNIT
//        AcronymInterface f = new facade();
//        f.getInitialPhrase("NATO");
        //MOCKITO
        System.out.println("Testing exception");
        when(ai.getInitialPhrase("NTO")).thenThrow(NoAcronymFoundException.class);
        au.getInitialPhrase("NTO");
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
