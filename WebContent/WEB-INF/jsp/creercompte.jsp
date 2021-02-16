<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon Profil</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">
<!-- <link rel="stylesheet" href="/projetEnchere/theme/css/default.css"> -->


</head>
<body>
<div class="container">
	<div class="row">
		<h1>Mon profil</h1>
		<div>
			<form method="post" action="./Profil">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="pseudo">Pseudo :</label>
						<input type="text" name="pseudo" class="form-control">
						<%-- <span class="erreur">${erreurs['pseudo']}</span> --%>
					</div>
					<div class="form-group col-md-6">
						<label for="nom">Nom :</label>
						<input type="text" name="nom" class="form-control">
						<%-- <span class="erreur">${erreurs['nom']}</span> --%>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="prenom">Pr�nom :</label>
						<input type="text" name="prenom" class="form-control">
						<%-- <span class="erreur">${erreurs['prenom']}</span> --%>
					</div>
					<div class="form-group col-md-6">
						<label for="email">Email :</label>
						<input type="email" name="email" class="form-control" size="20" maxlength="20">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="tel">Tel�phone :</label>
						<input type="text" name="tel" class="form-control">
					</div>
					<div class="form-group col-md-6">
						<label for="rue">Rue :</label>
						<input type="text" name="rue" class="form-control">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="codePostal">Code postal :</label>
						<input type="text" name="codePostal" class="form-control">
					</div>
					<div class="form-group col-md-6">
						<label for="ville">Ville :</label>
						<input type="text" name="ville" class="form-control">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="password">Mot de passe :</label>
						<input type="password" name="password" class="form-control">
				</div>
				<div class="form-group col-md-6">
				  		<label for="passwordConfirm">Confirmation :</label>
						<input type="password" name="passwordConfirm" class="form-control">
					</div>
				</div>
				<br>
				<input type="submit" class="btn btn-primary" value="Enregistrer">
			</form>
			<a href="./ListesDesEncheres"><input type="submit" class="btn btn-primary" value="Annuler"></a>
		</div>
		<br>
		<font color="red"><%=request.getAttribute("messageErreur")!=null?request.getAttribute("messageErreur"):"" %></font>
	</div>
</div>


</body>
		<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</html>