<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="fr.eni.projetEnchere.bo.Categorie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">
<%@ include file="../fragments/header.jspf" %>
<title>Listes des encheres</title>
</head>
<body>
				<!-- //////////////PAGE 1/13\\\\\\\\\\\\\\\ -->

	<a href="./connexion">Se connecter S'inscrire</a>
	<h1>Liste des enchères</h1>
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
				
	<p>Checkbox Mes Ventes</p>	
	</div>
	<input type="submit" value="Enregistrer"class="btn btn-primary"> 
	
	</form>

	

<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>