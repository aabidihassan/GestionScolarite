package com.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.websocket.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Beans.Demande;
import com.Beans.Etudiant;
import com.Beans.Login;
import com.Beans.Reclamation;
import com.metier.GestionCompte;

/**
 * Servlet implementation class Account
 */
@WebServlet("/Account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Account() {
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
		request.getSession().invalidate();
		response.sendRedirect("compte");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionCompte gc = new GestionCompte();
		HttpSession session = request.getSession();
		
		if(request.getParameter("log")!=null) {
			Login login = new Login(request.getParameter("login"), request.getParameter("pass"));
			
			if(gc.authontification(login)) {
				Etudiant etudiant = gc.findEtudiant(login.getCne());
				session.setAttribute("etudiant", etudiant);
				System.out.println(etudiant.getNom());
				response.sendRedirect("compte/accueil.jsp");
			}
			else {
				response.sendRedirect("compte");
			}
		}
		
		else if(request.getParameter("sup")!=null) {
			gc.deleteDemande(Integer.parseInt(request.getParameter("idDemande")));
			response.sendRedirect("compte/demandes.jsp");
		}
		
		else if(request.getParameter("mod")!=null) {
			session.setAttribute("demande", gc.getDemande(Integer.parseInt(request.getParameter("idDemande"))));
			response.sendRedirect("compte/modifier.jsp");
		}
		
		else if(request.getParameter("modifier")!=null) {
			Demande dm = (Demande)session.getAttribute("demande");
			Demande demande = new Demande(dm.getIdEtudiant(),Integer.parseInt(request.getParameter("type")),
					request.getParameter("description"), dm.getDateDemande());
			demande.setIdDemande(dm.getIdDemande());
			gc.modifyDemande(demande);
			session.removeAttribute("demande");
			response.sendRedirect("compte/demandes.jsp");
		}
		
		else if(request.getParameter("supRec")!=null) {
			gc.deleteReclamation(Integer.parseInt(request.getParameter("idReclamation")));
			response.sendRedirect("compte/reclamations.jsp");
		}
		
		else if(request.getParameter("modRec")!=null) {
			session.setAttribute("reclamation", gc.getReclamation(Integer.parseInt(request.getParameter("idReclamation"))));
			response.sendRedirect("compte/modifier.jsp");;
		}
		
		else if(request.getParameter("modifierRec")!=null) {
			Reclamation recl = (Reclamation)session.getAttribute("reclamation");
			Reclamation rc = new Reclamation(recl.getIdEtudiant(), request.getParameter("texte"), recl.getIdReclamation());
					
			gc.modifyReclamation(rc);
			session.removeAttribute("reclamation");
			response.sendRedirect("compte/reclamations.jsp");
		}
	}

}
