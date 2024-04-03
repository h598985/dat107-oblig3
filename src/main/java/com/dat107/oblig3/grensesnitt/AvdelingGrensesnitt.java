package com.dat107.oblig3.grensesnitt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dat107.oblig3.dao.AnsattDAO;
import com.dat107.oblig3.dao.AvdelingDAO;
import com.dat107.oblig3.model.Ansatt;
import com.dat107.oblig3.model.Avdeling;

public class AvdelingGrensesnitt {
	
	private Scanner scanner;
	private AvdelingDAO avdelingDAO;
	private AnsattDAO ansattDAO;

	public AvdelingGrensesnitt() {
	
		this.scanner = new Scanner(System.in);
		this.avdelingDAO = new AvdelingDAO();
		this.ansattDAO = new AnsattDAO();
	}
	
	public void soekAvdelingMedId() {
		
		 System.out.print("Skriv inn avdeling-id: ");
		 
	        int id = scanner.nextInt();
	        
	        Avdeling avdeling = avdelingDAO.finnAvdelingMedId(id);
	        
	        if (avdeling != null) {
	        	
	            System.out.println("Avdeling funnet:");
	            
	            System.out.println(avdeling);
	            
	        } else {
	        	
	            System.out.println("Ingen avdeling med gitt id ble funnet.");
	        }
		
	}
	
	public void ListAlleAnssatteIAvdeling() {
		
		System.out.println("\nAvdelinger:\n");
		List<Avdeling> avd = avdelingDAO.henteAlleAvdeling();

		for (Avdeling av : avd) {
			System.out.println(av);
		}
		
		System.out.println("\nVelg avdeling du vil se ansatte (ID): \n");
		
		int id = scanner.nextInt();
		
		Avdeling avdNy = avdelingDAO.finnAvdelingMedId(id);
		
		if (avdNy == null) {
			
			System.out.println("Ugyldig ID. ");
			
			return;
		}
		
		List<Ansatt> ansatte = avdelingDAO.listAlleAnsatteIAvdeling(avdNy);
		
		for(Ansatt a: ansatte) { 
			
			System.out.println("\n" + a);
		}
		
	}
	
	public void ListAllAvdeling() {
		
		System.out.println("Liste over alle avdelinger:");
		
		List<Avdeling> avdelinger = avdelingDAO.henteAlleAvdeling();
		
        for (Avdeling avdeling : avdelinger) {
        	
            System.out.println("\n" + avdeling);
        }
	}
	
	
	
	public void oppdaterAvdelingTilAnsatt(){
		
		System.out.println("\nOppdater avdeling til ansatt med BRUKERNAVN = \n");
		
		String brukernavn = scanner.nextLine();
		
		Ansatt ansatt = ansattDAO.finnAnsattMedBrukernavn(brukernavn);
		
		if (ansatt == null) {
			
			System.out.println("\nAnsatt med gitt brukernavn eksisterer ikke ");
			
			return;
			
		}
		
		System.out.println("\nNåværende avdeling til gitt ansatt er " + ansatt.getAvdeling().getNavn());
		
		
		System.out.println("\nTilgjengelige avdelinger: \n");
		
		List<Avdeling> avd2 = avdelingDAO.henteAlleAvdeling();
		
		for (Avdeling av : avd2) {
			
			System.out.println(av);
		}
		
		
		System.out.println("\nSkriv inn ny avdeling (med ID): ");
		
		int id = scanner.nextInt();
		
		Avdeling nyAvdeling = avdelingDAO.finnAvdelingMedId(id);
		
		if (nyAvdeling == null) {
			
			System.out.println("\nNy avdeling med gitt id eksisterer ikke ");
			
			return;
			
		}
		
		
		ansattDAO.oppdaterAnsattAvdeling(ansatt, nyAvdeling);
		
		
	}
	
	public void leggTilNyAvdeling() {
		
		  System.out.println("Legg til ny avdeling:");
		  
	        System.out.print("Navn: ");
	        
	        String navn = scanner.nextLine();
	        
	        System.out.print("Skriv inn sjefens ansatt-id: ");
	        
	        int sjefId = scanner.nextInt();
	        scanner.nextLine(); 

	        Ansatt sjef = ansattDAO.finnAnsattMedId(sjefId);
	        
	        if (sjef != null) {
	        	
	            Avdeling nyAvdeling = new Avdeling(navn, sjef, new ArrayList<>());
	            
	            avdelingDAO.leggTilNyAvdeling(nyAvdeling, sjef);
	            
	            System.out.println("Ny avdeling lagt til.");
	            
	        } else {
	        	
	            System.out.println("Ugyldig ansatt-ID. Avdeling kunne ikke legges til.");
	        }
	}
	
	
	public void FjernAvdeling() {
		
		System.out.println("\nAvdelinger: \n");
		
		List<Avdeling> list_avd = avdelingDAO.henteAlleAvdeling();
		
		for (Avdeling av : list_avd) {
			
			System.out.println(av);
		}
		
		
		System.out.println("\nSkriv inn avdeling å fjerne (med ID): ");	
		
		int id = scanner.nextInt();
		
		Avdeling nyAvdeling = avdelingDAO.finnAvdelingMedId(id);
		
		if (nyAvdeling == null) {
			
			System.out.println("\nNy avdeling med gitt id eksisterer ikke ");
			
			return;
			
		}
		
		if (nyAvdeling.getSjef() != null ) {
			
			System.out.println("\nKan ikke slette en avdeling med ansatte.");
			
			return;
		}
		
		
		
		avdelingDAO.fjernAvdeling(nyAvdeling);
		
		System.out.println("\nAvdeling fjernet vellykket.");
		
	}
}
