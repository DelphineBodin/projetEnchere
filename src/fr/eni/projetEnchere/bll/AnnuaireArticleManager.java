package fr.eni.projetEnchere.bll;



import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
		//Verification mise � prix est sup�rieur � 0 et inf�rieur � 15 000 �
		if(article.getMiseAPrix()<=0){
			messageErreur.append("La mise � prix doit �tre sup�rieur ou �gale � 0.\n");
			venteValide=false;
		}
		if(article.getMiseAPrix()>15000){
			messageErreur.append("La mise � prix doit �tre inf�rieur � 15 000�.\n(voir nos conditions g�n�rales)\n");
			venteValide=false;
		}
		if(article.getDateDebutEncheres().isBefore(LocalDate.now())){
			messageErreur.append("La date de d�but d'ench�re ne doit pas �tre dans le pass�\n");
			venteValide=false;
		}
		if(article.getDateDebutEncheres().isAfter(LocalDate.now().plusDays(45))){
			messageErreur.append("La date de d�but d'ench�re ne doit pas �tre dans plus de 45 jours\n(voir nos conditions g�n�rales)\\n");
			venteValide=false;
		}
		if(article.getDateFinEncheres().isBefore(article.getDateDebutEncheres())) {
			messageErreur.append("La date de fin d'ench�re doit �tre apr�s la date de d�but d'ench�re\n");
			venteValide=false;
		}
		long nbdejours = ChronoUnit.DAYS.between(article.getDateDebutEncheres(),article.getDateFinEncheres());
		System.out.println(nbdejours);
		if(nbdejours>45) {
			messageErreur.append("La date de fin d'ench�re doit �tre dans les 45 jours apr�s la date de d�but d'ench�re\n");
			venteValide=false;
		}
		System.out.println(nbdejours);
		// A voir ?
		// par d�faut le champs retrait affichera l'adresse de l'utilisateur. Si un champs est modifi�
		// on cr��ra un nouveau lieu de retrait// les 3 champs doivent imp�rativement �tre rempli
		if(!venteValide) {
			throw new BLLException(messageErreur.toString());
		}
		return venteValide;
	}
	// m�thode cr�er une vente si elle est valide
	public void nouvelleVente(ArticleVendu article, Utilisateur utilisateur, Categorie categorie,Retrait retrait) throws BLLException {
		validerVente(article,  utilisateur,  categorie, retrait);
		try {
			this.articleDao.nouvelleVente( article,  utilisateur,  categorie, retrait);
		} catch (DALException e) {
			throw new BLLException("Echec Insertion vente",e);
		}
			
	}

}
