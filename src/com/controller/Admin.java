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
	}

}
