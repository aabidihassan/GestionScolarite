<%@page import="com.Beans.Matiere"%>
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
<center>
<h1 style="margin-top:1%;">Marquer une absence</h1>

<form action="../Admin" method="POST">



<%
	if(session.getAttribute("pos")==null){
%>
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
	<input class="btn btn-primary" type="submit" name="step1" value="Chercher les etudiants" >
	</td>
	</tr>
</table>
<%	
	}
	else if(session.getAttribute("pos").equals("step1")){
		List<Etudiant> lst =(List<Etudiant>)session.getAttribute("etudiants");
		List<Module> list =(List<Module>)session.getAttribute("modules");
		session.removeAttribute("pos");
		session.removeAttribute("etudiants");
		session.removeAttribute("modules");
%>
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
	<input class="btn btn-primary" type="submit" name="step2" value="Suivant" >
	</td>
	</tr>
	</table>
<%
	}
	else if(session.getAttribute("pos").equals("step2")){
		session.removeAttribute("pos");
		List<Matiere> lst = (List<Matiere>)session.getAttribute("list");
%>
<table align="center" style="width: 80%; height:550px; border: 4px solid black;">
<tr>
<td  class="cls">Choisir la matiere</td>
<td>
<select name="matiere" class="input">
<%for(Matiere mt : lst){
%>

<option value="<%=mt.getIdMatiere() %>"><%=mt.getNomMatiere() %></option>

<%
} 
%>
</select>
</td>

</tr>

<tr>
	<td rowspan="4"  class="cls">Choisir les heures d'absence:</td>
	<td>
		08:00 - 10:00  <input type="checkbox" name="check_list" value="08:00 - 10:00">
		</td>
</tr>
<tr>
		<td>
	    10:00 - 12:00  <input type="checkbox" name="check_list" value="10:00 - 12:00">
	    </td>
	    </tr>
<tr>
		<td>
	    14:00 - 16:00  <input type="checkbox" name="check_list" value="14:00 - 16:00">
	    </td>
	    </tr>
<tr>
		<td>
	    16:00 - 18:00  <input type="checkbox" name="check_list" value="16:00 - 18:00">
	</td>
</tr>

<tr>
	<td  class="cls">Choisir la date:</td>
	<td>
		<input type="date" name="date">
	</td>
</tr>
<tr>
<td colspan="2">
	<input class="btn btn-primary" type="submit" name="step3" value="Marquer l'absence" >
</td>
</tr>
</table>

<%		
	}
%>
<tr>
</form>



</center>


</body>

</html>