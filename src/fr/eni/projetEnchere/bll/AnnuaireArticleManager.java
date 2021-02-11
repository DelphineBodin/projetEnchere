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

	// Constructeur priv� pour mise en place du pattern Singleton	
	private AnnuaireArticleManager() {
		articleDao= FactoryDAO.getArticleDao();
	}
	
	// M�thode pour cr�er une seule base d'article de vente
	public static AnnuaireArticleManager getInstance() {
		if(annuaire==null) {
			annuaire=new AnnuaireArticleManager();
		}
		return annuaire;
	}
	// m�thode valider vente - A faire choisir les r�gles m�tiers
	public boolean validerVente(ArticleVendu article, Utilisateur utilisateur, Categorie categorie,Retrait retrait) throws BLLException {
	StringBuilder messageErreur = new StringBuilder();
	boolean venteValide = true;
			// R�gle m�tier
	// article utilisateur et catagorie ne doivent pas �tre null et retrait ?
	if(article==null||utilisateur==null||categorie==null)	{
		throw new BLLException("Article ou utilisateur ou categorie sont null");
	}
	if(article.getNomArticle()==null || article.getNomArticle().trim().isEmpty()) {
		messageErreur.append("Le nom de l'article vendu est obligatoire.\n");
		venteValide=false;
	}
	// champs article,Description,miseAprix,les 2 dates ne doivent pas �tre null
	// la date de fin d'ench�re doit �tre apr�s la date de d�but d�lai min ?
	// la date de d�but ne doit pas �tre avant aujourd'hui et elle doit �tre dans les 3 prochains mois
	// le prix ne peut �tre n�gatif et il ne peut �tre sup�rieur � 1000 �
	// la cat�gorie doit d�j� exister
	// par d�faut le champs retrait affichera l'adresse de l'utilisateur. Si un champs est modifi�
	// on cr��ra un nouveau lieu de retrait// les 3 champs doivent imp�rativement �tre rempli
		
		return venteValide;
	}
	// m�thode cr�er une vente si elle est valide
	public void nouvelleVente(ArticleVendu article, Utilisateur utilisateur, Categorie categorie,Retrait retrait) throws BLLException {
		if(validerVente(article,  utilisateur,  categorie, retrait)) {
			try {
				this.articleDao.nouvelleVente( article,  utilisateur,  categorie, retrait);
			} catch (DALException e) {
				throw new BLLException("Echec d'insertion de la nouvelle vente",e);
			}// fin du catch
		}else {/// doit t'on vraiment pr�voir ce else ???!!!
			System.out.println("Cette Vente n'est pas valide");
		}
	}
	
	}
