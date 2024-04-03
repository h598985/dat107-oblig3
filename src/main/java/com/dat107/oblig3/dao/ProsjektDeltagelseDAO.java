package com.dat107.oblig3.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.dat107.oblig3.model.Ansatt;
import com.dat107.oblig3.model.Prosjektdeltagelse;
import com.dat107.oblig3.util.JpaUtil;

public class ProsjektDeltagelseDAO {
	
	private EntityManagerFactory emf;
	
	public ProsjektDeltagelseDAO() {
	
		this.emf = JpaUtil.getEntityManagerFactory();
		
		}
	

    
    public void leggTilProsjektdeltagelse(Prosjektdeltagelse deltagelse) {

		EntityManager entityManager = emf.createEntityManager();
		
		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.persist(deltagelse);

			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			
			entityManager.getTransaction().rollback();
			
			System.out.println(e);
			
		} finally {
			
			entityManager.close();
		}

	}
    
    
	public Prosjektdeltagelse finnProsjektdeltagelseMedID(Integer id) {
		
		EntityManager entityManager = emf.createEntityManager();
		
		Prosjektdeltagelse prosjektdeltagelse = null;
	
		try {
			
			prosjektdeltagelse = entityManager.find(Prosjektdeltagelse.class, id);
				
		} catch (Exception e) {
			
			System.out.println(e);
			
		} finally {
			
			entityManager.close();
		}

		return prosjektdeltagelse;
	}
    
    
    public void oppdaterAntallTimerTilEnAnsatt(Integer deltagelseId, Integer ansattId, Integer antallTimer) {
    	
    	EntityManager entityManager = emf.createEntityManager();
    	
    	Prosjektdeltagelse prosjektdeltagelse = null;
    	Ansatt ansatt = null;
		
		try {
			
			entityManager.getTransaction().begin();
			
			prosjektdeltagelse = entityManager.find(Prosjektdeltagelse.class, deltagelseId);
			ansatt = entityManager.find(Ansatt.class, ansattId);
			
			if (prosjektdeltagelse == null) {
				
				System.out.println("Prosjekt deltagelse med id "+ deltagelseId + " ekisterer ikke");
				
				return;
				
			} else if (ansatt == null) {
				
				System.out.println("Ansatt med id "+ ansattId + " ekisterer ikke");
				
				return;
			}
			
			List<Prosjektdeltagelse> prosjektdeltagelser = ansatt.getProsjektdeltagelser()
				    .stream()
				    .filter((Prosjektdeltagelse deltagelse) -> deltagelse.getProsjektdeltagelseId() == deltagelseId)
				    .collect(Collectors.toList());
			
			
			if (prosjektdeltagelser.isEmpty() || prosjektdeltagelser == null) {
				
				System.out.println("Ansatt med id "+ ansattId + " har deltatt i " + 
				"prosjekt deltagelse med id "+ deltagelseId + " eller prosjekt deltagelse med id " + deltagelseId + " ekisterer ikke");
				
				return;
			} 
			
			prosjektdeltagelse.setAntallTimer(antallTimer);
			
			entityManager.merge(prosjektdeltagelse);
		
			entityManager.getTransaction().commit();
			
		} catch(Exception e) {
			
			entityManager.getTransaction().rollback();
			
			System.out.println(e);
			
		} finally {
			
			entityManager.close();
		}
	}
    
    

    


    public void fjernProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
    	
    	EntityManager entityManager = emf.createEntityManager();
    	
    	try {
    		
    		entityManager.getTransaction().begin();
    		
    		entityManager.remove(prosjektdeltagelse);
    		
    		entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			
			entityManager.getTransaction().rollback();
			
			System.out.println(e);
			
		} finally {
			
			entityManager.close();
		}
       
    }
    
    
    
    public List<Prosjektdeltagelse> henteAlleprosjekteProsjektdeltagelser(){
    	
    	EntityManager entityManager = emf.createEntityManager();
    	
    	List<Prosjektdeltagelse> prosjektdeltagelser = null;
    	
    	try {
    		
    		entityManager.getTransaction().begin();
    		
    		Query query = entityManager.createQuery("SELECT pd FROM Prosjektdeltagelse pd");
    		
    		prosjektdeltagelser = query.getResultList();
    		
    		entityManager.getTransaction().commit();
			
		} catch (Exception e) {

			System.out.println(e);
			
		} finally {
			
			entityManager.close();
		}
    	
    	return prosjektdeltagelser;
    }
    
}
