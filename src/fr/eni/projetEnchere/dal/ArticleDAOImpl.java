package fr.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Utilisateur;

public class ArticleDAOImpl implements ArticleDAO {

	private static final String INSERT="INSERT into ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_utilisateur,no_categorie) values(?,?,?,?,?,?,?)";

	@Override
	public void ajouterArticle(ArticleVendu a, Utilisateur u,Categorie c) throws DALException {
		if(a==null) {
			throw new DALException("Pas d'Articles en parametre");
		}
		Connection cnx = ConnexionProvider.seConnecter();
		try {
			// desactivation de l'auto commit
			cnx.setAutoCommit(false);
			// Création de la requête paramétrée et "insertion" des paramètres dans la requête
			PreparedStatement pstatement=cnx.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			pstatement.setString(1, a.getNomArticle());
			pstatement.setString(2, a.getDescription());
			pstatement.setDate(3, java.sql.Date.valueOf(a.getDateDebutEncheres()));
			pstatement.setDate(4, java.sql.Date.valueOf(a.getDateFinEncheres()));
			pstatement.setInt(5, a.getMiseAPrix());
			pstatement.setInt(6, u.getNoUtilisateur());
			pstatement.setInt(7,c.getNoCategorie());
			// Exécution de la requête
			pstatement.executeUpdate();
			//récupération de la valeur de identity pour noArticle
			ResultSet rs = pstatement.getGeneratedKeys();
			// Chargement de la valeur dans l'objet Article
			if(rs.next()) {
				a.setNoArticle(rs.getInt(1));
			}
			// fermeture de resultset et du prepareStatement
			rs.close();
			pstatement.close();
			// si j'arrive jusqu'à là je peux committer
			cnx.commit();
		} catch (SQLException e) {
			try {
				// si je tombe ici, je reviens en arrière
				cnx.rollback();
			} catch (SQLException e1) {
				throw new DALException(e1.getMessage());
			}// Fin du deuxième catch
			throw new DALException(e.getMessage());
			// Fin du premier catch
		}finally {
			try {
				//réactivation de l'auto commit
				cnx.setAutoCommit(true);
				cnx.close();
			} catch (SQLException e) {
				throw new DALException(e.getMessage());
			}//Fin du catch
		}// Fin du finally
	}

}
