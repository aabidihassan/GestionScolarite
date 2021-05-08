<%@page import="com.Beans.Etudiant"%>
<%@page import="com.metier.GestionCompte"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <link rel="icon" type="image/png" href="../images/logo.png"/>
  <style type="text/css">
  	table, td, tr {
		width:70%;
		text-align: center;
		padding: 15px;
	}
  </style>

</head>

<body>

<jsp:include page="menu.jsp"></jsp:include>
<center>
<h1 style="margin-top:1%;">Ajouter une reclamation</h1>
</center>
<center style="margin-top:4%;">

<form action="../Admin" method="POST">
<table border="2">

<tr>
<td style="width:20%;">
Texte d'annance:
</td><td>
<input type="text" name="texte" style="width:60%; height:100px;">
</td>
</tr>

<tr>
<td style="width:20%;">
Choisir la filiere:
</td><td>
<select style="width:60%; height:40px;" name="filiere">
        <option value="1">GÉNIE INFORMATIQUE</option>
        <option value="4">TECHNIQUES DE MANAGEMENT</option>
        <option value="7">TECHNIQUES INSTRUMENTALES & MANAGEMENT DE LA QUALITÉ</option>
        <option value="10">GÉNIE INDUSTRIEL & MAINTENANCE</option>
</select>
</td>
</tr>

<tr>
<td style="width:20%;">
Choisir le niveau:
</td><td>
<select style="width:60%; height:40px;" name="niveau">
        <option value="1">1 ÉRE ANNÉE</option>
        <option value="2">2 ÉME ANNÉE</option>
        <option value="3">LICENCE PROFESSIONNEL</option>
</select>
</td>
</tr>

<tr>
<td colspan="2">
	<input class="btn btn-primary" type="submit" name="annance" value="Enregistrer l'annance" >
	</td>
	</tr>
</table>
</form>
</center>
</body>

</html>