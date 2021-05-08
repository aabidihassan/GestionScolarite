<%@page import="com.Beans.Login"%>
<%@page import="com.Beans.Reclamation"%>
<%@page import="com.Beans.Demande"%>
<%@page import="com.Beans.Etudiant"%>
<%@page import="com.metier.GestionCompte"%>
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

<% if(session.getAttribute("etudiant")!=null){ 
 Etudiant et = (Etudiant)session.getAttribute("etudiant");
 Login log = (Login)session.getAttribute("login");
%>
<center>
<h1 style="margin-top:1%;">Modifier l'etudiant:</h1>
<h4><%= et.getPrenom() %> <%= et.getNom() %></h4>
</center>
<center style="margin-top:2%;">

<form action="../Admin" method="POST">
<table align="center" style="width: 80%; height:1400px; margin-bottom:5%; border: 4px solid black;">


<tr>
<td class="cls">
Nom:
</td><td>
<input name="nom" class="input" type="text" value="<%= et.getNom()%>">
</td>
</tr>

<tr>
<td class="cls">
Prenom:
</td><td>
<input name="prenom" class="input" type="text" value="<%= et.getPrenom()%>">
</td>
</tr>

<tr>
<td class="cls">
Date de naissance:
</td><td>
<input name="dateNai" class="input" type="date" value="<%= et.getDateNai()%>">
</td>
</tr>

<tr>
<td class="cls">
CIN:
</td><td>
<input name="cin" class="input" type="text" value="<%= et.getCin()%>">
</td>
</tr>

<tr>
<td class="cls">
CNE:
</td><td>
<input name="cne" class="input" type="text" value="<%= et.getCne()%>">
</td>
</tr>

<tr>
<td class="cls">
Adresse:
</td><td>
<input name="adresse" class="input" type="text" value="<%= et.getAdresse()%>">
</td>
</tr>

<tr>
<td class="cls">
Telephone:
</td><td>
<input name="telephone" class="input" type="text" value="<%= et.getTelephone()%>">
</td>
</tr>

<tr>
<td class="cls">
E-mail:
</td><td>
<input name="email" class="input" type="text" value="<%= et.getEmail()%>">
</td>
</tr>

<tr>
<td class="cls">
Mot de passe:
</td><td>
<input name="pass" class="input" type="text" value="<%= log.getPassword()%>">
</td>
</tr>

<tr>
<td class="cls">
Annee de Baccalaureat:
</td><td>
<input name="anneeBac" class="input" type="text" value="<%= et.getAnneeBac()%>">
</td>
</tr>

<tr>
<td class="cls">
Obtion de bac:
</td><td>
<input name="optionBac" class="input" type="text" value="<%= et.getOptionBac()%>">
</td>
</tr>

<tr>
<td class="cls">
Mention:
</td><td>
<select class="input" id="mention" name="mentien">
       <option value="passable">PASSABLE</option>
       <option value="Abien">ASSEZ BIEN</option>
       <option value="bien">BIEN</option>
       <option value="tres bien">TRES BIEN</option>
</select>
</td>
</tr>

<tr>
<td class="cls">
Filiere:
</td><td>
<select class="input" id="filiere" name="filiere">
        <option value="1">GÉNIE INFORMATIQUE</option>
        <option value="2">TECHNIQUES DE MANAGEMENT</option>
        <option value="3">TECHNIQUES INSTRUMENTALES & MANAGEMENT DE LA QUALITÉ</option>
        <option value="4">GÉNIE INDUSTRIEL & MAINTENANCE</option>
</select>
</td>
</tr>

<tr>
<td class="cls">
Filiere:
</td><td>
<select class="input" id="niveau" name="niveau" value="<%= et.getIdClasse()%>">
        <option value="1">1 ÉRE ANNÉE</option>
        <option value="2">2 ÉME ANNÉE</option>
        <option value="3">LICENCE PROFESSIONNEL</option>
</select>
</td>
</tr>


<tr>
<td colspan="2">
<input type="text" name="idEtud" value="<%= et.getIdEtudiant()%>" hidden="true">
<input type="text" name="idLog" value="<%= log.getIdLogin()%>" hidden="true">
<input class="btn btn-primary" style="width: 50%" type="submit" value="Enregistrer" name="modify">
</td>
</tr>





</table>
</form>
</center>

<script type="text/javascript">
let element = document.getElementById("mention");
element.value = "<%= et.getMention() %>";

document.getElementById("filiere").value = <%= et.getIdFiliere() %>;

document.getElementById("niveau").value = <%= et.getIdClasse() %>;
</script>


<%} else if(session.getAttribute("reclamation")!=null){ 
 Reclamation recl = (Reclamation)session.getAttribute("reclamation");
%>
<center style="margin-top:4%;">

<form action="../Account" method="POST">
<table align="center" style="width: 80%; height:400px; border: 4px solid black;">

<tr>
<td class="cls">
Texte de reclamation:
</td><td>
<input type="text" value="<%= recl.getText() %>" name="texte" class="input" style="height: 130px;">
</td>
</tr>

<tr>
<td colspan="2">
	<input class="btn btn-primary" type="submit" name="modifierRec" value="Modifier la reclamation" >
	</td>
	</tr>
</table>
</form>
</center>
<%} %>






</body>

</html>