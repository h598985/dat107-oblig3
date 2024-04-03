package com.dat107.oblig3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.dat107.oblig3.model.Prosjekt;
import com.dat107.oblig3.util.JpaUtil;



public class ProsjektDAO {
	
	private EntityManagerFactory emf;
	
	public ProsjektDAO() {
	
		this.emf = JpaUtil.getEntityManagerFactory();
		
		}
	
	public void leggTilProsjekt(Prosjekt p) {
		
		EntityManager entityManager = emf.createEntityManager();
		
		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.persist(p);
			
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			
			entityManager.getTransaction().rollback();
			
			System.out.println(e);
			
		} finally {

			entityManager.close();
		}
	
	}
	
	public Prosjekt finnProsjektMedId(int id) {
		
        EntityManager entityManager = emf.createEntityManager();
        
		Prosjekt p = null;
		
        try {
        	entityManager.getTransaction().begin();
        	
        	p = entityManager.find(Prosjekt.class, id);
        	
        	entityManager.getTransaction().commit();
        	
        }catch (Exception e) {
			
        	System.out.println(e);
        	
		} finally {
        	
        	entityManager.close();
		}
		
        return p;
	}
	
	
	public void oppdaterProsjekt(Prosjekt p) {
		
		EntityManager entityManager = emf.createEntityManager();
		
		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.merge(p);
			
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			
			entityManager.getTransaction().rollback();
			
			System.out.println(e);
			
		} finally {
			
			entityManager.close();
		}
	}

	public void fjernProsjekt(Prosjekt p) {
		
		EntityManager entityManager = emf.createEntityManager();
		
		try {
			
			entityManager.getTransaction().begin();
			
			entityManager.remove(p);
			
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			
			entityManager.getTransaction().rollback();
			
			System.out.println(e);
			
		} finally {
			
			entityManager.close();
		}
	}	
	
	
	public List<Prosjekt> hentAlleProsjekter() {
		
		EntityManager entityManager = emf.createEntityManager();
		
		List<Prosjekt> prosjekter = null;
		

		try {
			
			Query query = entityManager.createQuery("SELECT p FROM Prosjekt p");
			
			prosjekter = query.getResultList();
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		} finally {
			
			entityManager.close();
		}
		
		return prosjekter;
	}
	
	

}
