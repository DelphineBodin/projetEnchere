package fr.eni.projetEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.dal.ConnexionProvider;
import fr.eni.projetEnchere.dal.DALException;

public class RetraitDAOImpl implements RetraitDAO{

	private static final String INSERT="Insert into retraits (rue,code_postal,ville) values(?,?,?)";
	
	@Override
	public void ajoutRetrait(Retrait r) throws DALException {
		Connection cnx = ConnexionProvider.seConnecter();
		try {
			PreparedStatement pstatement=cnx.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			pstatement.setString(1, r.getRue());
			pstatement.setString(2, r.getCodePostal());
			pstatement.setString(3, r.getVille());
			// Ex�cution de la requ�te
			pstatement.executeUpdate();
			//r�cup�ration de la valeur de identity pour noRetrait
			ResultSet rs = pstatement.getGeneratedKeys();
			// Chargement de la valeur dans l'objet Retrait
			if(rs.next()) {
				r.setNoRetrait(rs.getInt(1));
			}
			// fermeture de resultset et du prepareStatement
			rs.close();
			pstatement.close();	
		} catch (SQLException e) {
			new DALException("Probl�me Insertion Retrait"+e.getMessage());
		}finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new DALException(e.getMessage());
			}//Fin du catch
		}// Fin du finally

	}

}
