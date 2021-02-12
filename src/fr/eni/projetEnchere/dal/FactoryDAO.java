package fr.eni.projetEnchere.dal;

import fr.eni.projetEnchere.dal.jdbc.ArticleDAOImpl;
import fr.eni.projetEnchere.dal.jdbc.UtilisateurDAOImpl;

public abstract class FactoryDAO {
	
//Notre place pour Fabriquer nos Classes implémentées ex Utilisateur(surrement) DAO qui crééra UtilisateurDAOJdbcImpl() 	

public static ArticleDAO getArticleDao() {
	return new ArticleDAOImpl();
}

public static UtilisateurDAO getUtilisateurDAO() {
	return new UtilisateurDAOImpl();
}

}
