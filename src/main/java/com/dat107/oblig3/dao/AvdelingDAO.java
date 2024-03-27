package com.dat107.oblig3.dao;

import javax.persistence.EntityManager;

import com.dat107.oblig3.model.Ansatt;
import com.dat107.oblig3.model.Avdeling;

public class AvdelingDAO {

    private EntityManager entityManager;
    public AvdelingDAO(EntityManager entityManager) {
    	this.entityManager = entityManager;
    }
    public Avdeling finnAvdelingMedId(Integer id) {
    	Avdeling avdeling = null;
    	try {
    		entityManager.getTransaction().begin();
    		avdeling = entityManager.find(Avdeling.class, id);
            entityManager.getTransaction().commit();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	finally {    		
    		entityManager.close();
    	}
    	return avdeling;
    }
	
}
