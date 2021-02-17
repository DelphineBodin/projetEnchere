<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">

<title>Liste des enchères</title>
</head>
<body>

	<a href="">Enchères</a>
	<a href="./VendreArticle">Vendre un Article</a>
	<a href="./AfficherProfil">Mon profil</a>
	<a href="./seDeconnecter">Déconnexion</a>
	
	<h1>Liste des enchères mes ventes.jsp</h1>
	<c:if test="${messageValidation!=null}">
					<font color="green"><c:out value="${messageValidation}"/></font>
	</c:if>
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
							<c:forEach items="${ categories }" var="cate">
							<option value="<c:out value="${cate.noCategorie}"/>"><c:out value="${cate.libelle}"/></option>
   							</c:forEach>
						</select>
					</div>
				</div>
				<br>
				<br>
				


	<input type="submit" value="Enregistrer"class="btn btn-primary"> 
	
	</form>
<!-- 	j'essaie de mettre ça ds un container mais il aime pas, don j'essaie de les mettre en ligne -->
<div class="row">

	<div class="form-check">
  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
  <label class="form-check-label" for="flexRadioDefault1">Achats</label>
</div>

	<div class="form-check">
  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
  <label class="form-check-label" for="flexRadioDefault1">Mes Ventes</label>
</div>

<div class="checkbox">
  <label><input type="checkbox" value="">encheres ouvertes</label>
</div>
<div class="checkbox">
  <label><input type="checkbox" value="" >mes encheres</label>
</div>
<div class="checkbox disabled">
  <label><input type="checkbox" value="" >encheres remportées</label>
</div>
	
<!-- 	TROUVER MOYEN DE METTRE CHECKBOX EN 2 COLONNES -->
	<div class="checkbox">
  <label><input type="checkbox" value="">encheres ouvertes</label>
</div>
<div class="checkbox">
  <label><input type="checkbox" value="" >mes encheres</label>
</div>
<div class="checkbox disabled">
  <label><input type="checkbox" value="" >mes encheres remportees</label>
</div>
	</div>

	

	<div class="col-sm-6">
		<%
		String nomUtilisateur = "";
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateurConnecte");
		if (u != null) {
			nomUtilisateur = u.getPrenom();
		}
		%>
		<%=nomUtilisateur%>
<!-- 		fermeture de div rajouté, a regarder si probleme -->
		</div>
	

		<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>