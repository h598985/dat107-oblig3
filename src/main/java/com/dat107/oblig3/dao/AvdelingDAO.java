package com.dat107.oblig3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.dat107.oblig3.model.Ansatt;
import com.dat107.oblig3.model.Avdeling;
import com.dat107.oblig3.util.JpaUtil;

public class AvdelingDAO {
	
	private EntityManagerFactory emf;
	
	public AvdelingDAO() {
		
		this.emf = JpaUtil.getEntityManagerFactory();
	}
	
	
	
    public void leggTilNyAvdeling(Avdeling avdeling, Ansatt avdelingSjef) {
    	
    	EntityManager entityManager = this.emf.createEntityManager();
    	
    	try {
    		
    	      entityManager.getTransaction().begin();
    	      
    	        Ansatt sjef = entityManager.find(Ansatt.class, avdelingSjef.getAnsattId());
    	        
    	        if (sjef != null) {
    	        	
        	        avdeling.setSjef(sjef);
        	        
        	        entityManager.persist(avdeling);
        	        
        	        entityManager.getTransaction().commit();
					
				} else {
					
					System.out.println("Ansatt med " + avdelingSjef.getAnsattId() +" eksister ikke i databasen");
				}
    	        
			
		} catch (Exception e) {
			
			entityManager.getTransaction().rollback();
			
			System.out.println("Feil i leggTilAvdeling");
			
			 
		}finally {
			
			entityManager.close();
		}
       
    }


	public Avdeling finnAvdelingMedId(Integer id) {
		
	    EntityManager entityManager = this.emf.createEntityManager();
	    
	    Avdeling avdeling = null;
	    
	    try {
	    	
	    	entityManager.getTransaction().begin();
	    	
	    	avdeling = entityManager.find(Avdeling.class, id);
	    	
	    	entityManager.getTransaction().commit();
	
	        
	    }catch (Exception e) {
			
	    	System.out.println("Feil i finnAvdelingMedId");
	    	
		} finally {
			
	    	entityManager.close();
	    }
	    
	    return avdeling;
	}
	

	public void fjernAvdeling(Avdeling avdeling) {
		
	    EntityManager entityManager = this.emf.createEntityManager();
	    
	
	    try {
	    	
	    	entityManager.getTransaction().begin();
	    	
	    	entityManager.remove(avdeling);
	    	
	    	entityManager.getTransaction().commit();
	
	        
	    }catch (Exception e) {
	    	
			entityManager.getTransaction().rollback();
	    	System.out.println("Feil i fjernAvdeling");
	    	
		} finally {
			
	    	entityManager.close();
	    }

	}
	

    public List<Ansatt> listAlleAnsatteIAvdeling(Avdeling avdeling) {
    	
    	  EntityManager entityManager = this.emf.createEntityManager();
    	  
    	  List<Ansatt> ansatte = null;
    	  
        try { 
        	entityManager.getTransaction().begin();
        	
        	String jpql = "SELECT a FROM Ansatt a WHERE a.avdeling = :avdeling";
        	
        	Query query = entityManager.createQuery(jpql, Ansatt.class);
        	
        	query.setParameter("avdeling", avdeling);
        	
        	ansatte = query.getResultList();
        	
          	entityManager.getTransaction().commit();        
                    
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
        
        
        return ansatte;
    }
    
    public List<Avdeling> henteAlleAvdeling() {

    	EntityManager entityManager = this.emf.createEntityManager();
    	List<Avdeling> avdelinger = null;
    	
    	try {
    		entityManager.getTransaction().begin();
    		
            Query query = entityManager.createQuery("SELECT a FROM Avdeling a");
            
            avdelinger = query.getResultList();
            
            entityManager.getTransaction().commit();
            
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally {
			
			entityManager.close();
		}
    	
    	return avdelinger;
    
	}




}
