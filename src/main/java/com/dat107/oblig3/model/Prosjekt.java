package com.dat107.oblig3.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "prosjekt")
public class Prosjekt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prosjekt_id")
    private int prosjektId;
    private String navn;
    private String beskrivelse;
    
    @OneToMany(mappedBy = "prosjekt")
    private List<Prosjektdeltagelse> prosjektdeltagelser;
    
    
    public Prosjekt() {
    	
    }
    
    public Prosjekt(String navn, String beskrivelse, List<Prosjektdeltagelse> prosjektdeltagelser) {
    	
    	this.navn = navn;
    	this.beskrivelse = beskrivelse;
    	this.prosjektdeltagelser = prosjektdeltagelser;   	
    }

	public int getProsjektId() {
		return prosjektId;
	}

	public void setProsjektId(int prosjektId) {
		this.prosjektId = prosjektId;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public List<Prosjektdeltagelse> getProsjektdeltagelser() {
		return prosjektdeltagelser;
	}

	public void setProsjektdeltagelser(List<Prosjektdeltagelse> prosjektdeltagelser) {
		this.prosjektdeltagelser = prosjektdeltagelser;
	}

	@Override
	public String toString() {
		return "Prosjekt [prosjektId=" + prosjektId + ", navn=" + navn + ", beskrivelse=" + beskrivelse + "]";
	}
   
}
