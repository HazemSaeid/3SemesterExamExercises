/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.persistence.Persistence;

/**
 *
 * @author HazemSaeid
 */
public class SchemaGenerator {
    public static void main(String[] args) {
        
        Persistence.generateSchema("JPA2_PU", null);
    }
}
