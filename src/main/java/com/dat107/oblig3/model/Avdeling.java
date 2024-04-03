package com.dat107.oblig3.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="avdeling")

public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "avdeling_id")
	private Integer avdelingId;
	private String navn;
	
	@OneToOne()
	@JoinColumn(name = "sjef_id")
	private Ansatt sjef;
	
	@OneToMany(mappedBy = "avdeling")
	private List<Ansatt> ansatte;

	public Avdeling() {
	}

	public Avdeling(String navn, Ansatt sjef, List<Ansatt> ansatte) {
		super();
		this.navn = navn;
		this.sjef = sjef;
		this.ansatte = ansatte;
	}

	public Integer getAvdelingId() {
		return avdelingId;
	}

	public void setAvdelingId(Integer avdelingId) {
		this.avdelingId = avdelingId;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Ansatt getSjef() {
		return sjef;
	}

	public void setSjef(Ansatt sjef) {
		this.sjef = sjef;
	}

	public List<Ansatt> getAnsatte() {
		return ansatte;
	}

	public void setAnsatte(List<Ansatt> ansatte) {
		this.ansatte = ansatte;
	}

	@Override
	public String toString() {
		return "Avdeling [avdelingId=" + avdelingId + ", navn= " + navn + " ,sjef= "+ sjef.getFornavn() + "]";
	}

}




