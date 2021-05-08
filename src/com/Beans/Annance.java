package com.Beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "annance")
public class Annance {
	@Id
	private int IdAnnance;
	private String textAnnance;
	private String dateAnnance;
	private int idFiliere;
	private int idNiveau;
	
	public Annance() {
		
	}

	public Annance(String textAnnance, int idFiliere, int idNiveau) {
		this.IdAnnance = 0;
		this.textAnnance = textAnnance;
		this.dateAnnance = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		this.idFiliere = idFiliere;
		this.idNiveau = idNiveau;
	}

	public int getIdAnnance() {
		return IdAnnance;
	}

	public void setIdAnnance(int idAnnance) {
		IdAnnance = idAnnance;
	}

	public String getTextAnnance() {
		return textAnnance;
	}

	public void setTextAnnance(String textAnnance) {
		this.textAnnance = textAnnance;
	}

	public String getDateAnnance() {
		return dateAnnance;
	}

	public void setDateAnnance(String dateAnnance) {
		this.dateAnnance = dateAnnance;
	}

	public int getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}

	public int getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(int idNiveau) {
		this.idNiveau = idNiveau;
	}
	
	
}
