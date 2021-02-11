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
import fr.eni.projetEnchere.dal.UtilisateurDAO;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	@Override
	public void addUtilisateur(Utilisateur u) throws DALException{
		Connection cnx = null;
		PreparedStatement pstmt = null;
		
		// initialiser connection
		try {
			
			String requeteSQL = "INSERT into UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			
			// Etape 3 : Création de la requête paramétrée et insertion des paramètres dans la requête
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
			
			//Exécution de la requête
			pstmt.executeUpdate();
			
			// récupération de la valeur de identity pour noUtilisateur
			ResultSet rs = pstmt.getGeneratedKeys();
			// Chargement de la valeur dans l'objet Utilisateur
			if(rs.next()) {
				u.setNoUtilisateur(rs.getInt(1));
			}
			
			// fermeture de resultatset et du prepareStatement
			rs.close();
			pstmt.close();
			
			// si j'arrive jusqu'à la je peux committer
			cnx.commit();
			
			
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
		
		public Utilisateur selectByPseudo(String pseudo) throws DALException {
			
			return null;
		}
			

		
}
