<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.eni.projetEnchere.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
			       <td>1-jojo44</td>
			   </tr>
			   <tr>
			       <td>Nom : </td>
			       <td>2</td>
			   </tr>
			   <tr>
			       <td>Prénom : </td>
			       <td>3</td>
			   </tr>
			   <tr>
			       <td>Email : </td>
			       <td>4</td>
			   </tr>
			   <tr>
			       <td>Téléphone : </td>
			       <td>5</td>
			   </tr>
			   <tr>
			       <td>Rue : </td>
			       <td>6</td>
			   </tr>
			   <tr>
			       <td>Code postal : </td>
			       <td>7</td>
			   </tr>  
			   <tr>
			       <td>Ville : </td>
			       <td>8</td>
			   </tr>
			</table>
		</div>
	</div>
	<div class="form-group col-md-12 text-center">	
		<a href="./ModifierProfil"><button type="submit" class="btn btn-primary">Modifier</button></a>
	</div>
</div>	


		<%
 		String pseudoUtilisateur = "";
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateurConnecte");
 		if (u == null) {
 			pseudoUtilisateur = u.getPseudo();
 		}
 		%>
		<%=pseudoUtilisateur%>


	<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>