package com.metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Beans.Etudiant;
import com.Beans.Login;

public class GestionCompte {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public GestionCompte() {
		emf=Persistence.createEntityManagerFactory("Scolarite") ;
		em=emf.createEntityManager();
	}
	public boolean authontification(Login login) {
		Query query = em.createQuery("SELECT l from Login l where l.cne ='"+login.getCne()+"' AND l.password = '"+login.getPassword()+"'") ;
		List<Login> lst= query.getResultList();
		login = lst.get(0);
		return !lst.isEmpty();
	}
	
	public Etudiant findEtudiant(String cne) {
		Query query = em.createQuery("SELECT e from Etudiant e where e.cne='"+cne+"'") ;
		List<Etudiant> lst = query.getResultList() ;
		return lst.get(0);
	}
}
