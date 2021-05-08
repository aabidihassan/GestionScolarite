package com.Beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "absence")
public class Absence {
	@Id
	private int idAbsence;
	private int idEtudiant;
	private int idMatiere;
	private String dateAbsence;
	private int heure;
	public Absence(int idEtudiant, int idMatiere, String dateAbsence, int heure) {
		this.idEtudiant = idEtudiant;
		this.idMatiere = idMatiere;
		this.dateAbsence = dateAbsence;
		this.heure = heure;
	}
	public Absence() {
	}
	public int getIdAbsence() {
		return idAbsence;
	}
	public void setIdAbsence(int idAbsence) {
		this.idAbsence = idAbsence;
	}
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public int getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public String getDateAbsence() {
		return dateAbsence;
	}
	public void setDateAbsence(String dateAbsence) {
		this.dateAbsence = dateAbsence;
	}
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
}
