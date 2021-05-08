<%@page import="com.Beans.Demande"%>
<%@page import="java.util.List"%>
<%@page import="com.metier.GestionAdmin"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <% 
  GestionAdmin ga = new GestionAdmin();
  List<Demande>attestations = ga.demandes(1);
  List<Demande>releves = ga.demandes(2);
  List<Demande>bac = ga.demandes(3);
%>

<!DOCTYPE html>
<html lang="en">

<head>


<script type="text/javascript">

function show(id){
	if(id==1){
		document.getElementById("attestations").style.display = "block";
		document.getElementById("releves").style.display = "none";
		document.getElementById("bac").style.display = "none";
	}
	if(id==2){
		document.getElementById("attestations").style.display = "none";
		document.getElementById("releves").style.display = "block";
		document.getElementById("bac").style.display = "none";
	}
	if(id==3){
		document.getElementById("attestations").style.display = "none";
		document.getElementById("releves").style.display = "none";
		document.getElementById("bac").style.display = "block";
	}
	
}

</script>


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

<h1 style="margin-top:2%; margin-bottom: 2%;">Liste des Demandes des documents</h1>
<button class="btn btn-primary" onclick="show(1)">Demandes des Attestation Scolaire</button>
<button class="btn btn-primary" onclick="show(2)">Demandes des Releves des notes</button>
<button class="btn btn-primary" onclick="show(3)">Demandes des Baccalaureat</button>

</center>


<div id="attestations">
<center>
<table style="width: 90%;">
    <thead>
    <tr><th>Etudiant</th><th>Date demmande</th><th>Description</th><th>Etat</th><th>Actions</th></tr>
    </thead>
    <tbody>
    <% for(Demande dm : attestations){ %>
    	<tr>
    	<td><%= ga.nomEtudiant(dm.getIdEtudiant()) %></td>
    	<td><%= dm.getDateDemande() %></td>
    	<td><%= dm.getDescription() %></td>
    	<td><%= dm.getEtat() %></td>
    	<td>
    		<form action="../Admin" method="POST">
    		<input type="text" name="id" value="<%= dm.getIdDemande() %>" hidden="true">
    		<% if(dm.getEtat().equals("En attent")){ %>
    			<input class="btn btn-primary" name="accepter" style="background-color: green;" type="submit" value="Accepter">
    			<input class="btn btn-primary" name="rejeter" style="background-color: orange;" type="submit" value="Rejeter">
    			<%} %>
    			<input class="btn btn-primary" style="background-color: red;" name="supprimer" type="submit" value="Supprimer">
    		</form>
    		
    	</td>
    	</tr>
    <% } %>
    </tbody>
    </table>
</center>
</div>

<div id="releves" style="display:none;">
<center>
<table style="width: 90%;">
    <thead>
    <tr><th>Etudiant</th><th>Date demmande</th><th>Description</th><th>Etat</th><th>Actions</th></tr>
    </thead>
    <tbody>
    <% for(Demande dm : releves){ %>
    	<tr>
    	<td><%= ga.nomEtudiant(dm.getIdEtudiant()) %></td>
    	<td><%= dm.getDateDemande() %></td>
    	<td><%= dm.getDescription() %></td>
    	<td><%= dm.getEtat() %></td>
    	<td>
    		<form action="../Admin" method="POST">
    		<input type="text" name="id" value="<%= dm.getIdDemande() %>" hidden="true">
    		<% if(dm.getEtat().equals("En attent")){ %>
    			<input class="btn btn-primary" name="accepter" style="background-color: green;" type="submit" value="Accepter">
    			<input type="submit" value="Rejeter" class="btn btn-primary" name="rejeter" style="background-color: orange;" >
    			<%} %>
    			<input type="submit" value="Supprimer" name="supprimer" class="btn btn-primary" style="background-color: red;">
    		</form>
    		
    	</td>
    	</tr>
    <% } %>
    </tbody>
    </table>
</center>
</div>


<div id="bac" style="display:none;">
<center>
<table style="width: 90%;">
    <thead>
    <tr><th>Etudiant</th><th>Date demmande</th><th>Description</th><th>Etat</th><th>Actions</th></tr>
    </thead>
    <tbody>
    <% for(Demande dm : bac){ %>
    	<tr>
    	<td><%= ga.nomEtudiant(dm.getIdEtudiant()) %></td>
    	<td><%= dm.getDateDemande() %></td>
    	<td><%= dm.getDescription() %></td>
    	<td><%= dm.getEtat() %></td>
    	<td>
    		<form action="../Admin" method="POST">
    		<input type="text" name="id" value="<%= dm.getIdDemande() %>" hidden="true">
    		<% if(dm.getEtat().equals("En attent")){ %>
    			<input class="btn btn-primary" name="accepter" style="background-color: green;" type="submit" name="accepter" value="Accepter">
    			<input type="submit" value="rejeter" class="btn btn-primary" name="rejeter" style="background-color: orange;" >
    			<%} %>
    			<input type="submit" name="supprimer" value="Supprimer" class="btn btn-primary" style="background-color: red;">
    		</form>
    		
    	</td>
    	</tr>
    <% } %>
    </tbody>
    </table>
</center>
</div>


</body>

</html></html>