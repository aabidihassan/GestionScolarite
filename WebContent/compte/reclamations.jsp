<%@page import="com.Beans.Etudiant"%>
<%@page import="com.Beans.Reclamation"%>
<%@page import="java.util.List"%>
<%@page import="com.metier.GestionCompte"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
GestionCompte gc = new GestionCompte();
Etudiant etud = (Etudiant)session.getAttribute("etudiant");
List<Reclamation> lst = gc.reclamations(etud.getIdEtudiant());
%>
    
<!DOCTYPE html>
<html lang="en">

<head>

  <link rel="icon" type="image/png" href="../images/logo.png"/>
  <style type="text/css">
table {

  border-radius: 10px;
    border-collapse: collapse;
    width: 100%;
    margin-top: 3%;
    background-color: #e4e7e7;
    width: 90%;
    
  }
  
  th, td {
    text-align: left;
    padding: 14px;
  }
  
  
  th {
    background-color: rgb(154, 154, 184);
    color: white;
  }
  </style>

</head>

<body>

<jsp:include page="menu.jsp"></jsp:include>
<center>
<h1 style="margin-top:1%;">Liste des reclamations</h1>



<table style="width: 90%;">
    <thead>
    <tr><th>Texte de reclamation</th><th>Date reclamation</th><th>Actions</th></tr>
    </thead>
    <tbody>
    <% for(Reclamation rc : lst){ %>
    	<tr>
    	<td><%= rc.getText() %></td>
    	<td><%= rc.getDateReclamation() %></td>
    	<td>
    	<form method="POST" action="../Account">
    		<input type="text" value="<%= rc.getIdReclamation() %>" name="idReclamation" hidden="true">
    		<input class="btn btn-primary" type="submit" value="Modifier" name="modRec">
    		<input class="btn btn-primary" style="background-color: red;" type="submit" value="Supprimer" name="supRec">
    	</form>
    	</td>
    	</tr>
    <% } %>
    </tbody>
    </table>
</center>
</body>

</html>