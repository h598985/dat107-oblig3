package com.dat107.oblig3.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.dat107.oblig3.model.Ansatt;
import com.dat107.oblig3.model.Avdeling;
import com.dat107.oblig3.util.JpaUtil;

public class AnsattDAO {

    private EntityManagerFactory emf;

    public AnsattDAO() {
    	
        this.emf = JpaUtil.getEntityManagerFactory();
        
    }


    public void leggTilAnsatt(Ansatt ansatt) {
    	
    	EntityManager entityManager = this.emf.createEntityManager();
    	
    	try {
    		
    	      entityManager.getTransaction().begin();
    	        
    	        entityManager.persist(ansatt);
    	        
    	        entityManager.getTransaction().commit();
    	        
			
		} catch (Exception e) {
			System.out.println("leggTilAnsatt");
			 
		}finally {
			
			entityManager.close();
		}
       
    }

    
    public Ansatt finnAnsattMedId(Integer ansId) {
    	
    	EntityManager entityManager = this.emf.createEntityManager();
    	
    	Ansatt ansatt = null;
    	
    	try {
    		
    		entityManager.getTransaction().begin();
    		
    		ansatt= entityManager.find(Ansatt.class, ansId);
    		
    		 entityManager.getTransaction().commit();
    		 
    		 return ansatt;
			
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Feil i finnAnsattMedId ");
			System.out.println(e);
			
		} finally {
			
			 entityManager.close();
		} 
    	
    	return ansatt;
    }
    
    public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
    	
    	EntityManager entityManager = this.emf.createEntityManager();
    	
    	Ansatt ansatt = null;
    	
    	try {
    		
        	
        	String jpql = "SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn";
        	
        	Query query = entityManager.createQuery(jpql);
        	
        	query.setParameter("brukernavn", brukernavn);
        	
        	List<Ansatt> resultList = query.getResultList();
        	
            if (!resultList.isEmpty()) {
            	
            	ansatt = resultList.get(0); 
            }
            return ansatt;
			
		} catch (Exception e) {
			
			System.out.println("Feil i finnAnsattMedBrukernavn");
		}
    	
    	return ansatt;

    	
    }

    // Update operation
    public void oppdaterAnsattStilling(Ansatt ansatt, String nyStilling) {
    	
    	EntityManager entityManager = this.emf.createEntityManager();
    	
    	try {
    		
            entityManager.getTransaction().begin();
            
            Ansatt a = entityManager.find(Ansatt.class, ansatt.getAnsattId());
            
            if (a != null) {
				
            	a.setStilling(nyStilling);
            	
            	 entityManager.merge(ansatt);
			} else {
				
				System.out.println("Det angitte ansattet finnes ikke i databasen");
			}
            
           
            entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Feil i oppdaterAnsatt");
			
		}finally {
			
			entityManager.close();
		}

    }
    
    
    public void oppdaterAnsattAvdeling(Ansatt ansatt, Avdeling nyAvdeling) {
    	
    	EntityManager entityManager = this.emf.createEntityManager();
    	
    	try {
    		
            entityManager.getTransaction().begin();
            
            Ansatt a = entityManager.find(Ansatt.class, ansatt.getAnsattId());
            
            
            if (a != null) {
            	
            	Avdeling naaverendeAvdeling = a.getAvdeling();
            	
            	if (naaverendeAvdeling != null && naaverendeAvdeling.getSjef() != null && naaverendeAvdeling.getSjef().equals(a)) {
            		
            		System.out.println("Ansattet er sjefen i avdeling og kan ikke endre avdelingen");
					
				} else {
					
	            	a.setAvdeling(nyAvdeling);
	            	
	            	 entityManager.merge(a);

	            	 entityManager.getTransaction().commit();
	       
				}

			} else {
				
				System.out.println("Den angitte avdelingen finnes ikke i databasen");
			}
           
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			
			System.out.println("Feil i oppdaterAnsattAvdeling");
			
			System.out.println(e);
			
		}finally {
			
			entityManager.close();
		}

		
	}
    
    
    public void oppdaterAnsatt(Ansatt ansatt) {
    	
    	EntityManager entityManager = this.emf.createEntityManager();
    	
    	try {
    		
    		entityManager.getTransaction().begin();
    		
    		entityManager.merge(ansatt);
    		
    		entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			
			entityManager.getTransaction().rollback();
			
			System.out.println(e);
			
		}finally {
			
			entityManager.close();
		}
		
	}

  
	  
	  public void fjernAnsatt(Ansatt an) {
		  
	    	EntityManager entityManager = this.emf.createEntityManager();
	    	
	    	try {
	    		
	    		entityManager.getTransaction().begin();
	    		
	    		Ansatt ansatt = entityManager.merge(an);
	    		
	    		Avdeling avdeling = ansatt.getAvdeling();
	    		
	    		if (avdeling != null) {
	    
	    			if (avdeling.getSjef().getAnsattId() == ansatt.getAnsattId()) {
	    				
						System.out.println("\nKan ikke fjerne ansatt fordi denne ansatten er sjef");
						
						return;
						
					} else {
						
		    			avdeling.getAnsatte().remove(ansatt);
		    			entityManager.merge(avdeling);
					}

				}
	    		
	    		entityManager.remove(ansatt);
	    		
	    		entityManager.getTransaction().commit();
				
			} catch (Exception e) {
				
				if (entityManager.getTransaction().isActive()) {
					entityManager.getTransaction().rollback();
				}
				
				
				System.out.println(e.getStackTrace());
				
			}finally {
				
				entityManager.close();
			}
	  
	  }
	

    
    public List<Ansatt> hentAlleAnsatte() {
    	
    	EntityManager entityManager = this.emf.createEntityManager();
    	List<Ansatt> ansatte = null;
    
    	try {
    		
    		  Query query = entityManager.createQuery("SELECT a FROM Ansatt a");
    	        
    	      ansatte = query.getResultList();		
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally {
			
			entityManager.close();
		}
    	
     return ansatte;
    }
}
