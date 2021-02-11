<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion Utilisateur</title>
</head>
<body>

	<h1>Page de connexion, titre a retirer ensuite</h1>

	<form action="./connexion" method="post">
		<table>
			<tr>
				<td>Identifiant:</td>
				<td><input name="sidentifiant" placeholder="NineJea"
					type="text"></td>
			</tr>
			<tr>
				<td>Mot de Passe:</td>
				<td><input name="smotdepasse" placeholder="******" type="text"></td>
			</tr>
		</table>

		<button type="submit" name="ssubmit" value="Connexion">


			<!-- 		<input type="checkbox" name="ssouvenirdemoi">Se souvenir de moi</input> -->

			<!-- 		<input type="submit" name="screeruncompte" value="Créer un compte"> -->
	</form>

</body>
</html>