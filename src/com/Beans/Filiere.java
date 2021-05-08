package com.Beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filiere")
public class Filiere {
	@Id
	private int idFiliere;
	private String nomFiliere;
	public Filiere(int idFiliere, String nomFiliere) {
		this.idFiliere = idFiliere;
		this.nomFiliere = nomFiliere;
	}
	public Filiere() {
		
	}
	public int getIdFiliere() {
		return idFiliere;
	}
	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}
	public String getNomFiliere() {
		return nomFiliere;
	}
	public void setNomFiliere(String nomFiliere) {
		this.nomFiliere = nomFiliere;
	}
	
}
