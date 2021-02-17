<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">
<%@ include file="../fragments/header.jspf" %>
<title>Connexion Utilisateur</title>
</head>
<body>
	<%
		String messageErreur = (String) request.getAttribute("messageErreur");
	%>
	<div class="container col-md-offset-4">
		<div class="row">
			<h1></h1>
			<form method="post" action="./connexion" class="form-inline">
				<div class="form-group col-md-12">
					<label for="pseudo">Identifiant :</label> 
					<input type="text" name="sidentifiant" class="form-control" required>
				</div>
				<div class="form-group col-md-12">
					<label for="password">Mot de passe :</label> 
					<input type="password" name="smotdepasse" class="form-control"required>
				</div>
				<br>
				<div class="form-group col-md-2">
					<button type="submit" name="ssubmit" class="btn btn-primary btn-lg" value="Connexion">Connexion</button>
					<font color="red"><%=request.getAttribute("messageErreur") != null ? request.getAttribute("messageErreur") : ""%></font>
				</div>
			</form>
			<div class="form-group col-md-4">			
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
					<label>Se souvenir de moi</label>
					<br>
<!-- MOT DE PASSE OUBLIE>> AHREF A METTRE A JOUR -->
					<a href="">Mot de passe oubli�</a>
				</div>
			</div>
		</div>
		<br>
		<div class=boutton-creer-compte>
			<a href="./Profil"> 
				<input type="submit" class="btn btn-primary btn-lg" value="Cr�er un compte">
			</a>
		</div> 
	</div>
	<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>