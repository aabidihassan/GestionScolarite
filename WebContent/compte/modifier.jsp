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

<% if(session.getAttribute("demande")!=null){ 
 Demande dm = (Demande)session.getAttribute("demande");
%>
<center>
<h1 style="margin-top:1%;">Modifier la demande</h1>
</center>
<center style="margin-top:4%;">

<form action="../Account" method="POST">
<table align="center" style="width: 80%; height:400px; border: 4px solid black;">
<tr>
<td class="cls">
Type de document:
</td><td>
<select id="typeDem" class="input" name="type">
     <option value="1"> Attestation Scolaire</option>
     <option value="2"> Relevie de notes</option>
     <option value="3"> Baccalaureat</option>                                  
</select>
</td>
</tr>

<tr>
<td class="cls">
Description:
</td><td>
<input type="text" value="<%= dm.getDescription() %>" name="description" class="input" style="height: 130px;">
</td>
</tr>

<tr>
<td colspan="2">
	<input class="btn btn-primary" type="submit" name="modifier" value="Modifier la demande" >
	</td>
	</tr>
</table>
</form>
</center>
<script type="text/javascript">
   
    let element = document.getElementById("typeDem");
    element.value = <%= dm.getIdType() %>;

</script>


<%} else if(session.getAttribute("reclamation")!=null){ 
 Reclamation recl = (Reclamation)session.getAttribute("reclamation");
%>
<center>
<h1 style="margin-top:1%;">Modifier la reclamation</h1>
</center>
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