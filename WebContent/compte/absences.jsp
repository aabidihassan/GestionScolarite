<%@page import="com.Beans.Absence"%>
<%@page import="java.util.List"%>
<%@page import="com.Beans.Etudiant"%>
<%@page import="com.metier.GestionCompte"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
GestionCompte gc = new GestionCompte();
Etudiant etud = (Etudiant)session.getAttribute("etudiant");
List<Absence> lst = gc.absences(etud.getIdEtudiant());
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
<h1 style="margin-top:1%;">Liste des absences</h1>



<table style="width: 90%;">
    <thead>
    <tr><th>Date Absence</th><th>Matiere</th><th>Nombre d'heure</th></tr>
    </thead>
    <tbody>
    <% for(Absence ab : lst){ %>
    	<tr>
    	<td><%= ab.getDateAbsence() %></td>
    	<td><%= gc.matiere(ab.getIdMatiere()) %></td>
    	<td><%= ab.getHeure() %></td>
    	</tr>
    <% } %>
    </tbody>
    </table>
</center>
</body>

</html>