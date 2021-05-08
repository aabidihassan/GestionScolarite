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
	public boolean already(String cne, String cin) {
		Query query = em.createQuery("SELECT l from Etudiant l where l.cne ='"+cne+"' AND l.cin='"+cin+"'") ;
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
	public void change(Etudiant etudian, String password) {
		GestionCompte gc = new GestionCompte();
		EntityTransaction et = em.getTransaction();
		Login login = gc.findLogin(etudian.getCne());
		et.begin();
		Etudiant etud = em.find(Etudiant.class, etudian.getIdEtudiant());
		etud.setAdresse(etudian.getAdresse());
		etud.setEmail(etudian.getEmail());
		etud.setTelephone(etudian.getTelephone());
		etud.setIdFiliere(etudian.getIdFiliere());
		etud.setIdClasse(etudian.getIdClasse());
		Login lo = em.find(Login.class, login.getIdLogin());
		lo.setPassword(password);
		et.commit();
		etudian = em.find(Etudiant.class, etudian.getIdEtudiant());
	}
}
