<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon Profil</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/style.css">
<!-- <link rel="stylesheet" href="/projetEnchere/theme/css/default.css"> -->

<!--  Bootstrap Date-Picker Plugin -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

</head>
<body>
<div class="container">
	<div class="row">
		<h1>Mon profil</h1>
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
					<label for="prenom">Prénom :</label>
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
					<label for="tel">Teléphone :</label>
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
		<a href="/servlet/ServletDemarrage"><input type="submit" class="btn btn-primary" value="Annuler"></a>
		<font color="red"><%=request.getAttribute("messageErreur")!=null?request.getAttribute("messageErreur"):"" %></font>
	</div>
</div>


	


	

</body>
</html>