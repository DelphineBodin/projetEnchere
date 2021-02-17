<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.eni.projetEnchere.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="../fragments/header.jspf" %>
<title>Affichage du profil</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">

</head>
<body>
				<!-- //////////////PAGE 7/13\\\\\\\\\\\\\\\ -->
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
			<table>			       		
			   <tr>
			       <td>Pseudo : </td>
			       <td>    		
						${utilisateurConnecte.pseudo}
					</td>
			   </tr>
			   <tr>
			       <td>Nom : </td>
			       <td>	
			       		${utilisateurConnecte.nom}		       
			       </td>
			   </tr>
			   <tr>
			       <td>Pr�nom : </td>
			       <td>
			       		${utilisateurConnecte.prenom}
			       </td>
			   </tr>
			   <tr>
			       <td>Email : </td>
			       <td>
			       		${utilisateurConnecte.email}
			       	</td>
			   </tr>
			   <tr>
			       <td>T�l�phone : </td>
			       <td>
			       		${utilisateurConnecte.telephone}
			       </td>
			   </tr>
			   <tr>
			       <td>Rue : </td>
			       <td>
			       		${utilisateurConnecte.rue}
			       </td>
			   </tr>
			   <tr>
			       <td>Code postal : </td>
			       <td>
			       		${utilisateurConnecte.codePostal}
			       </td>
			   </tr>  
			   <tr>
			       <td>Ville : </td>
			       <td>
			       		${utilisateurConnecte.ville}
			       </td>
			   </tr>
			</table>
		</div>
	</div>
	<div class="form-group col-md-12 text-center">	
		<a href="./ModifierProfil"><button type="submit" class="btn btn-primary">Modifier</button></a>
	</div>
</div>	





	<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>