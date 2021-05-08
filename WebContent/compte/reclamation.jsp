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
<center>
<h1 style="margin-top:1%;">Ajouter une reclamation</h1>
</center>
<center style="margin-top:4%;">

<form action="../Ressource" method="POST">
<table align="center" style="width: 80%; height:300px; border: 4px solid black;">

<tr>
<td class="cls">
Texte de reclamation:
</td><td>
<input type="text" name="texte" class="input" style=" height:120px;">
</td>
</tr>

<tr>
<td colspan="2">
	<input class="btn btn-primary" type="submit" name="reclamation" value="Reclamer" >
	</td>
	</tr>
</table>
</form>
</center>
</body>

</html>