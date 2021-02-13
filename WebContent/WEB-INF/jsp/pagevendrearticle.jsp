<%@page import="jdk.internal.misc.FileSystemOption"%>
<%@page import="fr.eni.projetEnchere.bo.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle vente</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--  jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<link rel="stylesheet"
	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/style.css">

<!--  Bootstrap Date-Picker Plugin -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

</head>
<body>
	<%
// je récupère la liste de catégorie
List<Categorie> categories = (List<Categorie>)request.getAttribute("listeCategorie");
%>

	<div class="container">
		<div class="row">
			<h1>Nouvelle vente</h1>
			<br>
			<form class="form-horizontal" method="post" action="./VendreArticle">
				<div class="form-group">
					<label class="control-label col-sm-2">Article</label>
					<div class="col-sm-6">
						<input type="text" name="sarticle" class="form-control">
					</div>
				</div>
				<br>
				<div class="form-group">
					<label class="control-label col-sm-2">Description </label>
					<div class="col-sm-6">
						<textarea rows="5" cols="20" name="sdescription"
							class="form-control"></textarea>
					</div>
					<br>
				</div>;
				<br>
				<div class="form-group">
					<label class="control-label col-sm-2" for="sel1">Categorie</label>
					<div class="col-sm-6">
						<select name="scategorie" class="form-control" id="sel1">
	<%
		if(categories==null || categories.isEmpty()){
	%>
							<option value="0">Aucune Catégorie</option>
	<%
	}else{
	for(Categorie c :categories)
	{
	%>
							<option value="<%=c.getNoCategorie()%>"><%=c.getLibelle()%></option>
	<% 
	}
	}
	%>
						</select>
					</div>
				</div>
				<br>
				<div class="form-group">
					<label class="control-label col-sm-2">Photo de l'article</label>
					<button class="btn btn-secondary">UPLOADER</button>
					<br>
				</div>
				<br>
				<div class="form-group">
					<label class="control-label col-sm-2">Mise à prix</label>
					<div class="col-sm-6">
						<input type="number" name="sprix" class="form-control" min="0" max="15000"><br>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Début de l'enchere</label>
					<div class="col-sm-6">
						<input type="date" class="form-control" name="sdateDebut">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Fin de l'enchere</label>
					<div class="col-sm-6">
						<input class="form-control" id="date" name="sdateFin" type="date">
					</div>
				</div>
				<fieldset class="scheduler-border">
					<legend class="scheduler-border">Retrait</legend>
					<div class="form-group">
						<label class="control-label col-sm-2">Rue</label>
						<div class="col-sm-6">
							<input type="text" name="sarticle" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Code postal</label>
						<div class="col-sm-6">
							<input type="text" name="sarticle" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Ville</label>
						<div class="col-sm-6">
							<input type="text" name="sarticle" class="form-control">
						</div>
					</div>
				</fieldset>
				<br> <input type="submit" value="Enregistrer"
					class="btn btn-primary"> <a href="allerà la page avant"><input
					type="submit" class="btn btn-primary" value="Annuler"></a>
			</form>
		</div>
	</div>


	<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>