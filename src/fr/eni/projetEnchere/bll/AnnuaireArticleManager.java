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
		//Verification mise à prix est supérieur à 0 et inférieur à 15 000 €
		if(article.getMiseAPrix()<=0){
			messageErreur.append("La mise à prix doit être supérieur ou égale à 0.\n");
			venteValide=false;
		}
		if(article.getMiseAPrix()>15000){
			messageErreur.append("La mise à prix doit être inférieur à 15 000€.\n(voir nos conditions générales)\n");
			venteValide=false;
		}
		if(article.getDateDebutEncheres().isBefore(LocalDate.now())){
			messageErreur.append("La date de début d'enchère ne doit pas être dans le passé\n");
			venteValide=false;
		}
		if(article.getDateDebutEncheres().isAfter(LocalDate.now().plusDays(45))){
			messageErreur.append("La date de début d'enchère ne doit pas être dans plus de 45 jours\n(voir nos conditions générales)\\n");
			venteValide=false;
		}
		if(article.getDateFinEncheres().isBefore(article.getDateDebutEncheres())) {
			messageErreur.append("La date de fin d'enchère doit être après la date de début d'enchère\n");
			venteValide=false;
		}
		long nbdejours = ChronoUnit.DAYS.between(article.getDateDebutEncheres(),article.getDateFinEncheres());
		System.out.println(nbdejours);
		if(nbdejours>45) {
			messageErreur.append("La date de fin d'enchère doit être dans les 45 jours après la date de début d'enchère\n");
			venteValide=false;
		}
		System.out.println(nbdejours);
		// A voir ?
		// par défaut le champs retrait affichera l'adresse de l'utilisateur. Si un champs est modifié
		// on crééra un nouveau lieu de retrait// les 3 champs doivent impérativement être rempli
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

}
