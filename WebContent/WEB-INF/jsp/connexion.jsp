<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion Utilisateur</title>
</head>
<body>

	
	<form action="./connexion" method="post">
	<table>
			<tr>
				<td>Identifiant:</td>
				<td><input name="sidentifiant" placeholder="NineJea"type="text"></td>
			</tr>
			<tr>
				<td>Mot de Passe:</td>
				<td><input name="smotdepasse" type="password"></td>
			</tr>
		</table>

		<button type="submit" name="ssubmit" value="Connexion">Connexion</button>


			<!-- 		<input type="checkbox" name="ssouvenirdemoi">Se souvenir de moi</input> -->

		</form>
		
		<a href="./ProfilDe"><input type="submit" value="Créer un compte" ></a>

</body>
</html>