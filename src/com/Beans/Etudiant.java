package com.Beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etudiant")
public class Etudiant {
	@Id
	private int idEtudiant;
	private String nom;
	private String prenom;
	private String cne;
	private String cin;
	private String email;
	private String telephone;
	private String anneeBac;
	private String photo;
	private String adresse;
	private String dateNai;
	private String optionBac;
	private String mention;
	private int idClasse;
	private int idFiliere;
	public int getIdFiliere() {
		return idFiliere;
	}
	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}
	public Etudiant(String nom, String prenom, String cne, String cin, String email, String telephone,
			String anneeBac, String photo, String adresse, String dateNai, String optionBac, String mention, int idFiliere,
			int idClasse) {
		this.idEtudiant = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.cne = cne;
		this.cin = cin;
		this.email = email;
		this.telephone = telephone;
		this.anneeBac = anneeBac;
		this.photo = photo;
		this.adresse = adresse;
		this.dateNai = dateNai;
		this.optionBac = optionBac;
		this.mention = mention;
		this.idClasse = idClasse;
		this.idFiliere = idFiliere;
	}
	public Etudiant(String nom, String prenom, String cne, String cin, String email, String telephone,
			String anneeBac, String adresse, String dateNai, String optionBac, String mention, int idFiliere,
			int idClasse) {
		this.idEtudiant = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.cne = cne;
		this.cin = cin;
		this.email = email;
		this.telephone = telephone;
		this.anneeBac = anneeBac;
		this.adresse = adresse;
		this.dateNai = dateNai;
		this.optionBac = optionBac;
		this.mention = mention;
		this.idClasse = idClasse;
		this.idFiliere = idFiliere;
	}
	public int getIdClasse() {
		return idClasse;
	}
	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDateNai() {
		return dateNai;
	}
	public void setDateNai(String dateNai) {
		this.dateNai = dateNai;
	}
	public String getOptionBac() {
		return optionBac;
	}
	public void setOptionBac(String optionBac) {
		this.optionBac = optionBac;
	}
	public String getMention() {
		return mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}
	public Etudiant() {
		
	}
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAnneeBac() {
		return anneeBac;
	}
	public void setAnneeBac(String anneBac) {
		this.anneeBac = anneBac;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
