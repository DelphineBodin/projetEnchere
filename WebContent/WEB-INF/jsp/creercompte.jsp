<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon Profil</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" href="/projetEnchere/theme/css/style.css"> -->
<link rel="stylesheet" href="/projetEnchere/theme/css/default.css">

<!--  Bootstrap Date-Picker Plugin -->
<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script> -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/> -->

</head>
<body>
<header>
	<h1>Mon profil</h1>
</header>
	<div class="form_inscription">
		<form  method="post" action="./VendreArticle">
			<div class="saisie_inscription">
				<div class="col_right">
					<ul>
						<li>
							<label for="formulaire pseudo"><b>Pseudo :</b></label>
							<input id="pseudo" type="text" name="pseudo" placeholder="#67%">
						</li>
					</ul>
					<ul>
						<li>
							<label for="formulaire prenom"><b>Prénom :</b></label>
							<input id="prenom" type="text" name="prenom" placeholder="#67%">
						</li>
					</ul>
					<ul>
						<li>
							<label for="formulaire telephone"><b>Telephone :</b></label>
							<input id="telephone" type="tel" name="telephone" placeholder="#67%">
						</li>
					</ul>
					<ul>
						<li>
							<label for="formulaire code_postal"><b>Code Postal :</b></label>
							<input id="code_postal" type="text" name="code_postal" placeholder="#67%">
						</li>
					</ul>
					<ul>
						<li>
							<label for="formulaire mdp"><b>Mot de passe :</b></label>
							<input id="mdp" type="password" name="mdp" placeholder="#67%">
						</li>
					</ul>
				</div>
				<div class="col_left">
					<ul>
						<li>
							<label for="formulaire nom"><b>Nom :</b></label>
							<input id="nom" type="text" name="nom" placeholder="#67%">
						</li>
					</ul>
					<ul>
						<li>
							<label for="formulaire email"><b>Email :</b></label>
							<input id="email" type="email" name="email" placeholder="#67%">
						</li>
					</ul>
					<ul>
						<li>
							<label for="formulaire rue"><b>Rue :</b></label>
							<input id="rue" type="text" name="rue" placeholder="#67%">
						</li>
					</ul>
					<ul>
						<li>
							<label for="formulaire ville"><b>Ville :</b></label>
							<input id="ville" type="text" name="ville" placeholder="#67%">
						</li>
					</ul>
					<ul>
						<li>
							<label for="formulaire mdp_confirm"><b>Confirmation :</b></label>
							<input id="mdp_confirm" type="password" name="mdp_confirm" placeholder="#67%">
						</li>
					</ul>
				</div>
			</div>
			<div class="bouton_inscription ">
				<button type="submit" name="creer">Envoyer</button>
				<button type="submit" name="annuler">Annuler</button>
			</div>
	
		</form>
	</div>
	

</body>
</html>