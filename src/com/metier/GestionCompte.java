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
import com.Beans.Filiere;
import com.Beans.Login;
import com.Beans.Matiere;
import com.Beans.Niveau;
import com.Beans.Reclamation;
import com.Beans.TypeDemande;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class GestionCompte {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public GestionCompte() {
		emf=Persistence.createEntityManagerFactory("Scolarite") ;
		em=emf.createEntityManager();
	}
	public boolean authontification(Login login) {
		Query query = em.createQuery("SELECT l from Login l where l.cne ='"+login.getCne()+"' AND l.password = '"+login.getPassword()+"' AND l.typeLogin='"+login.getTypeLogin()+"'") ;
		List<Login> lst= query.getResultList();
		if(!lst.isEmpty())
		login = lst.get(0);
		return !lst.isEmpty();
	}
	
	public Etudiant findEtudiant(String cne) {
		Query query = em.createQuery("SELECT e from Etudiant e where e.cne='"+cne+"'") ;
		List<Etudiant> lst = query.getResultList() ;
		return lst.get(0);
	}
	public Login findLogin(String cne) {
		Query query = em.createQuery("SELECT l from Login l where l.cne='"+cne+"'") ;
		List<Login> lst = query.getResultList() ;
		return lst.get(0);
	}
	public String classe(int idFiliere, int idNiveau) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Filiere filiere = em.find(Filiere.class, idFiliere);
		Niveau niv = em.find(Niveau.class, idNiveau);
		et.commit();
		return (niv.getNomNiveau()+" "+filiere.getNomFiliere());
	}
	public List<Demande> demandes(int idEtudiant){
		Query query = em.createQuery("SELECT d from Demande d where d.idEtudiant='"+idEtudiant+"'") ;
		List<Demande> lst = query.getResultList() ;
		return lst;
	}
	public void demande(Demande demande) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(demande);
		et.commit();
	}
	public String nomType(int id){
		Query query = em.createQuery("SELECT t from TypeDemande t where t.idType='"+id+"'") ;
		List<TypeDemande> lst = query.getResultList() ;
		return lst.get(0).getNomType();
	}
	public void reclamation(Reclamation rec) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(rec);
		et.commit();
	}
	public List<Reclamation> reclamations(int idEtudiant){
		Query query = em.createQuery("SELECT r from Reclamation r where r.idEtudiant='"+idEtudiant+"'") ;
		List<Reclamation> lst = query.getResultList() ;
		return lst;
	}
	public List<Annance> annances(int idFiliere, int idNiveau){
		Query query = em.createQuery("SELECT a from Annance a WHERE a.idFiliere='"+idFiliere+"' and a.idNiveau='"+idNiveau+"'") ;
		List<Annance> lst = query.getResultList();
		return lst;
	}
	public List<Absence> absences(int idEtudiant){
		Query query = em.createQuery("SELECT a from Absence a WHERE a.idEtudiant='"+idEtudiant+"'") ;
		List<Absence> lst = query.getResultList();
		return lst;
	}
	public String matiere(int idMatiere) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Matiere m = em.find(Matiere.class, idMatiere);
		et.commit();
		return m.getNomMatiere();
	}
	public void deleteDemande(int idDemande) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Demande dm = em.find(Demande.class, idDemande);
		em.remove(dm);
		et.commit();
	}
	public Demande getDemande(int idDemande) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Demande dm = em.find(Demande.class, idDemande);
		et.commit();
		return dm;
	}
	public void modifyDemande(Demande demande) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Demande dm = em.find(Demande.class, demande.getIdDemande());
		dm.setIdType(demande.getIdType());
		dm.setDescription(demande.getDescription());
		et.commit();
	}
	public void deleteReclamation(int idReclamation) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Reclamation dm = em.find(Reclamation.class, idReclamation);
		em.remove(dm);
		et.commit();
	}
	public Reclamation getReclamation(int idReclamation) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Reclamation dm = em.find(Reclamation.class, idReclamation);
		et.commit();
		return dm;
	}
	public void modifyReclamation(Reclamation reclamation) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Reclamation rc = em.find(Reclamation.class, reclamation.getIdReclamation());
		rc.setText(reclamation.getText());
		et.commit();
	}
}
