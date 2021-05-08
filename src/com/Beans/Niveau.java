package com.Beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "niveau")
public class Niveau {
	@Id
	private int idNiveau;
	private String nomNiveau;
	public Niveau() {
	}
	public int getIdNiveau() {
		return idNiveau;
	}
	public void setIdNiveau(int idNiveau) {
		this.idNiveau = idNiveau;
	}
	public String getNomNiveau() {
		return nomNiveau;
	}
	public void setNomNiveau(String nomNiveau) {
		this.nomNiveau = nomNiveau;
	}
}
