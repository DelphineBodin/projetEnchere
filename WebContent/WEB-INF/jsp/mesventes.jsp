<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="fr.eni.projetEnchere.bo.Utilisateur" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des enchères</title>
</head>
<body>

<a href="./VendreArticle">Vendre un Article</a>
<h1>Liste des enchères</h1>
<p> Filtres </p>
<p> Checkbox Mes Ventes </p>
<%
String nomUtilisateur="";
Utilisateur u =(Utilisateur)session.getAttribute("utilisateurConnecte");
if(u!=null){
nomUtilisateur = u.getPrenom();}
%>
<%=nomUtilisateur %>


</body>
</html>