package fr.eni.projetEnchere.dal;

import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Utilisateur;

public interface ArticleDAO {

void ajouterArticle(ArticleVendu a, Utilisateur u,Categorie c) throws DALException;	
	
}
