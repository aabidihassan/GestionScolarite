
<%@page import="java.util.List"%>
<%@page import="com.Beans.Etudiant"%>
<%@page import="com.Beans.Demande"%>
<%@page import="com.metier.GestionCompte"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
GestionCompte gc = new GestionCompte();
Etudiant etud = (Etudiant)session.getAttribute("etudiant");
List<Demande> lst = gc.demandes(etud.getIdEtudiant());
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
<h1 style="margin-top:1%;">Liste des demandes</h1>



<table style="width: 90%;">
    <thead>
    <tr><th>Type de document</th><th>Date demande</th><th>Description</th><th>Etat</th><th>Actions</th></tr>
    </thead>
    <tbody>
    <% for(Demande dm : lst){ %>
    	<tr>
    	<td><%= gc.nomType(dm.getIdType()) %></td>
    	<td><%= dm.getDateDemande() %></td>
    	<td><%= dm.getDescription() %></td>
    	<td><%= dm.getEtat() %></td>
    	<% if(dm.getEtat().equals("En attent")){ %>
    	<td>
    	<form method="POST" action="../Account">
    		<input type="text" value="<%= dm.getIdDemande() %>" name="idDemande" hidden="true">
    		<input class="btn btn-primary" type="submit" value="Modifier" name="mod">
    		<input class="btn btn-primary" style="background-color: red;" type="submit" value="Supprimer" name="sup">
    	</form>
    	</td>
    	<%} else if(dm.getEtat().equals("Accepter")){ %>
    	<td>Consulter le document chez la scolarite</td>
    	<%} else if(dm.getEtat().equals("Rejeter")){ %>
    	<td>Redemander le document</td>
    	<%} %>
    	</tr>
    <% } %>
    </tbody>
    </table>
</center>
</body>

</html>