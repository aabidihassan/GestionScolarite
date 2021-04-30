package com.Beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "demande")
public class Demande {
	@Id
	private int idDemande;
	private int idEtudiant;
	private int idType;
	private String date;
	private String description;
	private int idEtat;
	public Demande() {
		
	}
	public Demande(int idEtudiant, int idType, String description, String date) {
		this.date = date;
		this.description = description;
		this.idType = idType;
		this.idDemande = 0;
		this.idEtat = 1;
		this.idEtudiant = idEtudiant;
	}
	public int getIdDemande() {
		return idDemande;
	}
	public void setIdDemande(int idDemande) {
		this.idDemande = idDemande;
	}
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIdEtat() {
		return idEtat;
	}
	public void setIdEtat(int idEtat) {
		this.idEtat = idEtat;
	}
}
