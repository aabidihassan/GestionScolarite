package com.metier;

import java.util.ArrayList;
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
import com.Beans.Filiere;
import com.Beans.Login;
import com.Beans.Matiere;
import com.Beans.Module;
import com.Beans.Niveau;
import com.Beans.Reclamation;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

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
	public String classe(int idFiliere, int idNiveau) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Filiere filiere = em.find(Filiere.class, idFiliere);
		Niveau niv = em.find(Niveau.class, idNiveau);
		et.commit();
		return (niv.getNomNiveau()+" "+filiere.getNomFiliere());
	}
	public void deleteEtudiant(int id) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Etudiant etud = em.find(Etudiant.class, id);
		Query query = em.createQuery("SELECT l from Login l WHERE l.cne='"+etud.getCne()+"'") ;
		Login log = (Login) query.getResultList().get(0);
		em.remove(log);
		em.remove(etud);
		et.commit();
	}
	public Etudiant getEtudiant(int id) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Etudiant etud = em.find(Etudiant.class, id);
		et.commit();
		return etud;
	}
	public Login getLogin(String cne) {
		Query query = em.createQuery("SELECT l from Login l WHERE l.cne='"+cne+"'") ;
		return ((Login)query.getResultList().get(0));
	}
	public void modifyEtud(Etudiant etud, Login log) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Etudiant e = em.find(Etudiant.class, etud.getIdEtudiant());
		em.remove(e);
		Login l = em.find(Login.class, log.getIdLogin());
		em.remove(l);
		em.persist(etud);
		em.persist(log);
		et.commit();
	}
	public ArrayList<Absence> absence(int idModule, int idEtudiant){
		ArrayList<Absence> lst = new ArrayList<Absence>();
		List<Matiere> matieres = this.matieres(idModule);
		for(Matiere m : matieres) {
			Query query = em.createQuery("SELECT a from Absence a WHERE a.idMatiere='"+m.getIdMatiere()+"' AND a.idEtudiant='"+idEtudiant+"'");
			List<Absence> l = query.getResultList();
			for(Absence abs : l) {
				lst.add(abs);
			}
		}
		return lst;
	}
}
