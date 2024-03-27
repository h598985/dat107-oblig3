package com.dat107.oblig3.model;



import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ansatt")
public class Ansatt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer anstattId;

    private String brukernavn;

    private String fornavn;

    private String etternavn;

    private Date ansettelsesdato;

    private String stilling;

    private Integer maanedslonn;
    
    
   

    public Ansatt() {
		super();
	}
    
    
    

	public Ansatt(Integer anstattId, String brukernavn, String fornavn, String etternavn, Date ansattelsesdato,
			String stilling, Integer maanedslonn) {
		super();
		this.anstattId = anstattId;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelsesdato = ansattelsesdato;
		this.stilling = stilling;
		this.maanedslonn = maanedslonn;
	}

	


	public Integer getAnstattId() {
		return anstattId;
	}




	public void setAnstattId(Integer anstattId) {
		this.anstattId = anstattId;
	}




	public String getBrukernavn() {
		return brukernavn;
	}




	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}




	public String getFornavn() {
		return fornavn;
	}




	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}




	public String getEtternavn() {
		return etternavn;
	}




	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}




	public Date getAnsattelsesdato() {
		return ansettelsesdato;
	}




	public void setAnsattelsesdato(Date ansattelsesdato) {
		this.ansettelsesdato = ansattelsesdato;
	}




	public String getStilling() {
		return stilling;
	}




	public void setStilling(String stilling) {
		this.stilling = stilling;
	}




	public Integer getMaanedslonn() {
		return maanedslonn;
	}




	public void setMaanedslonn(Integer maanedslonn) {
		this.maanedslonn = maanedslonn;
	}




	@Override
	public String toString() {
		return "Ansatt [ansId=" + anstattId + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", ansattelsesdato=" + ansettelsesdato + ", stilling=" + stilling + ", maanedslonn="
				+ maanedslonn + "]";
	}
    
    
    
}