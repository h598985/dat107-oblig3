package com.dat107.oblig3.grensesnitt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dat107.oblig3.dao.AnsattDAO;
import com.dat107.oblig3.dao.AvdelingDAO;
import com.dat107.oblig3.dao.ProsjektDAO;
import com.dat107.oblig3.model.Ansatt;
import com.dat107.oblig3.model.Prosjekt;
import com.dat107.oblig3.model.Prosjektdeltagelse;

public class ProjsektGrensesnitt {
	
	private Scanner scanner;
	private ProsjektDAO prosjektDAO;
	private AnsattDAO ansattDAO;
	
	public ProjsektGrensesnitt() {
		
		this.scanner = new Scanner(System.in);
		this.prosjektDAO = new ProsjektDAO();
		 
	}
	
	
	public void soekProsjektMedId() {
		
		System.out.println("\nSkriv inn prosjekt-ID: ");
		
		int id = scanner.nextInt();
		
		Prosjekt prosjekt = prosjektDAO.finnProsjektMedId(id);
		
		if (prosjekt == null) {
			
			System.out.println("Prosjekt med gitt id eksisterer ikke");
			
			return;
		}
		
		System.out.println(prosjekt);
		
	}
	
	public void leggTilNyttProsjekt() {
		
        System.out.println("Legg til nytt prosjekt:");
        
        System.out.print("Prosjektnavn: ");
        
        String prosjektnavn = scanner.nextLine();
        
        System.out.print("Beskrivelse: ");
        
        String beskrivelse = scanner.nextLine();

        Prosjekt prosjekt = new Prosjekt(prosjektnavn, beskrivelse,new ArrayList<>());
        
        prosjektDAO.leggTilProsjekt(prosjekt);
        
        System.out.println("Nytt prosjekt lagt til.");
		
	}
	
	
	public void listAlleProsjekter() {
		
		List<Prosjekt> prosjekter = prosjektDAO.hentAlleProsjekter();
		
		if (prosjekter.isEmpty()) {
			
			System.out.println("Det finnes ingen prosjekt i databasen");
			
			return;
		}
		
		System.out.println("\nAlle prosjekter: \n");
		
		for (Prosjekt pr: prosjekter) {
			
			System.out.println(pr);
		}
	}
	
	public void leggTilAnsattPaaProjsekt() {
		
        System.out.print("Skriv inn ansatt-id: ");
        
        int ansattId = scanner.nextInt();
        scanner.nextLine();

        Ansatt ansatt = ansattDAO.finnAnsattMedId(ansattId);
        
        if (ansatt == null) {
        	
            System.out.println("Ingen ansatt med gitt id ble funnet.");
            
            return;
        }

        System.out.print("Skriv inn prosjekt-id: ");
        
        int prosjektId = scanner.nextInt();
        
        scanner.nextLine();

        Prosjekt prosjekt = prosjektDAO.finnProsjektMedId(prosjektId);
        
        if (prosjekt == null) {
        	
            System.out.println("Ingen prosjekt med gitt id ble funnet.");
            
            return;
        }

        System.out.print("Rolle i prosjektet: ");
        
        String rolle = scanner.nextLine();
        
        Prosjektdeltagelse prosjektdeltagelse = new Prosjektdeltagelse();
        
        prosjektdeltagelse.setAnsatt(ansatt);
        prosjektdeltagelse.setAntallTimer(0);
        prosjektdeltagelse.setProsjekt(prosjekt);
        prosjektdeltagelse.setRolle(rolle);

        List<Prosjektdeltagelse> prosjektdeltagelser = prosjekt.getProsjektdeltagelser();
        
        prosjektdeltagelser.add(prosjektdeltagelse);
        
        prosjektDAO.oppdaterProsjekt(prosjekt);
        
        System.out.println("Deltagelse registrert.");
		
	}
	
	public void skrivUtProsjektInformasjon() {
		
		System.out.print("Skriv inn prosjekt-id: ");
        int prosjektId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Prosjekt prosjekt = prosjektDAO.finnProsjektMedId(prosjektId);
        
        if (prosjekt != null) {
        	
            System.out.println("Prosjektinformasjon:");
            
            System.out.println("Prosjektnavn: " + prosjekt.getNavn());
            
            System.out.println("Beskrivelse: " + prosjekt.getBeskrivelse());
            
            System.out.println("Deltagere:");
            
            for (Prosjektdeltagelse deltakelse : prosjekt.getProsjektdeltagelser()) {
                System.out.println("  Ansatt ID: " + deltakelse.getAnsatt().getAnsattId());
                System.out.println("  Navn: " + deltakelse.getAnsatt().getFornavn() + " " + deltakelse.getAnsatt().getEtternavn());
                System.out.println("  Rolle: " + deltakelse.getRolle());
                System.out.println("  Antall timer: " + deltakelse.getAntallTimer());
            }
            
//            System.out.println("Totalt timetall for prosjektet: " + prosjekt.getTotalTimer());
            
        } else {
        	
            System.out.println("Ingen prosjekt med gitt id ble funnet.");
        }
		
	}


	public void fjernProsjekt() {
		
		System.out.println("\nFjern prosjekt\n");
		
		List<Prosjekt> prosjekter = prosjektDAO.hentAlleProsjekter();
		
		if (prosjekter.isEmpty()) {
			
			System.out.println("\nDet finnes ingen prosjekt i databasen.");
		}
		
		System.out.println("Følgende prosjekt eksisterer: \n");
		
		for (Prosjekt prosjekt : prosjekter) {
			
			System.out.println(prosjekt);
		}
		
		System.out.println("\nVelg prosjekt du vil fjerne (med ID): ");
		
		int id = scanner.nextInt();
		
		Prosjekt fjernProsjekt = prosjektDAO.finnProsjektMedId(id);
		
		if (fjernProsjekt == null) {
			
			System.out.println("\nProsjekt med gitt id eksister i databasen");
			
			
			return;
		}
		
		
		if (fjernProsjekt.getProsjektdeltagelser().size() != 0 ) {
			
			System.out.println("\nKan ikke fjerne ettersom det er ansatte tilknyttet prosjektet.");
			
			return;
		}
		
		
		prosjektDAO.fjernProsjekt(fjernProsjekt);
		
		System.out.println("\nProsjekt fjernet vellykket.");
		
	}




}
