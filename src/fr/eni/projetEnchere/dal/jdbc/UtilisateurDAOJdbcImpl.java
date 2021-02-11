package fr.eni.projetEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.ConnexionProvider;
import fr.eni.projetEnchere.dal.DALException;

public class UtilisateurDAOJdbcImpl  {


	

	public void addUtilisateur(Utilisateur u) throws DALException{
		Connection cnx = null;
		PreparedStatement pstmt = null;
		
		/*
		 * if(u==null) { throw new DALException("Pas d'utilisateur en param�tre"); }
		 * Connection cnx = ConnexionProvider.seConnecter();
		 */
		try {
//			// desactivation de l'auto commit
//			cnx.setAutoCommit(false);
			
			String requeteSQL = "INSERT into UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			
			// Etape 3 : Cr�ation de la requ�te param�tr�e et insertion des param�tres dans la requ�te
			pstmt = cnx.prepareStatement(requeteSQL, Statement.RETURN_GENERATED_KEYS);
			
			// Etape 4 : Remplacer les ? (valoriser les parametres de la requete) 
			pstmt.setString(1, u.getPseudo());
			pstmt.setString(2, u.getNom());
			pstmt.setString(3, u.getPrenom());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getTelephone());
			pstmt.setString(6, u.getRue());
			pstmt.setString(7, u.getCodePostal());
			pstmt.setString(8, u.getVille());
			pstmt.setString(9, u.getMotDePasse());
			pstmt.setInt(10, u.getCredit());
			pstmt.setBoolean(11,u.getAdministrateur());
			
			//Ex�cution de la requ�te
			pstmt.executeUpdate();
			
			// r�cup�ration de la valeur de identity pour noUtilisateur
			ResultSet rs = pstmt.getGeneratedKeys();
			// Chargement de la valeur dans l'objet Utilisateur
			if(rs.next()) {
				u.setNoUtilisateur(rs.getInt(1));
			}
			
			// fermeture de resultatset et du prepareStatement
			rs.close();
			pstmt.close();
			
			// si j'arrive jusqu'� la je peux committer
			cnx.commit();
			
			
//		}catch (SQLException e) {
//			try {	
//				// si je tombe ici, je reviens en arri�re
//				cnx.rollback();
//			}catch (SQLException e1) {
//				throw new DALException("Erreur lors de l'ajout d'un utilisateur: " + e1.getMessage());
//			}// Fin du deuxi�me catch
//			throw new DALException(e.getMessage());
//			//Fin du premier catch
//			
//		}finally {
//			try {
//				//r�atcivation de l'auto commit
//				cnx.setAutoCommit(true);
//				cnx.close();
//			} catch (SQLException e) {
//				throw new DALException(e.getMessage());
			
		} catch (SQLException e) {
			throw new DALException("Erreur lors de l'ajout d'un utilisateur: " + u, e);
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(cnx!=null) {
					cnx.close();
				}
			}catch (SQLException e) {
				throw new DALException("Erreur lors de l'ajout d'un utilisateur: " + u);
			}
		
		}
			
	}
		
}
