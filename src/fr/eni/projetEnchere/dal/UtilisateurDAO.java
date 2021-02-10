package fr.eni.projetEnchere.dal;

import java.util.List;

import fr.eni.projetEnchere.bo.Utilisateur;

public interface UtilisateurDAO {
	List<Utilisateur> selectAll() throws DALException;
	Utilisateur selectById(Integer noUtilisateur) throws DALException;
	void insert(Utilisateur utilisateur) throws DALException;
	void update(Utilisateur utilisateurAMettreJour) throws DALException;
	void delete(int noUtilisateur) throws DALException;

}
