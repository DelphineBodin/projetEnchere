package fr.eni.projetEnchere.bll;

import java.util.List;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.DALException;
import fr.eni.projetEnchere.dal.FactoryDAO;
import fr.eni.projetEnchere.dal.UtilisateurDAO;


// Class permettant de tester la confirmité des utilisateurs avant leur transmission à la DAL
public class AnnuaireUtilisateurManager {
	
	private UtilisateurDAO daoUtilisateur;
	
	public AnnuaireUtilisateurManager() {
		//this.daoUtilisateur = FactoryDAO.getUtilisateurDAO() ;
	}
	
//	//Méthode permettant d'acceder à l'ensemble des utilisateurs de l'application
//	public List<Utilisateur> getCatalogue() throws BLLException{
//		List<Utilisateur> listeUtilisateur;
//		try {
//			listeUtilisateur = this.daoUtilisateur.selectAll();
//		} catch (DALException e) {
//			throw new BLLException("Erreur lors de la récupération du catalogue", e);
//		}
//		return listeUtilisateur;
//	}
	
	//Ajout d'un utilisateur à notre application
	public void addUtilisateur(Utilisateur u) throws BLLException {
		addUtilisateur(u);
		try {
			this.daoUtilisateur.addUtilisateur(u);
		} catch (DALException e) {
			throw new BLLException("Echec ajout utilisateur", e);			
		}
	}
	
//	//Mise à jour des données d'un utilisateur à notre application
//	public void uptdateUtilsateur(Utilisateur u) throws BLLException {
//		try {
//			this.daoUtilisateur.update(u);
//		} catch (DALException e) {
//			throw new BLLException("Echec mise à jour utilisateur", e);
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
	
	// Lecture d'un utilisateur depuis son identifiant
	public Utilisateur getUtilisateur(String pseudo) throws BLLException {
		try {
			return this.daoUtilisateur.selectByPseudo(pseudo);
		} catch (DALException e){
			throw new BLLException("Echec getUtilisateur :" + pseudo, e);
		}
	}
	
	// Valider des données d'un utilisateur
	public void validerUtilisateu(Utilisateur u) throws BLLException {
		StringBuilder messageErreur = new StringBuilder();
		boolean utilisateurValide = true;
		if(u==null) {
			throw new BLLException("Utilisateur null\n");
		}
		
		// Le pseudo ne peut pas être vide et ne peut pas contenir d'espace
		if(u.getPseudo()==null || u.getPseudo().trim().isEmpty()) {
			messageErreur.append("Le pseudo est obligatoire\n");
			utilisateurValide = false;
		}
		
		if(u.getNom()==null || u.getNom().trim().isEmpty()) {
			messageErreur.append("Le nom est obligatoire\n");
			utilisateurValide = false;
		}
		
		if(u.getPrenom()==null || u.getPrenom().trim().isEmpty()) {
			messageErreur.append("Le prenom est obligatoire\n");
			utilisateurValide = false;
		}
		
		if(u.getEmail()==null || u.getEmail().trim().isEmpty()) {
			messageErreur.append("L'adresse email est obligatoire\n");
			utilisateurValide = false;
		}
		
		if(u.getTelephone()==null || u.getTelephone().trim().isEmpty()) {
			messageErreur.append("Le numero de telephone est obligatoire\n");
			utilisateurValide = false;
		}
		
		if(u.getRue()==null || u.getRue().trim().isEmpty()) {
			messageErreur.append("La rue est obligatoire\n");
			utilisateurValide = false;
		}
		
		if(u.getCodePostal()==null || u.getCodePostal().trim().isEmpty()) {
			messageErreur.append("Le code postal est obligatoire\n");
			utilisateurValide = false;
		}
		
		if(u.getVille()==null || u.getVille().trim().isEmpty()) {
			messageErreur.append("Le nom de la ville est obligatoire\n");
			utilisateurValide = false;
		}
		
		if(u.getMotDePasse()==null || u.getMotDePasse().trim().isEmpty()) {
			messageErreur.append("Le mot de passe est obligatoire\n");
			utilisateurValide = false;
		}
		
		//Pas de contrainte de renseignement sur : crédit, administrateur et article vendu
	}
}
