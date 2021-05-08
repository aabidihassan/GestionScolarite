<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Compte administrateur</title>

  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/simple-sidebar.css" rel="stylesheet">
  <script type="text/javascript">
  	function dis(){
  		var x = document.getElementById('hada');
  	  if (x.style.display === 'none') {
  	    x.style.display = 'block';
  	  } else {
  	    x.style.display = 'none';
  	  }}
  	
  </script>
  <style type="text/css">
	  #img{
	  	width: 50px;
	  }
  	#img:hover{
  		cursor: pointer;
  	}
  </style>

</head>

<body>

  <div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper" >
    <div id="hada">
    <center><h3 style="margin-top:10.3%;">E-Scolarite ESTS</h3></center>
      <div class="list-group list-group-flush">
        <a href="reclamations.jsp" class="list-group-item list-group-item-action bg-light">Liste des reclamations</a>
        <a href="annances.jsp" class="list-group-item list-group-item-action bg-light">Liste des annonces</a>
        <a href="demandes.jsp" class="list-group-item list-group-item-action bg-light">Liste des demandes</a>
        <a href="annance.jsp" class="list-group-item list-group-item-action bg-light">Ajouter une annance</a>
        <a href="absence.jsp" class="list-group-item list-group-item-action bg-light">Marquer une absece</a>
        <a href="absences.jsp" class="list-group-item list-group-item-action bg-light">Liste des absences</a>
        <a href="etudiants.jsp" class="list-group-item list-group-item-action bg-light">Liste des etudiants</a>
        <a href="../Account" class="list-group-item list-group-item-action bg-light">Deconnexion</a>
      </div>
      </div>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

      <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <img src="../images/menu.png" onclick="dis()" class="img-responsive" id="img" >

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
            <li class="nav-item dropdown">
              <a  href="accueil.jsp" >
                <img src="../images/uti.png" class="img-responsive" style="width: 30px; " id="menu-toggle">
              </a>
            </li>
          </ul>
        </div>
      </nav>


</body>

</html>