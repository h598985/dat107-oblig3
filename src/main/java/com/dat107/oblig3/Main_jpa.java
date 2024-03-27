package com.dat107.oblig3;

import java.sql.Date;

import javax.persistence.EntityManager;

import com.dat107.oblig3.dao.AnsattDAO_jpa;
import com.dat107.oblig3.model.Ansatt;
import com.dat107.oblig3.util.JpaUtil;

public class Main_jpa {
    /**
     * @param args
     */
    public static void main(String[] args) {
    	
    	EntityManager entityManager = JpaUtil.createEntityManager();
       

        AnsattDAO_jpa ansattDAO = new AnsattDAO_jpa(entityManager);

        // Create
        
        Ansatt nyAnsatt = new Ansatt();
        nyAnsatt.setBrukernavn("username");
        nyAnsatt.setFornavn("John");
        nyAnsatt.setEtternavn("Doe");
        nyAnsatt.setAnsattelsesdato(new Date(2022, 11, 11));
        nyAnsatt.setStilling("Manager");
        nyAnsatt.setMaanedslonn(23000);
        
        // Set other properties...
        
        ansattDAO.leggTilAnsatt(nyAnsatt);

        // Read
        
//        Ansatt funnetAnsatt = ansattDAO.finnAnsattMedId(1L); // assuming ID 1 exists
//
//        // Update
//        
//        funnetAnsatt.setStilling("Manager");
//        
//        ansattDAO.oppdaterAnsatt(funnetAnsatt);
//
//        // Delete
//        
//        ansattDAO.fjernAnsattMedId(1L); // assuming ID 1 exists
//       
//
//        // Retrieve all employees
//        
//        System.out.println("All employees:");
//        
//        ansattDAO.hentAlleAnsatte().forEach(System.out::println);
//
//       
//        entityManager.close();
    }
}
