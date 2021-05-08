<%@page import="com.metier.GestionAdmin"%>
<%@page import="com.Beans.Annance"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
GestionAdmin ga = new GestionAdmin();
List<Annance> lst = ga.annances();
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
    <tr><th>Date Annance</th><th>Texte annance</th></tr>
    </thead>
    <tbody>
    <% for(Annance an : lst){ %>
    	<tr>
    	<td><%= an.getDateAnnance() %></td>
    	<td><%= an.getTextAnnance() %></td>
    	</tr>
    <% } %>
    </tbody>
    </table>
</center>
</body>

</html>