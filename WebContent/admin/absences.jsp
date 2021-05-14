<%@page import="com.Beans.Absence"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Beans.Module"%>
<%@page import="com.Beans.Etudiant"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

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
    width: 80%;
    height:100%;
    
  }
  
  th, td {
    text-align: left;
    padding: 14px;
  }
  
  .cls{
    width: 20%;
  }

  th {
    background-color: rgb(154, 154, 184);
    color: white;
  }

  .input{
    width: 80%;
    border-radius: 7px;
    height:60%;
  }
  input{
  	width: 80%;
    border-radius: 7px;
  }
  </style>

</head>

<body>

<jsp:include page="menu.jsp"></jsp:include>

<form action="../Admin" method="POST">
<center>
<% if(session.getAttribute("step")==null) {%>

<h1 style="margin-top:2%;">Choisir une classe</h1>

<table align="center" style="width: 80%; height:280px; border: 4px solid black;">
<td class="cls">
Choisir la filiere:
</td><td>
<select name="filiere" class="input">
        <option value="1">GÉNIE INFORMATIQUE</option>
        <option value="2">TECHNIQUES DE MANAGEMENT</option>
        <option value="3">TECHNIQUES INSTRUMENTALES & MANAGEMENT DE LA QUALITÉ</option>
        <option value="4">GÉNIE INDUSTRIEL & MAINTENANCE</option>
</select>
</td>
</tr>

<tr>
<td class="cls">
Choisir le niveau:
</td><td>
<select name="niveau" class="input">
        <option value="1">1 ÉRE ANNÉE</option>
        <option value="2">2 ÉME ANNÉE</option>
        <option value="3">LICENCE PROFESSIONNEL</option>
</select>
</td>
</tr>

<tr>
<td colspan="2">
	<input class="btn btn-primary" type="submit" name="absStep1" value="Chercher les etudiants" >
	</td>
	</tr>
</table>


<% } else if(session.getAttribute("step").equals("step1")){ 
	List<Etudiant> lst =(List<Etudiant>)session.getAttribute("etudiants");
	List<Module> list =(List<Module>)session.getAttribute("modules");
	session.removeAttribute("step");
	session.removeAttribute("etudiants");
	session.removeAttribute("modules");
%>
<h1 style="margin-top:2%;">Choisir l'etudiant</h1>

<table align="center" style="width: 80%; height:280px; border: 4px solid black;">
<td class="cls">
Choisir l'etudiant:
</td><td>
<select name="etudiant" class="input">
    <%
    	for(Etudiant et : lst){
    		%>
    		<option value="<%= et.getIdEtudiant() %>"><%= et.getNom() %> <%= et.getPrenom() %></option>
    <%
    	}
    %>
</select>
</td>
</tr>

<tr>
<td  class="cls">
Choisir le module:
</td><td>
<select name="module" class="input">
    <%
    	for(Module mod : list){
    		%>
    		<option value="<%= mod.getIdModule() %>"><%= mod.getNomModule() %></option>
    <%
    	}
    %>
</select>
</td>
</tr>

<tr>
<td colspan="2">
<input class="btn btn-primary" type="submit" name="absStep2" value="Consulter les absences" >
</td>
</tr>
</table>

<%} else if(session.getAttribute("step").equals("step2")){ 
	ArrayList<Absence> lst = (ArrayList<Absence>)session.getAttribute("absences");
	session.removeAttribute("step");
	session.removeAttribute("absences");
%>

<h1 style="margin-top:1%;">Liste des absences</h1>



<table style="width: 90%;">
    <thead>
    <tr><th>Date absence</th><th>Nombre d'heures</th><th>Actions</th></tr>
    </thead>
    <tbody>
    <% for(Absence an : lst){ %>
    	<tr>
    	<td><%= an.getDateAbsence() %></td>
    	<td><%= an.getHeure() %></td>
    	<td>
		    <form action="../Admin" method="POST">
				<input type="text" name="id" value="<%= an.getIdAbsence() %>" hidden="true">
				<input class="btn btn-primary" style=" width: 40%;" type="submit" name="modifAbs" value="Modifier">
				<input class="btn btn-primary" style="background-color: red; width: 40%;" name="deleteAbs" type="submit" value="Supprimer">
			</form>
		</td>
    	</tr>
    <% } %>
    </tbody>
    </table>

<% } %>
</center>
</form>
</body>

</html></html>