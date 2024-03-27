package com.dat107.oblig3.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="avdeling")

public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelingId;
	private String navn;
	@OneToMany()
	private List<Ansatt> ansatte;

	private Ansatt sjef;

	public Avdeling() {
	}

	public Avdeling(String navn) {
		this.navn = navn;
	}

	
	public List<Ansatt> getAnsatte() {
		return ansatte;
	}
	
	public void setAnsatte(List<Ansatt> ansatte) {
		this.ansatte = ansatte;
	}
	
	public int getAvdelingId() {
		return avdelingId;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Ansatt getSjef() {
		return this.sjef;
	}
	public void setSjef(Ansatt sjef) {
		this.sjef = sjef;
	}

	@Override
	public String toString() {
		return "Avdeling [avdId=" + avdelingId + ", navn=" + navn + "]";
	}

}




