package com.metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Beans.Absence;
import com.Beans.Annance;
import com.Beans.Demande;
import com.Beans.Etudiant;
import com.Beans.Matiere;
import com.Beans.Module;
import com.Beans.Reclamation;

public class GestionAdmin {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public GestionAdmin() {
		emf=Persistence.createEntityManagerFactory("Scolarite") ;
		em=emf.createEntityManager();
	}
	public void annance(Annance annance) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(annance);
		et.commit();
	}
	public List<Annance> annances(){
		Query query = em.createQuery("SELECT a from Annance a") ;
		List<Annance> lst = query.getResultList();
		return lst;
	}
	public List<Reclamation> reclamations(){
		Query query = em.createQuery("SELECT r from Reclamation r") ;
		List<Reclamation> lst = query.getResultList() ;
		return lst;
	}
	public List<Etudiant> etudiants(int idFiliere, int idNiveau){
		Query query = em.createQuery("SELECT e from Etudiant e WHERE e.idFiliere='"+idFiliere+"' AND e.idClasse='"+idNiveau+"'") ;
		List<Etudiant> lst = query.getResultList() ;
		return lst;
	}
	public List<Module> modules(int idFiliere, int idNiveau){
		Query query = em.createQuery("SELECT m from Module m WHERE m.idFiliere='"+idFiliere+"' AND m.idNiveau='"+idNiveau+"'") ;
		List<Module> lst = query.getResultList() ;
		return lst;
	}
	public List<Matiere> matieres(int idModule){
		Query query = em.createQuery("SELECT m from Matiere m WHERE m.idModule='"+idModule+"'") ;
		List<Matiere> lst = query.getResultList() ;
		return lst;
	}
	public void absence(Absence absence) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(absence);
		et.commit();
	}
	public List<Demande> demandes(int id){
		Query query = em.createQuery("SELECT d from Demande d WHERE d.idType='"+id+"'") ;
		List<Demande> lst = query.getResultList() ;
		return lst;
	}
	public String nomEtudiant(int id) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Etudiant e = em.find(Etudiant.class, id);
		et.commit();
		return e.getNom()+" "+e.getPrenom();
	}
	public void accepter(int id, String etat) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Demande d = em.find(Demande.class, id);
		d.setEtat(etat);
		et.commit();
	}
	public void deleteDemande(int id) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Demande d = em.find(Demande.class, id);
		em.remove(d);
		et.commit();
	}
}
