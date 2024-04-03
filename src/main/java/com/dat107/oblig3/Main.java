package com.dat107.oblig3;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.dat107.oblig3.dao.AnsattDAO;
import com.dat107.oblig3.dao.AvdelingDAO;
import com.dat107.oblig3.dao.ProsjektDAO;
import com.dat107.oblig3.model.Ansatt;
import com.dat107.oblig3.model.Avdeling;

public class Main {
	
    private static Scanner scanner = new Scanner(System.in);
    private static AnsattDAO ansattDAO = new AnsattDAO();
    private static AvdelingDAO avdelingDAO = new AvdelingDAO();
    private static ProsjektDAO prosjektDAO = new ProsjektDAO();
  
    public static void main(String[] args) {
    	
        
        
        Avdeling avdeling1 = new Avdeling("IT",null, Arrays.asList());
        Avdeling avdeling2 = new Avdeling("HR",null, Arrays.asList());
        
        
        Ansatt ansatt1 = new Ansatt("user1", "John", "Doe", new Date(2022, 11, 11), "Manager", 23000, avdeling1,null);
        Ansatt ansatt2 = new Ansatt("user2", "Jane", "Smith",new Date(2022, 11, 11), "Developer", 4000, avdeling1,null);
        Ansatt ansatt3 = new Ansatt("user3", "Alice", "Johnson", new Date(2022, 11, 11), "HR Specialist", 4500, avdeling1,null);
        Ansatt ansatt4 = new Ansatt("user4", "Bob", "Brown", new Date(2022, 11, 11), "Analyst", 4200, avdeling1,null);
        Ansatt ansatt5 = new Ansatt("user5", "Emily", "Wilson", new Date(2022, 11, 11), "Designer", 4800, avdeling1,null);
        Ansatt ansatt6 = new Ansatt("user6", "Michael", "Jones",new Date(2022, 11, 11), "IT Manager", 5500, avdeling1,null);
        Ansatt ansatt7 = new Ansatt("user7", "Sophia", "Martinez", new Date(2022, 11, 11), "Tester", 4100, avdeling1,null);
        Ansatt ansatt8 = new Ansatt("user8", "Matthew", "Taylor", new Date(2022, 11, 11), "System Administrator", 4700, avdeling1,null);
        Ansatt ansatt9 = new Ansatt("user9", "Olivia", "Anderson", new Date(2022, 11, 11), "HR Manager", 6000, avdeling1,null);
        Ansatt ansatt10 = new Ansatt("user10", "Daniel", "Lee", new Date(2022, 11, 11), "Software Engineer", 5200, avdeling2,null);
//
////        List<Ansatt> list = Arrays.asList(ansatt5,ansatt6,ansatt7,ansatt8);
//        
//       Avdeling  avdeling = avdelingDAO.finnAvdelingMedId(3);
//       ansatt10.setAvdeling(avdeling);
//       
//        ansattDAO.leggTilAnsatt(ansatt10);
////        avdelingDAO.leggTilAvdeling(avdeling1);
//        

//        Get ansatt by id
//        Ansatt ansatt = ansattDAO.finnAnsattMedId(13);
        
        
        Ansatt ansatt = ansattDAO.finnAnsattMedId(5);
        
        ansattDAO.fjernAnsatt(ansatt);
        
        
    
       
//        
//        System.out.println(jd.toString());
//        
//      ansattDAO.oppdaterAnsattAvdeling(jd, avdeling1);
        
        
//      Get avdeling  by id
//        Avdeling avdeling = avdelingDAO.finnAvdelingMedId(3);
//        
//        System.out.println(avdeling);
//        
//        avdelingDAO.oppdaterAvdelingSjef(avdeling, ansatt);

       
      
//      Ansatt j = ansattDAO.finnAnsattMedId(5);

    }
    
  
   
}
