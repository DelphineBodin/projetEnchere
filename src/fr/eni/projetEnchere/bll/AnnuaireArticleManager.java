package fr.eni.projetEnchere.bll;



import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import java.util.HashMap;


import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.EtatVente;
import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.ArticleDAO;
import fr.eni.projetEnchere.dal.DALException;
import fr.eni.projetEnchere.dal.FactoryDAO;

public class AnnuaireArticleManager {

	private ArticleDAO articleDao;
	static AnnuaireArticleManager annuaire;

	// Constructeur privé pour mise en place du pattern Singleton	
	private AnnuaireArticleManager() {
		articleDao= FactoryDAO.getArticleDao();
	}

	// Méthode pour créer une seule base d'article de vente
	public static AnnuaireArticleManager getInstance() {
		if(annuaire==null) {
			annuaire=new AnnuaireArticleManager();
		}
		return annuaire;
	}
	// méthode valider vente - A faire choisir les régles métiers
	public boolean validerVente(ArticleVendu article, Utilisateur utilisateur, Categorie categorie,Retrait retrait) throws BLLException {
		StringBuilder messageErreur = new StringBuilder();
		boolean venteValide = true;
		// Régle métier
		// article utilisateur et catagorie ne doivent pas être null et retrait ?
		if(article==null||utilisateur==null||categorie==null)	{
			throw new BLLException("Article ou utilisateur ou categorie sont null");
		}
		//Verification champs nom (ou Article) n'est pas vide
		if(article.getNomArticle()==null || article.getNomArticle().trim().isEmpty()) {
			messageErreur.append("Le nom de l'article vendu est obligatoire.\n");
			venteValide=false;
		}
		//Verification champs description n'est pas vide
		if(article.getDescription()==null || article.getDescription().trim().isEmpty()) {
			messageErreur.append("La description de l'article vendu est obligatoire.\n");
			venteValide=false;
		}
		//Verification mise à prix est supérieur à 0 et inférieur à 50 000 €
		if(article.getMiseAPrix()<=0){
			messageErreur.append("La mise à prix doit être supérieur ou égale à 0.\n");
			venteValide=false;
		}
		if(article.getMiseAPrix()>50000){
			messageErreur.append("La mise à prix doit être inférieur à 15 000€.\n(voir nos conditions générales)\n");
			venteValide=false;
		}
		if(article.getDateHeureDebutEncheres().isBefore(LocalDateTime.now().minusMinutes(30))){
			messageErreur.append("La date de début d'enchère ne doit pas être dans le passé\n");
			venteValide=false;
		}
		if(article.getDateHeureDebutEncheres().isAfter(LocalDateTime.now().plusDays(45))){
			messageErreur.append("La date de début d'enchère ne doit pas être dans plus de 45 jours\n(voir nos conditions générales)\\n");
			venteValide=false;
		}
		if(article.getDateHeureFinEncheres().isBefore(article.getDateHeureDebutEncheres())) {
			messageErreur.append("La date de fin d'enchère doit être après la date de début d'enchère\n");
			venteValide=false;
		}
		long nbdejours = ChronoUnit.DAYS.between(article.getDateHeureDebutEncheres(),article.getDateHeureFinEncheres());
		if(nbdejours>45) {
			messageErreur.append("La date de fin d'enchère doit être dans les 45 jours après la date de début d'enchère\n");
			venteValide=false;
		}
		
		if(!venteValide) {
			throw new BLLException(messageErreur.toString());
		}
		return venteValide;
	}
	// méthode créer une vente si elle est valide
	public void nouvelleVente(ArticleVendu article, Utilisateur utilisateur, Categorie categorie,Retrait retrait) throws BLLException {
		validerVente(article,  utilisateur,  categorie, retrait);
		try {
			this.articleDao.nouvelleVente( article,  utilisateur,  categorie, retrait);
		} catch (DALException e) {
			throw new BLLException("Echec Insertion vente",e);
		}
	}
	
	
	public HashMap<ArticleVendu,Utilisateur> afficherVenteEnCours(int numeroCategorie,String nom) throws BLLException {
		HashMap <ArticleVendu,Integer> articles = new HashMap<ArticleVendu,Integer>();
		HashMap <ArticleVendu,Integer> articlesEnCours = new HashMap<ArticleVendu,Integer>();
		AnnuaireUtilisateurManager annuaireUtilisateur = AnnuaireUtilisateurManager.getInstance();
		try {
			articles=this.articleDao.selectArticlesByCategorieNom(numeroCategorie, nom);
			for(HashMap.Entry<ArticleVendu,Integer> monEntree : articles.entrySet()) {
				System.out.println("mon etat"+monEntree.getKey().getEtatVente());
				// Etat vente ne fonctionne pas A revoir en BO
				if(monEntree.getKey().getEtatVente()==EtatVente.EN_COURS) {
				articlesEnCours.put(monEntree.getKey(), monEntree.getValue());
			}
			}
		
		} catch (DALException e) {
			throw new BLLException("Echec de Sélection"+e);
		}
		// Test de ramener ici l'utilisateur Avec le tableau intial car etatVente ne fonctionne pas
		HashMap <ArticleVendu,Utilisateur> articlesAvecVendeur = new HashMap<ArticleVendu,Utilisateur>();
		for(HashMap.Entry<ArticleVendu,Integer> monEntree : articles.entrySet()) {
			articlesAvecVendeur.put(monEntree.getKey(),annuaireUtilisateur.getUtilisateur(monEntree.getValue()));
		}
		return articlesAvecVendeur;
	}
		
	}


