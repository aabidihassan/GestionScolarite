package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Beans.Absence;
import com.Beans.Annance;
import com.Beans.Etudiant;
import com.Beans.Login;
import com.Beans.Module;
import com.metier.GestionAdmin;
import com.metier.GestionCompte;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("admin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionCompte gc = new GestionCompte();
		GestionAdmin ga = new GestionAdmin();
		HttpSession session = request.getSession();
		if(request.getParameter("log")!=null) {
			Login login = new Login(request.getParameter("login"), request.getParameter("pass"));
			login.setTypeLogin(2);
			if(gc.authontification(login)) {
				response.sendRedirect("admin/reclamations.jsp");
			}
			else {
				response.sendRedirect("admin");
			}
		}
		
		else if(request.getParameter("annance")!=null) {
			Annance annance = new Annance(request.getParameter("texte"), Integer.parseInt(request.getParameter("filiere")),
					Integer.parseInt(request.getParameter("niveau")));
			ga.annance(annance);
			response.sendRedirect("admin/annances.jsp");
		}
		
		else if(request.getParameter("step1")!=null) {
			List<Etudiant> lst = ga.etudiants(Integer.parseInt(request.getParameter("filiere")), Integer.parseInt(request.getParameter("niveau")));
			session.setAttribute("etudiants", lst);
			List<Module> list = ga.modules(Integer.parseInt(request.getParameter("filiere")), Integer.parseInt(request.getParameter("niveau")));
			session.setAttribute("modules", list);
			session.setAttribute("pos", "step1");
			response.sendRedirect("admin/absence.jsp");
			//request.getRequestDispatcher("admin/absence.jsp").forward(request, response);
		}
		
		else if(request.getParameter("step2")!=null) {
			session.setAttribute("idEtudiant", Integer.parseInt(request.getParameter("etudiant")));
			session.setAttribute("list", ga.matieres(Integer.parseInt(request.getParameter("module"))));
			session.setAttribute("pos", "step2");
			response.sendRedirect("admin/absence.jsp");
		}
		
		else if(request.getParameter("step3")!=null) {
			String[] lst = request.getParameterValues("check_list");
				Absence absence = new Absence((int) session.getAttribute("idEtudiant"), Integer.parseInt(request.getParameter("matiere")),
						request.getParameter("date"), lst.length*2);
				ga.absence(absence);
			
			response.sendRedirect("admin/absences.jsp");
		}
		
		else if(request.getParameter("accepter")!=null) {
			ga.accepter(Integer.parseInt(request.getParameter("id")), "Accepter");
			response.sendRedirect("admin/demandes.jsp");
		}
		
		else if(request.getParameter("rejeter")!=null) {
			ga.accepter(Integer.parseInt(request.getParameter("id")), "Rejeter");
			response.sendRedirect("admin/demandes.jsp");
		}
		
		else if(request.getParameter("supprimer")!=null) {
			ga.deleteDemande(Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("admin/demandes.jsp");
		}
		
		else if(request.getParameter("search")!=null) {
			List<Etudiant> lst = ga.etudiants(Integer.parseInt(request.getParameter("filiere")), Integer.parseInt(request.getParameter("niveau")));
			session.setAttribute("etudiants", lst);
			response.sendRedirect("admin/etudiants.jsp");
		}
		
		else if(request.getParameter("deleteEtud")!=null) {
			ga.deleteEtudiant(Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("admin/etudiants.jsp");
		}
		
		else if(request.getParameter("modifEtud")!=null) {
			int id = Integer.parseInt(request.getParameter("id"));
			Etudiant etud = ga.getEtudiant(id);
			session.setAttribute("etudiant", etud);
			session.setAttribute("login", ga.getLogin(etud.getCne()));
			
			response.sendRedirect("admin/modifier.jsp");
		}
		
		else if(request.getParameter("modify")!=null) {
			int idEtud = Integer.parseInt(request.getParameter("idEtud"));
			int idLog = Integer.parseInt(request.getParameter("idLog"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String cne = request.getParameter("cne");
			String cin = request.getParameter("cin");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String anneeBac = request.getParameter("anneeBac");
			String photo = null;
			String adresse = request.getParameter("adresse");
			String dateNai = request.getParameter("dateNai");
			String optionBac = request.getParameter("optionBac");
			String mention = request.getParameter("mentien");
			int idClasse = Integer.parseInt(request.getParameter("niveau"));
			int idFiliere = Integer.parseInt(request.getParameter("filiere"));
			Etudiant etudiant = new Etudiant( nom,  prenom,  cne,  cin,  email,  telephone,
					 anneeBac,  photo,  adresse,  dateNai,  optionBac,  mention, idFiliere,
					 idClasse);
			etudiant.setIdEtudiant(idEtud);
			Login login = new Login(cne, request.getParameter("pass"));
			login.setIdLogin(idLog);
			ga.modifyEtud(etudiant, login);
			response.sendRedirect("admin/etudiants.jsp");
		}
		
		else if(request.getParameter("absStep1")!=null) {
			List<Etudiant> lst = ga.etudiants(Integer.parseInt(request.getParameter("filiere")), Integer.parseInt(request.getParameter("niveau")));
			session.setAttribute("etudiants", lst);
			List<Module> list = ga.modules(Integer.parseInt(request.getParameter("filiere")), Integer.parseInt(request.getParameter("niveau")));
			session.setAttribute("modules", list);
			session.setAttribute("step", "step1");
			response.sendRedirect("admin/absences.jsp");
		}
		
		else if(request.getParameter("absStep2")!=null) {
			ArrayList<Absence> lst = ga.absence(Integer.parseInt(request.getParameter("etudiant")), Integer.parseInt(request.getParameter("module")));
			session.setAttribute("absences", lst);
			session.setAttribute("step", "step2");
			response.sendRedirect("admin/absences.jsp");
		}
	}

}
