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
						<input type="text" name="pseudo" class="form-control" size="20" maxlength="20" placeholder="${utilisateurConnecte.pseudo}"required>
					</div>
					<div class="form-group col-md-6">
						<label for="nom">Nom : </label>
						<input type="text" name="nom" class="form-control" size="30" maxlength="30" placeholder="${utilisateurConnecte.nom}" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="prenom">Pr�nom : </label>
						<input type="text" name="prenom" class="form-control" size="30" maxlength="30" placeholder="${utilisateurConnecte.prenom}" required>
					</div>
					<div class="form-group col-md-6">
						<label for="email">Email : </label>
						<input type="email" name="email" class="form-control" size="20" maxlength="20" placeholder="${utilisateurConnecte.email}" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="tel">Tel�phone :</label>
						<input type="text" name="tel" class="form-control" size="10" maxlength="10" placeholder="${utilisateurConnecte.telephone}" required>
					</div>
					<div class="form-group col-md-6">
						<label for="rue">Rue :</label>
						<input type="text" name="rue" class="form-control" size="50" maxlength="50"placeholder="${utilisateurConnecte.rue}" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="codePostal">Code postal :</label>
						<input type="text" name="codePostal" class="form-control" size="5" maxlength="5" placeholder="${utilisateurConnecte.codePostal}" required>
					</div>
					<div class="form-group col-md-6">
						<label for="ville">Ville :</label>
						<input type="text" name="ville" class="form-control" placeholder="${utilisateurConnecte.ville}"required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="password">Mot de passe actuel :</label>
						<input type="password" name="password" class="form-control" placeholder="xxxxxxxxxxxxx" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="passwordNew">Nouveau mot de passe :</label>
						<input type="password" name="passwordNew" class="form-control" placeholder="xxxxxxxxxxxxx" required>
					</div>
					<div class="form-group col-md-6">
				  		<label for="passwordNewConfirm">Confirmation :</label>
						<input type="password" name="passwordNewConfirm" class="form-control" placeholder="xxxxxxxxxxxxx" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="credit">Cr�dit</label>
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