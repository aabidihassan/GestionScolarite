package com.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Beans.Etudiant;
import com.metier.GestionCompte;
import com.metier.GestionInscription;

/**
 * Servlet implementation class Reinscrir
 */
@WebServlet("/Reinscrir")
public class Reinscrir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reinscrir() {
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
		response.sendRedirect("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionInscription gi = new GestionInscription();
		GestionCompte gc = new GestionCompte();
		HttpSession session = request.getSession();
		if(request.getParameter("check") != null) {
		if(gi.already(request.getParameter("cne"),request.getParameter("cin"))) {
			Etudiant etudiant = gc.findEtudiant(request.getParameter("cne"));
			session.setAttribute("etudiant", etudiant);
			response.sendRedirect("reinscription/reinscrir.jsp");
		}
		}
		if(request.getParameter("change")!=null) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String cne = request.getParameter("cne");
			String cin = request.getParameter("cin");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String anneeBac = request.getParameter("anneeBac");
			String adresse = request.getParameter("adresse");
			String dateNai = request.getParameter("dateNai");
			String optionBac = request.getParameter("optionBac");
			String mention = request.getParameter("mentien");
			String password = request.getParameter("pass");
			int idClasse = Integer.parseInt(request.getParameter("idClasse"));
			int idFiliere = Integer.parseInt(request.getParameter("idFiliere"));
			Etudiant etudiant = new Etudiant( nom,  prenom,  cne,  cin,  email,  telephone,
					 anneeBac,  adresse,  dateNai,  optionBac,  mention, idFiliere,
					 idClasse);
			Etudiant e = (Etudiant) session.getAttribute("etudiant");
			etudiant.setIdEtudiant(e.getIdEtudiant());
			System.out.println(etudiant.getIdEtudiant());
			gi.change(etudiant, password);
			response.sendRedirect("compte/accueil.jsp");
		}
	}

}
