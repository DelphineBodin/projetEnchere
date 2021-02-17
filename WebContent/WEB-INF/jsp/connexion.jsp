<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">
<title>Connexion Utilisateur</title>
</head>
<body>
	<%
		String messageErreur = (String) request.getAttribute("messageErreur");
	%>
	<div class="container">
		<div class="row">
			<h1>Mon profil</h1>
			<form method="post" action="./connexion">
				<div class="form-group">
					<label for="pseudo">Identifiant :</label> <input type="text" name="sidentifiant" class="form-control" required>
					<%-- <span class="erreur">${erreurs['pseudo']}</span> --%>
				</div>
				<div class="form-group">
					<div class="form-group ">
						<label for="password">Mot de passe :</label> <input type="password" name="smotdepasse" class="form-control"required>
					</div>
				</div>
				<button type="submit" name="ssubmit" class="btn btn-primary"
					value="Connexion">Connexion</button>
				<br> <font color="red"><%=request.getAttribute("messageErreur") != null ? request.getAttribute("messageErreur") : ""%></font>

				<div class="checkbox">
					<label><input type="checkbox" value="">Se souvenir de moi</label>
				</div>
				<div class="form-group"> <a href="https://example.com">Mot de passe oublié</a>
				</div>
			</form>
<!-- MOT DE PASSE OUBLIE>> AHREF A METTRE A JOUR -->
		</div>
	</div>


	<!-- 		container pour creer compte, toujours pareil ça ne fmarche pas dans le form -->

	<div class="from-group col-md-2 col-md-offset-5">
		<!-- 	bouton creer compte sorti du form ci dessus car le lien ne marchait pas, gregoyr m'a dit que ça devrai marcher...bizarre -->
		<br> <a href="./Profil"> <input type="submit"
			class="btn btn-primary btn-lg" value="Créer un compte"></a>
	</div>


	<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>