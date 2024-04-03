package com.dat107.oblig3.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Prosjektdeltagelse")
public class Prosjektdeltagelse {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prosjektdeltagelse_id")
    private int prosjektdeltagelseId;
    
	@Column(name = "antall_timer")
    private int antallTimer;
    
    private String rolle;
    
    @ManyToOne()
    @JoinColumn(name = "ansatt_id")
    private Ansatt ansatt;
    
    @ManyToOne()
    @JoinColumn(name = "prosjekt_id")
    private Prosjekt prosjekt;

    
    

public Prosjektdeltagelse() {}
    
    public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt, int antallTimer, String rolle) {
        this.ansatt = ansatt;
        this.prosjekt = prosjekt;
        this.antallTimer = antallTimer;
        this.rolle = rolle;
        

    }

	public int getProsjektdeltagelseId() {
		return prosjektdeltagelseId;
	}

	public void setProsjektdeltagelseId(int prosjektdeltagelseId) {
		this.prosjektdeltagelseId = prosjektdeltagelseId;
	}

	public int getAntallTimer() {
		return antallTimer;
	}

	public void setAntallTimer(int antallTimer) {
		this.antallTimer = antallTimer;
	}

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public Ansatt getAnsatt() {
		return ansatt;
	}

	public void setAnsatt(Ansatt ansatt) {
		this.ansatt = ansatt;
	}

	public Prosjekt getProsjekt() {
		return prosjekt;
	}

	public void setProsjekt(Prosjekt prosjekt) {
		this.prosjekt = prosjekt;
	}

	@Override
	public String toString() {
		return "Prosjektdeltagelse [prosjektdeltagelseId=" + prosjektdeltagelseId + ", antallTimer=" + antallTimer
				+ ", rolle=" + rolle + ", ansatt=" + ansatt.getFornavn() + ", prosjekt=" + prosjekt.getNavn() + "]";
	}
    
}





