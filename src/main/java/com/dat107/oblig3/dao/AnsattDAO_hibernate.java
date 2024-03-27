package com.dat107.oblig3.dao;

import org.hibernate.Session;

import com.dat107.oblig3.model.Ansatt;
import com.dat107.oblig3.util.HibernateUtil;

public class AnsattDAO_hibernate {

    public void createAnsatt(Ansatt ansatt) {
    	
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        session.save(ansatt);
        
        session.getTransaction().commit();
        
        session.close();
        
        
        
    }

    
    public Ansatt getAnsattById(int ansattId) {
    	
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Ansatt ansatt = (Ansatt) session.get(Ansatt.class, ansattId);
        
        session.close();
        
        return ansatt;
    }
    
    public void updateAnsatt(Ansatt ansatt) {
    	
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        session.update(ansatt);
        
        session.getTransaction().commit();
        
        session.close();
    }
}