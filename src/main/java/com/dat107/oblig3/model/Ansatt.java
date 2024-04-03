package com.dat107.oblig3.model;



import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ansatt")
public class Ansatt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ansatt_id")
    private Integer ansattId;

    private String brukernavn;

    private String fornavn;

    private String etternavn;

    private Date ansettelsesdato;

    private String stilling;

    private Integer maanedslonn;
    
    @ManyToOne()
    @JoinColumn(name = "avdeling_id")
    private Avdeling avdeling;
    
    @OneToMany(mappedBy = "ansatt")
    private List<Prosjektdeltagelse> prosjektdeltagelser;
   

    public Ansatt() {
		super();
	}




	public Ansatt( String brukernavn, String fornavn, String etternavn, Date ansettelsesdato,
			String stilling, Integer maanedslonn, Avdeling avdeling,List<Prosjektdeltagelse> prosjektdeltagelser) {
		super();
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelsesdato = ansettelsesdato;
		this.stilling = stilling;
		this.maanedslonn = maanedslonn;
		this.avdeling = avdeling;
		this.prosjektdeltagelser = prosjektdeltagelser;
	}




	public Integer getAnsattId() {
		return ansattId;
	}




	public void setAnsattId(Integer anstattId) {
		this.ansattId = anstattId;
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




	public Date getAnsettelsesdato() {
		return ansettelsesdato;
	}




	public void setAnsettelsesdato(Date ansettelsesdato) {
		this.ansettelsesdato = ansettelsesdato;
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




	public Avdeling getAvdeling() {
		return avdeling;
	}




	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}


	public List<Prosjektdeltagelse> getProsjektdeltagelser() {
		return prosjektdeltagelser;
	}




	public void setProsjektdeltagelser(List<Prosjektdeltagelse> prosjektdeltagelser) {
		this.prosjektdeltagelser = prosjektdeltagelser;
	}




	@Override
	public String toString() {
		return "Ansatt [anstattId=" + ansattId + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", ansettelsesdato=" + ansettelsesdato + ", stilling=" + stilling + ", maanedslonn="
				+ maanedslonn +  "]";
	}
    

}