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
	<table>
		<tr>
			<td>Identifiant:</td>
			<td><input name="sidentifiant" placeholder="NineJea" type="text"></td>
		</tr>
		<tr>
			<td>Mot de Passe:</td>
			<td><input name="smotdepasse" type="password"></td>
		</tr>
	</table>

	<button type="submit" name="ssubmit" value="Connexion">Connexion</button>


	<!-- 		<input type="checkbox" name="ssouvenirdemoi">Se souvenir de moi</input> -->

	</form>


	<a href="./ProfilDe"><input type="submit" value="Créer un compte"></a>


	<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>