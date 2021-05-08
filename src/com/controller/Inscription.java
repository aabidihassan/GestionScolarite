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
import com.Beans.Login;
import com.metier.GestionInscription;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
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
		response.sendRedirect("inscription");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionInscription gi = new GestionInscription();
		HttpSession session = request.getSession();
		if(gi.already(request.getParameter("cne"),request.getParameter("cin"))) {
			response.sendRedirect("inscription");
		}
		else {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String cne = request.getParameter("cne");
			String cin = request.getParameter("cin");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String anneeBac = request.getParameter("anneeBac");
			String photo = request.getParameter("photo");
			String adresse = request.getParameter("adresse");
			String dateNai = request.getParameter("dateNai");
			String optionBac = request.getParameter("optionBac");
			String mention = request.getParameter("mentien");
			int idClasse = Integer.parseInt(request.getParameter("idClasse"));
			int idFiliere = Integer.parseInt(request.getParameter("filiere"));
			Etudiant etudiant = new Etudiant( nom,  prenom,  cne,  cin,  email,  telephone,
					 anneeBac,  photo,  adresse,  dateNai,  optionBac,  mention, idFiliere,
					 idClasse);
			Login login = new Login(cne, request.getParameter("pass"));
			gi.insert(etudiant, login);
			session.setAttribute("etudiant", etudiant);
		}
		
	}

}
