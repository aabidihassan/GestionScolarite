<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
    <head>
    <link href="../inscription/css/ajt.css" rel="stylesheet" media="all">
    <title>Nouvelle inscription</title>
    <meta charset="utf-8">
    <link rel="icon" href="../images/logo.png" />
    <script type="text/javascript">
    	function show(id) {
    	  if(id==1){
    		  document.getElementById("theId").style.display = "none";
    		  document.getElementById("theIdd").style.display = "none";
    		  document.getElementById("Id").style.display = "none";
    		  document.getElementById("Idd").style.display = "none";
    		  document.getElementById("filiere").value = "${sessionScope.etudiant.idFiliere}";
    		  document.getElementById("niveau").value = "2";
    	  }
    	  if(id==2){
    		  document.getElementById("theId").style.display = "block";
    		  document.getElementById("theIdd").style.display = "block";
    		  document.getElementById("Id").style.display = "none";
    		  document.getElementById("Idd").style.display = "none";
    		  document.getElementById("filiere").value = "${sessionScope.etudiant.idFiliere}";
    		  document.getElementById("niveau").value = "1";
    	  }
    	}
    </script>
    </head>
    <body>
        <div class="hassan">
            <div class="card card-5">
                
                <center>
                    <button onclick="show(1)" class="btn btn--radius-2 btn--red" style="margin-top:2%;">Inscrir en 2 eme annee</button>
                    <button onclick="show(2)" class="btn btn--radius-2 btn--red">Changement de filiere</button>
                </center>
                <div class="page">
                <div class="card-body">
                    <form method="POST" action="../Reinscrir">
                        <div class="form-row m-b-55">
                            <div class="name">Nom et Prenom</div>
                            <div class="value">
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" value="${sessionScope.etudiant.nom}" name="prenom" placeholder="Prenom" readonly>
                                            <label class="label--desc">Prenom</label>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" value="${sessionScope.etudiant.prenom}" name="nom" placeholder="Nom" readonly>
                                            <label class="label--desc">nom</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Date naissance</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="date" value="${sessionScope.etudiant.dateNai}" name="dateNai" placeholder="Date naissance" style="height:55px;" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Code Massar</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" value="${sessionScope.etudiant.cne}" name="cne" placeholder="Code Massar" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Code identite nationnal</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" value="${sessionScope.etudiant.cin}" name="cin" placeholder="Code identite nationnal" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Adresse*</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" value="${sessionScope.etudiant.adresse}" name="adresse" placeholder="Adresse" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">E-mail*</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="email" value="${sessionScope.etudiant.email}" name="email" placeholder="E-mail" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">N° Telephone*</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" value="${sessionScope.etudiant.telephone}" name="telephone" placeholder="Numero de telephone" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Mot de passe*</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="password" name="pass" placeholder="Numero de telephone" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Annee Baccalaureat</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" value="${sessionScope.etudiant.anneeBac}" name="anneeBac" placeholder="Annee de baccalaureat" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Option de Baccalaureat</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" value="${sessionScope.etudiant.optionBac}" name="optionBac" placeholder="Option de Baccalaureat" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Mentien</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" value="${sessionScope.etudiant.mention}" name="optionBac" placeholder="Option de Baccalaureat" readonly>
                                    
                                </div>
                            </div>
                        </div>
                        <div  class="form-row">
                            <div id="theId" class="name" style="display:none;">Niveau</div>
                            <div id="theIdd" class="value" style="display:none;">
                                <div class="input-group">
                                <select value="${sessionScope.etudiant.idFiliere}" id="filiere" class="kwa" name="idFiliere">
                                    <option value="1">GÉNIE INFORMATIQUE</option>
                                    <option value="2">TECHNIQUES DE MANAGEMENT</option>
                                    <option value="3">TECHNIQUES INSTRUMENTALES & MANAGEMENT DE LA QUALITÉ</option>
                                    <option value="4">GÉNIE INDUSTRIEL & MAINTENANCE</option>
                   
                                </select>
                                </div>
                            </div>
                        </div>
                         <div class="form-row">
                            <div class="name" style="display:none;">Niveau</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" value="2" name="idClasse" placeholder="Option de Baccalaureat" hidden>
                                </div>
                            </div>
                        </div>
                        <div>
                            <button name="change" class="btn btn--radius-2 btn--red" type="submit" style="margin-top:-5%;">Valider les informations</button>
                        </div>
                    </form>
                </div>
            </div>
          </div>  
    </body>
</html>