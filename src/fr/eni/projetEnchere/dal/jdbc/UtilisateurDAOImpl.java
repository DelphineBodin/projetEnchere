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
		cnx = ConnexionProvider.seConnecter();
		try {		
			String requeteSQL = "INSERT into UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			// Etape 3 : Cr�ation de la requ�te param�tr�e et insertion des param�tres dans la requ�te
			pstmt = cnx.prepareStatement(requeteSQL, PreparedStatement.RETURN_GENERATED_KEYS);

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
			pstmt.setBoolean(11, false);

			System.out.println("coucou2");

			//Ex�cution de la requ�te
			pstmt.executeUpdate();
			System.out.println("coucou3");

			// r�cup�ration de la valeur de identity pour noUtilisateur
			ResultSet rs = pstmt.getGeneratedKeys();
			// Chargement de la valeur dans l'objet Utilisateur
			if(rs.next()) {
				u.setNoUtilisateur(rs.getInt(1));
			}

			// fermeture de resultatset et du prepareStatement
			rs.close();
			pstmt.close();

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
		Connection cnx=null;
		PreparedStatement pstmt= null;
		cnx=ConnexionProvider.seConnecter();
		Utilisateur u2=null;
		//requete sql testee et fonctionnelle: affiche pseudo et mdp quand pseudo= qqch
		String requeteSQL = "SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur "
		+ "FROM UTILISATEURS where pseudo= ?"; 
		try {
			pstmt= cnx.prepareStatement(requeteSQL);
			pstmt.setString(1,pseudo);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				int numero= rs.getInt("no_utilisateur");
				String pseudo1 = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String cp = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String mdp = rs.getString("mot_de_passe");
				int credit = rs.getInt("credit");
				boolean admin = rs.getBoolean("administrateur");
				//on cree objet utilisateur ayant en parametres les �l�ments ci-dessus
				u2= new Utilisateur(numero,pseudo1,nom,prenom,email, telephone,rue,cp,ville,mdp,credit,admin);
			}
			// CLOSE de RS et PSTMT
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			throw new DALException("Erreur dans les parametres de l'utilisateur: " + u2, e);
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(cnx!=null) {
					cnx.close();
				}
			}catch (SQLException e) {
				throw new DALException("Erreur dans les parametres de l'utilisateur: " + u2);
			}
		}
		return u2;
	}	
}
