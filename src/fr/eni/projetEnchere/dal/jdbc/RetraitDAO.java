package fr.eni.projetEnchere.dal.jdbc;

import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.dal.DALException;

public interface RetraitDAO {

	void ajoutRetrait(Retrait r)throws DALException;
}
