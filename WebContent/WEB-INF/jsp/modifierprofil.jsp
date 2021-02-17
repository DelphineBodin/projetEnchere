<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier mon profil</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">
</head>
<body>
				<!-- //////////////PAGE 8/13\\\\\\\\\\\\\\\ -->
<div class="container">
	<div class="row">
		<h1>Mon profil</h1>
		<div>
			<form method="post" action="" class="form-inline">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="pseudo">Pseudo : </label>
						<input type="text" name="pseudo" class="form-control" required>
					</div>
					<div class="form-group col-md-6">
						<label for="nom">Nom : </label>
						<input type="text" name="nom" class="form-control" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="prenom">Prénom : </label>
						<input type="text" name="prenom" class="form-control" required>
					</div>
					<div class="form-group col-md-6">
						<label for="email">Email : </label>
						<input type="email" name="email" class="form-control" size="20" maxlength="20" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="tel">Teléphone :</label>
						<input type="text" name="tel" class="form-control" required>
					</div>
					<div class="form-group col-md-6">
						<label for="rue">Rue :</label>
						<input type="text" name="rue" class="form-control" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="codePostal">Code postal :</label>
						<input type="text" name="codePostal" class="form-control" required>
					</div>
					<div class="form-group col-md-6">
						<label for="ville">Ville :</label>
						<input type="text" name="ville" class="form-control" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="password">Mot de passe actuel :</label>
						<input type="password" name="password" class="form-control" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="passwordNew">Nouveau mot de passe :</label>
						<input type="password" name="passwordNew" class="form-control" required>
					</div>
					<div class="form-group col-md-6">
				  		<label for="passwordNewConfirm">Confirmation :</label>
						<input type="password" name="passwordNewConfirm" class="form-control" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="credit">Crédit</label>
						${utilisateurConnecte.credit}
					</div>
				</div>
				<br>
				<div class="form-row">
					<div class="form-group col-md-2">
						<button type="submit" class="btn btn-primary">Enregistrer</button>
					</div>
				</div>
			</form>
			<a href=""><button type="submit" class="btn btn-primary">Supprimer mon compte</button></a>
		</div>
		<br>
		<font color="red"><%=request.getAttribute("messageErreur")!=null?request.getAttribute("messageErreur"):"" %></font>
	</div>
</div>			


</body>
</html>