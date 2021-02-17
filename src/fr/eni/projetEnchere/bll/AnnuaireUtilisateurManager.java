package fr.eni.projetEnchere.bll;

import com.sun.org.apache.bcel.internal.generic.NEW;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.DALException;
import fr.eni.projetEnchere.dal.FactoryDAO;
import fr.eni.projetEnchere.dal.UtilisateurDAO;
import fr.eni.projetEnchere.dal.jdbc.UtilisateurDAOImpl;


// Class permettant de tester la confirmit� des utilisateurs avant leur transmission � la DAL
public class AnnuaireUtilisateurManager {

	private UtilisateurDAO daoUtilisateur;
	// ======>>>>>>Pourquoi static ???
	static AnnuaireUtilisateurManager annuaire;

	// Constructeur priv� pour mise en place du pattern Singleton	
	private AnnuaireUtilisateurManager() {
		this.daoUtilisateur = FactoryDAO.getUtilisateurDAO() ;
	}

	// M�thode pour cr�er une instance
	public static AnnuaireUtilisateurManager getInstance() {
		if(annuaire==null) {
			annuaire= new AnnuaireUtilisateurManager();
		}
		return annuaire;
	}

	//Ajout d'un utilisateur � notre application
	public boolean validerInscription(Utilisateur u) throws BLLException {
		StringBuilder messageErreur = new StringBuilder();
		boolean inscriptionValide = true;
		// R�gle m�tier :
		// L'utilisateur ne doit pas �tre null
		if(u==null)	{
			throw new BLLException("utilisateur est null");
		}
		// Le pseudo ne peut pas �tre vide et ne peut pas contenir d'espace
		if(u.getPseudo()==null || u.getPseudo().trim().isEmpty()) {
			messageErreur.append("Le pseudo est obligatoire et ne doit pas comporter d'espace\n");
			inscriptionValide = false;
		}
		
		if(u.getNom()==null || u.getNom().isEmpty()) {
			messageErreur.append("Le nom est obligatoire\n");
			inscriptionValide = false;
		}

		if(u.getPrenom()==null || u.getPrenom().isEmpty()) {
			messageErreur.append("Le prenom est obligatoire\n");
			inscriptionValide = false;
		}

		// limiter la taille des caract�res � 20
		if(u.getEmail()==null || u.getEmail().trim().isEmpty()) {
			messageErreur.append("L'adresse email est obligatoire et ne doit pas comporter d'espace\n");
			inscriptionValide = false;
		}

		if(u.getTelephone()==null || u.getTelephone().trim().isEmpty()) {
			messageErreur.append("Le numero de telephone est obligatoire et ne doit pas comporter d'espace\n");
			inscriptionValide = false;
		}

		if(u.getRue()==null || u.getRue().isEmpty()) {
			messageErreur.append("La rue est obligatoire\n");
			inscriptionValide = false;
		}

		// limiter la taille des caract�res � 5 et que des chiffres
		if(u.getCodePostal()==null || u.getCodePostal().trim().isEmpty()) {
			messageErreur.append("Le code postal est obligatoire et ne doit pas comporter d'espace\n");
			messageErreur.append("\n");
			inscriptionValide = false;
		}

		if(u.getVille()==null || u.getVille().trim().isEmpty()) {
			messageErreur.append("\n Le nom de la ville est obligatoire et ne doit pas comporter d'espace\n");
			messageErreur.append("\n");
			inscriptionValide = false;
		}

		if(u.getMotDePasse()==null || u.getMotDePasse().trim().isEmpty()) {
			messageErreur.append("Le mot de passe est obligatoire et ne doit pas comporter d'espace. \n");
			messageErreur.append("\n");
			inscriptionValide = false;
		}
		// Est ce que le pseudo Existe d�j� ?
		
		if(getUtilisateur(u.getPseudo())==null) {
				messageErreur.append("Un utilisateur a d�j� cet email. Merci d'en renseigner un autre. \n");
				inscriptionValide=false;
			}
		// Est ce que le pseudo Existe d�j� ?
		try {
			if(daoUtilisateur.selectByPseudo(u.getPseudo())!=null) {
				messageErreur.append("Un utilisateur a d�j� ce pseudo. Merci d'en renseigner un autre. \n");
				inscriptionValide=false;
			}
		} catch (DALException e) {
			throw new BLLException("Pb pseudo "+ e.getMessage());
		}
		//==========>>>>>Pas de contrainte de renseignement sur : 
		//==========>>>>>cr�dit, administrateur et article vendu
		
		if(!inscriptionValide) {
			throw new BLLException(messageErreur.toString());
		}
		return inscriptionValide;
	}

	// m�thode cr�er une nouvelle inscription si elle est valide
	public void nouvelleInscription(Utilisateur u) throws BLLException{
		validerInscription(u);
		try {
			// M�thode pr�ciser = celle de la DAL
			this.daoUtilisateur.addUtilisateur(u);
		} catch (DALException e){
			throw new BLLException("Echec inscription utilisateur", e);
		}
	}
	public Utilisateur getUtilisateur(String pseudo) throws BLLException {
		UtilisateurDAO dao = new UtilisateurDAOImpl();
		Utilisateur u= null;
		try {
			u = dao.selectByPseudo(pseudo);
		} catch (DALException e) {
			throw new BLLException(e.getMessage());
			
		}
		return u;
	}

	//	//Mise � jour des donn�es d'un utilisateur � notre application
	//	public void uptdateUtilsateur(Utilisateur u) throws BLLException {
	//		try {
	//			this.daoUtilisateur.update(u);
	//		} catch (DALException e) {
	//			throw new BLLException("Echec mise � jour utilisateur", e);
	//		} 
	//	}
	//	
	//	// Suppression d'un utilisateur dans notre application
	//	public void removeUtilsateur(int noUtilisateur) throws BLLException {
	//		try {
	//			this.daoUtilisateur.delete(noUtilisateur);
	//		} catch (DALException e) {
	//			throw new BLLException("Echec de la suppression de l'utilisateur", e);
	//		} 
	//	}

	// +++++++++++++++++++++++++METHODE BLL POUR BRICE++++++++++++++++++++++++++++++ // BASE A VERIFIER = PAS SUR



	
	
	
}



