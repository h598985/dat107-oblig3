package com.dat107.oblig3.grensesnitt;

import java.util.Scanner;

import com.dat107.oblig3.dao.AnsattDAO;
import com.dat107.oblig3.dao.AvdelingDAO;
import com.dat107.oblig3.dao.ProsjektDAO;
import com.dat107.oblig3.dao.ProsjektDeltagelseDAO;

public class GrensesnittController {
	
	private Scanner scanner;
	
	private AnsattGrensesnitt ansattGrensesnitt;
	private AvdelingGrensesnitt avdelingGrensesnitt;
	private ProjsektGrensesnitt projsektGrensesnitt;
	
	private AvdelingDAO avdelingDAO;
	private ProsjektDAO prosjektDAO;
	private ProsjektDeltagelseDAO prosjektDeltagelseDAO;
	
	public GrensesnittController() {
		
		this.scanner = new Scanner(System.in);
		this.ansattGrensesnitt = new AnsattGrensesnitt();
		this.avdelingGrensesnitt = new AvdelingGrensesnitt();
		this.projsektGrensesnitt = new ProjsektGrensesnitt();
		
		this.avdelingDAO = new AvdelingDAO();
		this.prosjektDAO = new ProsjektDAO();
		this.prosjektDeltagelseDAO = new ProsjektDeltagelseDAO();
	}
	
	
	public void start() {
		
		System.out.println("\nKategorier");
		System.out.println("\n1. Ansatt");
		System.out.println("\n2. Avdeling");
		System.out.println("\n3. Prosjekt");
		 System.out.println("\n0. Avslutt programmet");
		
        int valg = scanner.nextInt();
        scanner.nextLine(); 
		
		 switch (valg) {
		 
         case 1:
        	 
				System.out.println("\nKategori: Ansatt");
				System.out.println("\n1. Søk etter ansatt med ID");
				System.out.println("\n2. Søk etter ansatt med BRUKERNAVN");
				System.out.println("\n3. List alle ansatte");
				System.out.println("\n4. Oppdater stilling til ansatt");
				System.out.println("\n5. Legg til ny ansatt");
				System.out.println("\n6. Fjern ansatt");
				
			    int ansattValg = scanner.nextInt();
           
             break;
             
         case 2:
        	 
				System.out.println("\nKategori: Avdeling");
				System.out.println("\n1. Søk etter avdeling med ID");
				System.out.println("\n2. List alle ansatte i avdeling");
				System.out.println("\n3. Oppdater avdeling til ansatt");
				System.out.println("\n4. Legg til ny avdeling");
				System.out.println("\n5. Fjern en avdeling");
			
				 int avdelingValg = scanner.nextInt();
            
             break;
             
         case 3:
        	 
     		System.out.println("\nKategori: Prosjekt");
    		System.out.println("\n1. Søk etter prosjekt med ID");
    		System.out.println("\n2. Legg til et nytt prosjekt");
    		System.out.println("\n3. List alle prosjekter");
    		System.out.println("\n4. List detaljert info om prosjekt");
    		System.out.println("\n5. Fjern prosjekt");
    		
//    		System.out.println("\n6. Legg til ansatt på prosjekt");
//    		System.out.println("\n7. Legg til timer for ansatt");
//    		System.out.println("\n8. Fjern ansatt fra prosjekt");
				
				 int prosjektValg = scanner.nextInt();
             
             break;
             
         case 0:
        	 
             System.out.println("Programmet avsluttes.");
             
             return;
             
         default:
        	 
        	 System.out.println("\nUgyldig valg, skriv noe for å prøv igjen.");
        	 
        	 valg = scanner.nextInt();
     }
		
		
	}
	
	public void ansattKategori(int valg) {
		
        switch (valg) {
        
        case 1:
        	
            ansattGrensesnitt.soekAnsattMedId();
            
            break;
            
        case 2:
        	
        	ansattGrensesnitt.soekAnsattMedBrukernavn();
           
            break;
            
        case 3:
            
        	ansattGrensesnitt.listAlleAnsatte();
        	
            break;
            
        case 4:
        	
        	ansattGrensesnitt.leggTilNyAnsatt();
            
            break;
            
        case 5:
        	
        	ansattGrensesnitt.fjernAnsatt();
            
            break;
            
		default:
			
			System.out.println("\nUgyldig valg, prøv igjen.");
			
			int nyValg = scanner.nextInt();
			
			ansattKategori(nyValg);
            
        }
	}
	
	
	public void avdelingKategori(int valg) {
		
		
        switch (valg) {
        
        case 1:
        	
        	avdelingGrensesnitt.soekAvdelingMedId();
            
            break;
            
        case 2:
        	
        	avdelingGrensesnitt.ListAllAvdeling();
           
            break;
            
        case 3:
            
        	avdelingGrensesnitt.oppdaterAvdelingTilAnsatt();
        	
            break;
            
        case 4:
        	
            ansattGrensesnitt.OppdaterStillingTilAnsatt();
            
            break;
            
        case 5:
        	
        	avdelingGrensesnitt.leggTilNyAvdeling();
            
            break;
            
        case 6:
            
        	avdelingGrensesnitt.FjernAvdeling();
        	
            break;
            
		default:
			
			System.out.println("\nUgyldig valg, prøv igjen.");
			
			int nyValg = scanner.nextInt();
			
			ansattKategori(nyValg);
            
        }
		
		
	}
	
	
	public void prosjektKategori(int valg) {
		
		
        switch (valg) {
        
        case 1:
        	
            projsektGrensesnitt.soekProsjektMedId();
            
            break;
            
        case 2:
        	
        	projsektGrensesnitt.leggTilNyttProsjekt();
           
            break;
            
        case 3:
            
        	projsektGrensesnitt.listAlleProsjekter();
        	
            break;
            
        case 4:
        	
           projsektGrensesnitt.skrivUtProsjektInformasjon();
            
            break;
            
        case 5:
        	
        	projsektGrensesnitt.fjernProsjekt();
            
            break;
            
        case 6:
            
        	projsektGrensesnitt.leggTilAnsattPaaProjsekt();
        	
            break;
            
		default:
			
			System.out.println("\nUgyldig valg, prøv igjen.");
			
			int nyValg = scanner.nextInt();
			
			ansattKategori(nyValg);
            
        }
	}

}
