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
String messageErreur=(String)request.getAttribute("messageErreur"); 
%>

	<form method="post" action="./connexion">
		<table>
			<tr>
				<td>Identifiant:</td>
				<td><input name="sidentifiant" placeholder="NineJea"
					type="text"></td>
			</tr>
			<tr>
				<td>Mot de Passe:</td>
				<td><input name="smotdepasse" type="password"></td>
			</tr>
		</table>
		<button type="submit" name="ssubmit" value="Connexion">Connexion</button>
	</form>
	<a href="./ProfilDe"><input type="submit" value="Créer un compte"></a><br>
	<font color="red"><%=request.getAttribute("messageErreur")!=null?request.getAttribute("messageErreur"):"" %></font>
	<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>