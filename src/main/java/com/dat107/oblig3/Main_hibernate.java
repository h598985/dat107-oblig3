package com.dat107.oblig3;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dat107.oblig3.util.HibernateUtil;


public class Main_hibernate {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            // Perform database operations using Hibernate here
            // For example: session.save(entity), session.get(entityClass, id), etc.
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}

}
