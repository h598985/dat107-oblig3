package com.dat107.oblig3.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dat107.oblig3.model.Ansatt;

public class AnsattDAO_jpa {

    private EntityManager entityManager;

    public AnsattDAO_jpa(EntityManager entityManager) {
    	
        this.entityManager = entityManager;
    }

    // Create operation
    public void leggTilAnsatt(Ansatt ansatt) {
    	
    	try {
    		
        entityManager.getTransaction().begin();
        
        entityManager.persist(ansatt);
        
        entityManager.getTransaction().commit();
        
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	finally {    		
    		entityManager.close();
    	}
    }

    // Read operation
    public Ansatt finnAnsattMedId(Integer ansId) {
    	Ansatt ansatt = null;
    	try {
    		entityManager.getTransaction().begin();
    		ansatt = entityManager.find(Ansatt.class, ansId);
            entityManager.getTransaction().commit();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	finally {    		
    		entityManager.close();
    	}
    	return ansatt;
    }
    
    public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
    	Ansatt ansatt = null;
    	try {
	    		
	    	String jpql = "SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn";
	    	
	    	Query query = entityManager.createQuery(jpql);
	    	
	    	query.setParameter("brukernavn", brukernavn);
	    	
	    	List<Ansatt> resultList = query.getResultList();
	    	
	        if (!resultList.isEmpty()) {
	            ansatt = resultList.get(0); // Assuming brukernavn is unique
	            return ansatt;
	        }
	        return null;
    	}
    	catch (Exception e) {
    		System.out.println(e);
    	}
    	return ansatt;
    	
    }

    // Update operation
    public void oppdaterAnsatt(Ansatt ansatt) {
    	try {
    		
        entityManager.getTransaction().begin();
        entityManager.merge(ansatt);
        entityManager.getTransaction().commit();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	finally {
    		entityManager.close();
    	}
    }

    // Delete operation
    public void fjernAnsattMedId(Integer ansId) {
    	try {
	        Ansatt ansatt = finnAnsattMedId(ansId);
	        if (ansatt != null) {
	            entityManager.getTransaction().begin();
	            entityManager.remove(ansatt);
	            entityManager.getTransaction().commit();
	        }
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	finally {
    		entityManager.close();
    	}
    }
    
    public void fjernAnsatt(Ansatt a) {
    	try {
    		entityManager.getTransaction().begin();
    		entityManager.remove(a);
    		entityManager.getTransaction().commit();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	finally {
    		entityManager.close();
    		
    	}
    }

    // Retrieve all employees
    public List<Ansatt> hentAlleAnsatte() {
    	List<Ansatt> ansatte = null;
    	try {
	        Query query = entityManager.createQuery("SELECT a FROM Ansatt a");
	        ansatte = query.getResultList();
    	}
    	catch(Exception e) {
    		System.out.println(e);	
    	}
    	return ansatte;
    }
    public Ansatt oppdatereStilling(Ansatt ansatt, String stilling) {
    	Ansatt a = null;
    	try {
    		entityManager.getTransaction().begin();
    		a = finnAnsattMedId(ansatt.getAnstattId());
    		a.setStilling(stilling);
    		entityManager.merge(a);
    		entityManager.getTransaction().commit();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	finally {
    		entityManager.close();
    	}
    	return a;
    }
}
