<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/style.css">
<title>Connexion Utilisateur</title>
</head>
<body>
	<%
		String messageErreur = (String) request.getAttribute("messageErreur");
	%>
	<form method="post">
		<div class="container">
			<div class="row">

				<form method="post" action="MesAchats">
					<div class="form-group">
						<!-- col-md-offset je rajoute une marge de 4 colonnes, ce qui centre -->
						<div class="form-group col-lg-2 col-lg-offset-4">
							<h1>Mon profil</h1>
							<label for="pseudo">Identifiant :</label> <input type="text" name="sidentifiant" class="form-control">
							<%-- <span class="erreur">${erreurs['pseudo']}</span> --%>
						</div>
					</div>

					<div class="form-group ">
						<div class="form-group col-lg-2 col-lg-offset-5">
							<label for="password">Mot de passe :</label> <input type="password" name="smotdepasse" class="form-control">
						</div>
					</div>
					
					

					<button type="submit" name="ssubmit" class="btn btn-primary" value="Connexion">Connexion</button>
<br> <font color="red"><%=request.getAttribute("messageErreur") != null ? request.getAttribute("messageErreur") : ""%></font>
				</form>
			</div>
		</div>
		
		
<!-- 		container pour creer compte, toujours pareil ça ne fmarche pas dans le form -->
		<div class="container">
			<div class="from-group col-md-2 col-md-offset-5">
				<!-- 	bouton creer compte sorti du form ci dessus car le lien ne marchait pas, gregoyr m'a dit que ça devrai marcher...bizarre -->
				<br> <a href="./Profil"> <input type="submit"
					class="btn btn-primary btn-lg" value="Créer un compte"></a>
			</div>
		</div>


		<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>