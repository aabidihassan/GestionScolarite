package com.metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Beans.Etudiant;
import com.Beans.Login;

public class GestionInscription {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public GestionInscription() {
		emf=Persistence.createEntityManagerFactory("Scolarite") ;
		em=emf.createEntityManager();
	}
	public boolean already(String cne) {
		Query query = em.createQuery("SELECT l from Etudiant l where l.cne ='"+cne+"' ") ;
		List<Etudiant> lst= query.getResultList();
		return !lst.isEmpty();
	}
	public void insert(Etudiant etudiant, Login login) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(etudiant);
		em.persist(login);
		et.commit();
		Query query = em.createQuery("SELECT l from Etudiant l where l.cne ='"+login.getCne()+"' ") ;
		List<Etudiant> lst= query.getResultList();
		etudiant = lst.get(0);
		
	}
}
