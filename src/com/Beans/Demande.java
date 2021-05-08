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
	private String dateDemande;
	private String description;
	private String etat;
	public Demande() {
		
	}
	public Demande(int idEtudiant, int idType, String description, String dateDemande) {
		this.dateDemande = dateDemande;
		this.description = description;
		this.idType = idType;
		this.idDemande = 0;
		this.etat = "En attent";
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
	public String getDateDemande() {
		return dateDemande;
	}
	public void setDateDemande(String dateDemande) {
		this.dateDemande = dateDemande;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
}
