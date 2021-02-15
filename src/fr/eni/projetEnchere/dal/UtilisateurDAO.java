package fr.eni.projetEnchere.dal;

import fr.eni.projetEnchere.bo.Utilisateur;

public interface UtilisateurDAO {
	
	Utilisateur selectByPseudo(String pseudo) throws DALException;
	
	void addUtilisateur(Utilisateur u) throws DALException;
	void upUtilisateur(Utilisateur uMiseAJour) throws DALException;
	// ajout delete + liste utilisateur




}
