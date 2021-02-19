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
<%-- <%@ include file="../fragments/header.jspf" %> --%>
<title>Liste des ench�res</title>
</head>
<body>
				<!-- //////////////PAGE 4/13\\\\\\\\\\\\\\\ -->
	<div class="container col-md-offset-1 col-md-10">
		<div class = "col-md-3">
			<div class="logo">
				<a href="./ListesDesEncheres" title="retour accueil"><img src="./images/logo_small.png" width="220" height=auto alt="logoENIecole"/></a>
			</div>
		</div>
		<nav class = "col-md-9">
			<ul>
				<div class="col-md-2" style="color:tomato; font-size:18px;">
					<%
					String nomUtilisateur = "";
					Utilisateur u = (Utilisateur) session.getAttribute("utilisateurConnecte");
					if (u != null) {
						nomUtilisateur = u.getPrenom();
					}
					%>
					<%=nomUtilisateur%>
				</div>
				<li><a href="">Ench�res</a></li>
				<li><a href="./VendreArticle">Vendre un Article</a></li>
				<li><a href="./AfficherProfil">Mon profil</a></li>
				<li><a href="./seDeconnecter">D�connexion</a></li>
			</ul>
		</nav>
	
	
	<h1 class= "col-md-12">Liste des ench�res</h1>
		<c:if test="${messageValidation!=null}">
						<font color="green"><c:out value="${messageValidation}"/></font>
		</c:if>
		<c:if test="${messageValidationProfil!=null}">
			 <font color="green"><c:out value="${messageValidationProfil}"/></font>
		</c:if>
	<h2 class= "col-md-offset-1 col-md-11">Filtres</h2>
		<form method="post" action=>
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
				<div>
					<div class="form-check col-md-offset-1 col-md-5">
						<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
						<label class="form-check-label" for="flexRadioDefault1">Achats</label>
						<div>
							<div class="checkbox">
								<label><input type="checkbox" value="">encheres ouvertes</label>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" value="" >mes encheres</label>
							</div>
							<div class="checkbox disabled">
								<label><input type="checkbox" value="" >encheres remport�es</label>
							</div>
						</div>
					</div>
					<div class="form-check col-md-5">
						<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
						<label class="form-check-label" for="flexRadioDefault1">Mes Ventes</label>
						<div>
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
					</div>
				</div>
			</div>
		</form>
		<br>
		<br>
		<div class="col-md-1">
		</div>
		<div class="col-md-3">
			<button type="submit" class="col-md-12 btn btn-primary btn-lg"> Rechercher </button>
		</div>
		<div class="col-md-1">
		</div>
		<div class="col-md-5">
			<br>
		</div>
		<div class="col-md-offset-2 col-md-3" style="color:tomato; font-size:18px;">
			<%
			String nomUtilisateurB = "";
			Utilisateur u2 = (Utilisateur) session.getAttribute("utilisateurConnecte");
			if (u2 != null) {
				nomUtilisateurB = u.getPrenom();
			}
			%>
			<p> Bienvenue :  <%=nomUtilisateurB%> </p>
		</div>
	</div>

<!-- //////////////2�me partie\\\\\\\\\\\\\\\ -->	
	<div class="container col-md-offset-1 col-md-10">
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
							<p>ANNONCE ____</p>
						</div>
						<br>
						<div class="annoncePrix">
							<p>Prix :</p>
						</div>
						<div class="annonceDate">
							<p>Fin de l'ench�re :</p>
						</div>
						<br>
						<div class="annonceVendeur">
							<p>Vendeur : </p>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		
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
							<p>ANNONCE ____</p>
						</div>
						<br>
						<div class="annoncePrix">
							<p>Prix :</p>
						</div>
						<div class="annonceDate">
							<p>Fin de l'ench�re :</p>
						</div>
						<br>
						<div class="annonceVendeur">
							<p>Vendeur : </p>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>