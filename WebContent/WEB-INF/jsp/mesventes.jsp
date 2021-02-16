<%@page import="fr.eni.projetEnchere.bo.Categorie"%>
<%@page import="java.util.List"%>
<%@ page import="fr.eni.projetEnchere.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/style.css">

<title>Liste des enchères</title>
</head>
<body>
	<%
// je récupère la liste de catégorie
List<Categorie> categories = (List<Categorie>)request.getAttribute("listeCategorie");
%>
	<a href="">Enchères</a>
	<a href="./VendreArticle">Vendre un Article</a>
	<a href="./MonProfil">Mon profil</a>
	<a href="./seDeconnecter">Déconnexion</a>
	
	<h1>Liste des enchères mes ventes.jsp</h1>
	
	<p>Filtres</p>
	<form method="post" action=>
		<div class="col-sm-4">
		
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-search"></i></span> <input type="text"
					class="form-control" name="srecherche"
					placeholder="Le nom de l'article contient">
			</div>
		
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
				
	<p>Checkbox Mes Ventes</p>	
	</div>
	<input type="submit" value="Enregistrer"class="btn btn-primary"> 
	
	</form>

	

	<div class="col-sm-6">
		<%
		String nomUtilisateur = "";
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateurConnecte");
		if (u != null) {
			nomUtilisateur = u.getPrenom();
		}
		%>
		<%=nomUtilisateur%>

		<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>