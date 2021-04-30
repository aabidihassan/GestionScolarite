package com.Beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reclamation")
public class Reclamation {
	@Id
	private int idReclamation;
	private String text;
	private int idEtudiant;
	private String dateReclamation;
	public Reclamation() {
		
	}
	public int getIdReclamation() {
		return idReclamation;
	}
	public void setIdReclamation(int idReclamation) {
		this.idReclamation = idReclamation;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getDateReclamation() {
		return dateReclamation;
	}
	public void setDateReclamation(String dateReclamation) {
		this.dateReclamation = dateReclamation;
	}
}
