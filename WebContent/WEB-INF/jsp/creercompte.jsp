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
		<form>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="formPseudo">Pseudo :</label>
					<input type="text" class="form-control">
				</div>
				<div class="form-group col-md-6">
					<label for="formNom">Nom :</label>
					<input type="text" class="form-control">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="formPrenom">Prénom :</label>
					<input type="text" class="form-control">
				</div>
				<div class="form-group col-md-6">
					<label for="formEmail">Email :</label>
					<input type="email" class="form-control">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="formTel">Teléphone :</label>
					<input type="text" class="form-control">
				</div>
				<div class="form-group col-md-6">
					<label for="formRue">Rue :</label>
					<input type="text" class="form-control">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="formCP">Code postal :</label>
					<input type="text" class="form-control">
				</div>
				<div class="form-group col-md-6">
					<label for="formVille">Ville :</label>
					<input type="text" class="form-control">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="formPassword">Mot de passe :</label>
					<input type="password" class="form-control">
			</div>
			<div class="form-group col-md-6">
			  		<label for="formPasswordConfirm">Confirmation :</label>
					<input type="password" class="form-control">
				</div>
			</div>
			<br> 
			<input type="submit" value="Enregistrer"class="btn btn-primary"> 
	  		<a href="/connexion">
	  			<input type="submit" class="btn btn-primary" value="Annuler">
	  		</a>
		</form>
	</div>
</div>


	


	

</body>
</html>