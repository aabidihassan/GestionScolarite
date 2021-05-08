package com.Beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	@Id
	private int idLogin;
	private String cne;
	private String password;
	private int typeLogin;
	public Login() {
		
	}
	public Login(String cne, String password) {	
		this.cne = cne;
		this.password = password;
		this.typeLogin = 1;
	}
	
	public int getTypeLogin() {
		return typeLogin;
	}
	public void setTypeLogin(int typeLogin) {
		this.typeLogin = typeLogin;
	}
	public int getIdLogin() {
		return idLogin;
	}
	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
