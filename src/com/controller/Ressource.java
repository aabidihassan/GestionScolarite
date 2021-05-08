package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Beans.Demande;
import com.Beans.Etudiant;
import com.Beans.Reclamation;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.metier.GestionCompte;

/**
 * Servlet implementation class Ressource
 */
@WebServlet("/Ressource")
public class Ressource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ressource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		try {
//			PdfReader reader = new PdfReader("attestation.pdf");
//			PdfWriter writer = new PdfWriter();
//			PdfDocument document = new PdfDocument();
//			PdfPage page = document.getPage
//			
//			document.open();
//			document.add(new Paragraph("Attestation Scolaire"));
//			document.close();
//			writer.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GestionCompte gc = new GestionCompte();
		Etudiant etudiant = (Etudiant) session.getAttribute("etudiant");
		if(request.getParameter("demande")!=null) {
			Demande demande = new Demande(etudiant.getIdEtudiant(), Integer.parseInt(request.getParameter("idDemande")),
					request.getParameter("description"), new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			gc.demande(demande);
			response.sendRedirect("compte/demandes.jsp");
		}
		else if(request.getParameter("reclamation")!=null) {
			Reclamation reclamation = new Reclamation(request.getParameter("texte"), etudiant.getIdEtudiant());
			gc.reclamation(reclamation);
			response.sendRedirect("compte/reclamations.jsp");
		}
	}

}
