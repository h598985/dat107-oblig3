package com.dat107.oblig3.grensesnitt;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.dat107.oblig3.dao.AnsattDAO;
import com.dat107.oblig3.dao.AvdelingDAO;
import com.dat107.oblig3.model.Ansatt;
import com.dat107.oblig3.model.Avdeling;

public class AnsattGrensesnitt {
	
	private Scanner scanner;
	private AnsattDAO ansattDAO;
	private AvdelingDAO avdelingDAO;
	
	public AnsattGrensesnitt() {
		this.scanner = new Scanner(System.in);
		this.ansattDAO = new AnsattDAO();
		this.avdelingDAO = new AvdelingDAO();
	}
	
    public void soekAnsattMedId() {
    	
        System.out.print("Skriv inn ansatt-id: ");
        
        int id = scanner.nextInt();
        
        System.out.println(id);
        
        Ansatt ansatt = ansattDAO.finnAnsattMedId(id);
        
        if (ansatt != null) {
        	
            System.out.println("Ansatt funnet:");
            
            System.out.println(ansatt);
            
        } else {
        	
            System.out.println("Ingen ansatt med gitt id ble funnet.");
        }
    }
    
    
    public void soekAnsattMedBrukernavn() {
    	
        System.out.print("Skriv inn brukernavn: ");
        
        String username = scanner.nextLine();
        
        Ansatt ansatt = ansattDAO.finnAnsattMedBrukernavn(username);
        
        if (ansatt != null) {
        	
            System.out.println("Ansatt funnet:");
            
            System.out.println(ansatt);
            
        } else {
        	
            System.out.println("Ingen ansatt med gitt brukernavn ble funnet.");
        }
    }
    
    
    public void listAlleAnsatte() {
    	
    	System.out.println("Liste over alle ansatte:");
    	
        for (Ansatt ansatt : ansattDAO.hentAlleAnsatte()) {
        	
            System.out.println(ansatt);
        }
	}
    
    
    public void OppdaterStillingTilAnsatt() {
    	
    
    	
        System.out.print("Skriv inn ansatt-id: ");
        
        int id = scanner.nextInt();
        
        scanner.nextLine(); // Consume newline

        Ansatt ansatt = ansattDAO.finnAnsattMedId(id);
        
        if (ansatt != null) {
        	
            System.out.println("Oppdater stilling for ansatt: ");
            
            System.out.print("Ny stilling: ");
            
            String stilling = scanner.nextLine();
            
            
            ansattDAO.oppdaterAnsattStilling(ansatt, stilling);
            
            
            System.out.println("Ansatt oppdatert.");
            
        } else {
        	
            System.out.println("Ingen ansatt med gitt id ble funnet.");
        }
    	
    	
		
	}
    
    public void leggTilNyAnsatt() {
    	
        System.out.println("Legg til ny ansatt:");
        
        System.out.print("Brukernavn: ");
        
        String brukernavn = scanner.nextLine();
        
        System.out.print("Fornavn: ");
        
        String fornavn = scanner.nextLine();
        
        System.out.print("Etternavn: ");
        
        String etternavn = scanner.nextLine();
        		
        System.out.print("Stilling: ");
        
        String stilling = scanner.nextLine();
        
        System.out.print("Maanedsloenn: ");
        
        int loenn = (int) scanner.nextDouble();
        scanner.nextLine(); 
        
		System.out.println("\nTilgjengelige avdelinger: ");
		
		List<Avdeling> avd2 = avdelingDAO.henteAlleAvdeling();
		
		for (Avdeling av : avd2) {
			
			System.out.println("\n" + av);
		}

        System.out.print("Angi avdelings-ID: ");
        
        int avdelingId = scanner.nextInt();
        scanner.nextLine(); 

        Avdeling avdeling = avdelingDAO.finnAvdelingMedId(avdelingId);
        
        if (avdeling != null) {
        	
            Ansatt nyAnsatt = new Ansatt(brukernavn,fornavn, etternavn,LocalDate.now(),stilling,loenn,avdeling,null);
            
            ansattDAO.leggTilAnsatt(nyAnsatt);
            
            System.out.println("Ny ansatt lagt til.");
            
        } else {
        	
            System.out.println("Ugyldig avdelings-ID. Ansatt kunne ikke legges til.");
        }
		
	}
    
    
    public void fjernAnsatt() {
    	
		System.out.println("\nFjern ansatt\n");
		
		List<Ansatt> ansattListe = ansattDAO.hentAlleAnsatte();
		
		for (Ansatt ansatt : ansattListe) {
			
			System.out.println(ansatt);
		}
		
		System.out.println("\nVelg ansatt du vil fjerne (med ID): ");
		
		int id = scanner.nextInt();
		
		Ansatt ansattFjern = ansattDAO.finnAnsattMedId(id);
		
		List<Avdeling> avdelingListe = avdelingDAO.henteAlleAvdeling();
		
		boolean funnet = false;
		
		for(Avdeling avd : avdelingListe) {
			
			if(avd.getSjef().getAnsattId() == ansattFjern.getAnsattId()) {
				
				funnet = true;
			}
		}
		
		if(funnet) {
			
			System.out.println("\nKan ikke fjerne ansatt som er sjef.");
			
			return;
		}
		
		ansattDAO.fjernAnsatt(ansattFjern);
		
		System.out.println("\nAnsatt fjernet vellykket.");
    	
    }


}
