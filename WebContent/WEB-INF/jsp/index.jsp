<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.HashMap"%>
<%@page import="fr.eni.projetEnchere.bo.Categorie"%>
<%@page import="fr.eni.projetEnchere.bo.ArticleVendu"%>
<%@page import="fr.eni.projetEnchere.bo.Utilisateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">
<%-- <%@ include file="../fragments/header.jspf" %> --%>
<title>Listes des encheres</title>
</head>
<body>
				<!-- //////////////PAGE 1/13\\\\\\\\\\\\\\\ -->
				
	<!-- //////////////1er partie\\\\\\\\\\\\\\\ -->	
	<div class="container col-md-offset-1 col-md-10">
			<div class= "col-md-12">
				<div class = "col-md-4">
					<div class="logo">
						<a href="./ListesDesEncheres" title="retour accueil"><img src="./images/logo_small.png" width="220" height=auto alt="logoENIecole"/></a>
					</div>
				</div>
				<nav class = "col-md-offset-4 col-md-4">
					<ul>
						<li><a href="./connexion">Se connecter - S'inscrire</a></li>
					</ul>
				</nav>
			</div>
			<h1 class= "col-md-12">Liste des enchères</h1>
			<h2 class= "col-md-offset-1 col-md-11">Filtres</h2>
			<form method="post">
				<div class="col-md-1">
				</div>
				<div class="col-md-6">
					<div class="input-group col-md-12">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-search col-md-10"></i>
						</span> 
						<input type="text" class="form-control col-md-8" name="srecherche" placeholder="Le nom de l'article contient">
					</div>
					<br>
					<div class="col-md-12">
						<label class="control-label col-md-1">Categorie : </label>
						<div class="form-group col-md-6">
							<select name="scategorie" class="form-control" id="sel1">
									<c:forEach items="${ categories }" var="cate">
										<option value="<c:out value="${cate.noCategorie}"/>">
												<c:out value="${cate.libelle}"/>
										</option>
				   					</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-1">
				</div>
				<div class="col-md-3">
					<button type="submit" class="col-md-12 btn btn-primary btn-lg"> Rechercher </button>
				</div>
				<div class="col-md-1">
				</div>
				
			</form>
			
	<!-- //////////////espace\\\\\\\\\\\\\\\ -->	
	</div>
	<div class="container col-md-12">
		<br>
		<br>
	</div>
	<!-- //////////////2ème partie\\\\\\\\\\\\\\\ -->	
	<div class="container col-md-offset-1 col-md-10">
	
	
	  
      
   
	
	<c:forEach items="${listeArticles.entrySet().toArray()}" var="article">
			<div class="container col-md-5">
				<div class="annonceEnchereEnCours">
					<div class="col-md-5">
						<div class="annonceImg">
							<a href=""><img src="./images/annonceVoiture.jpg" width="100%" height=auto/></a>
						</div>
					</div>
					<div class="col-md-7">
						<div class="annonceText">
							<div class="annonceTitre">
								<p> ${article.key.nomArticle}</p>
								<p> ${article.key.description}</p>
							</div>
							<br>
							<div class="annoncePrix">
								<p>Prix :${article.key.miseAPrix} euros</p>
							</div>
							<div class="annonceDate">
								<p>Début de l'enchère : ${article.key.dateHeureDebutEncheres} </p>
							</div>
							<div class="annonceDate">
								<p>Fin de l'enchère : ${article.key.dateHeureFinEncheres} </p>
							</div>
							<br>
							<div class="annonceVendeur">
								<p>Vendeur : ${article.value.nom} ${article.value.prenom}</p>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		 </c:forEach>	
						
			${message}
		
	</div>
	
	<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>