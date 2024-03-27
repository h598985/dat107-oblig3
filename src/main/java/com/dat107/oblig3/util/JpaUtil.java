package com.dat107.oblig3.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static final String PERSISTENCE_UNIT_NAME = "postgresPersistenceUnit";
    private static final EntityManagerFactory entityManagerFactory;
    
    static {
    	
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManagerFactory getEntityManagerFactory() {
    	
        return entityManagerFactory;
    }

    public static EntityManager createEntityManager() {
    	
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
    	
        entityManagerFactory.close();
    }
}