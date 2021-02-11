package fr.eni.projetEnchere.bll;



import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
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
	if(article.getNomArticle()==null || article.getNomArticle().trim().isEmpty()) {
		messageErreur.append("Le nom de l'article vendu est obligatoire.\n");
		venteValide=false;
	}
	// champs article,Description,miseAprix,les 2 dates ne doivent pas être null
	// la date de fin d'enchère doit être après la date de début délai min ?
	// la date de début ne doit pas être avant aujourd'hui et elle doit être dans les 3 prochains mois
	// le prix ne peut être négatif et il ne peut être supérieur à 1000 €
	// la catégorie doit déjà exister
	// par défaut le champs retrait affichera l'adresse de l'utilisateur. Si un champs est modifié
	// on crééra un nouveau lieu de retrait// les 3 champs doivent impérativement être rempli
		
		return venteValide;
	}
	// méthode créer une vente si elle est valide
	public void nouvelleVente(ArticleVendu article, Utilisateur utilisateur, Categorie categorie,Retrait retrait) throws BLLException {
		if(validerVente(article,  utilisateur,  categorie, retrait)) {
			try {
				this.articleDao.nouvelleVente( article,  utilisateur,  categorie, retrait);
			} catch (DALException e) {
				throw new BLLException("Echec d'insertion de la nouvelle vente",e);
			}// fin du catch
		}else {/// doit t'on vraiment prévoir ce else ???!!!
			System.out.println("Cette Vente n'est pas valide");
		}
	}
	
	}
