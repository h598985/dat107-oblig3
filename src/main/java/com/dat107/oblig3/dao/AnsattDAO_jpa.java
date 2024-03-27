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
    	
        entityManager.getTransaction().begin();
        
        entityManager.persist(ansatt);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
    }

    // Read operation
    public Ansatt finnAnsattMedId(Long ansId) {
        return entityManager.find(Ansatt.class, ansId);
    }
    
    public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
    	
    	String jpql = "SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn";
    	
    	Query query = entityManager.createQuery(jpql);
    	
    	query.setParameter("brukernavn", brukernavn);
    	
    	List<Ansatt> resultList = query.getResultList();
    	
        if (!resultList.isEmpty()) {
            return resultList.get(0); // Assuming brukernavn is unique
        }
        return null;
    	
    }

    // Update operation
    public void oppdaterAnsatt(Ansatt ansatt) {
        entityManager.getTransaction().begin();
        entityManager.merge(ansatt);
        entityManager.getTransaction().commit();
    }

    // Delete operation
    public void fjernAnsattMedId(Long ansId) {
        Ansatt ansatt = finnAnsattMedId(ansId);
        if (ansatt != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(ansatt);
            entityManager.getTransaction().commit();
        }
    }
    
    public void fjernAnsatt(Ansatt a) {
    	
    }

    // Retrieve all employees
    public List<Ansatt> hentAlleAnsatte() {
        Query query = entityManager.createQuery("SELECT a FROM Ansatt a");
        return query.getResultList();
    }
}
