package com.dat107.oblig3.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avdeling")

public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdId;
	private String navn;
	private int sjef;

	public Avdeling() {
	}

	public Avdeling(String navn, int sjef) {
		this.navn = navn;
		this.sjef = sjef;
	}

	public int getAvdelingId() {
		return avdId;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getSjef() {
		return sjef;
	}

	public void setSjef(int sjef) {
		this.sjef = sjef;
	}

	@Override
	public String toString() {
		return "Avdeling [avdId=" + avdId + ", navn=" + navn + ", sjef=" + sjef + "]";
	}

}




