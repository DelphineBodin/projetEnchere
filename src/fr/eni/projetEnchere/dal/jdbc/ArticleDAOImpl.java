package fr.eni.projetEnchere.dal.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.ArticleDAO;
import fr.eni.projetEnchere.dal.ConnexionProvider;
import fr.eni.projetEnchere.dal.DALException;


public class ArticleDAOImpl implements ArticleDAO {

	private static final String INSERT="INSERT into ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_utilisateur,no_categorie,no_Retrait,heure_debut_encheres,heure_fin_encheres) values(?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT="select no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie,no_retrait,heure_debut_encheres,heure_fin_encheres from ARTICLES_VENDUS where nom_article like'%?%' and no_categorie=?";
	@Override
	public void nouvelleVente(ArticleVendu a, Utilisateur u,Categorie c,Retrait r) throws DALException {
		
		
		if(a==null) {
			throw new DALException("Pas d'Articles en parametre");
		}
		PreparedStatement pstatement=null;
		Connection cnx = ConnexionProvider.seConnecter();
		try {
			// Création de la requête paramétrée et "insertion" des paramètres dans la requête
			pstatement=cnx.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			pstatement.setString(1, a.getNomArticle());
			pstatement.setString(2, a.getDescription());
			pstatement.setDate(3, java.sql.Date.valueOf(a.getDateDebutEncheres()));
			pstatement.setDate(4, java.sql.Date.valueOf(a.getDateFinEncheres()));
			pstatement.setInt(5, a.getMiseAPrix());
			pstatement.setInt(6, u.getNoUtilisateur());
			pstatement.setInt(7,c.getNoCategorie());
			if(r!=null) {
				pstatement.setInt(8, r.getNoRetrait());
			}else {
				pstatement.setNull(8, Types.INTEGER);
			}
			pstatement.setTime(9, java.sql.Time.valueOf(a.getHeureDebutEnchere()));
			pstatement.setTime(10, java.sql.Time.valueOf(a.getHeureFinEnchere()));
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
			
			} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}finally {
			ConnexionProvider.seDeconnecter(pstatement,cnx);
		}
	}
	public List<ArticleVendu>selectArticlesByCategorieNom(int noCategorie,String nom) throws DALException{
		List<ArticleVendu> liste=null;
		PreparedStatement pstatement=null;
		ResultSet rs;
		Connection cnx = ConnexionProvider.seConnecter();
		CategorieDAOImpl cat= new CategorieDAOImpl();
		RetraitDAOImpl ret = new RetraitDAOImpl();
		try {
			pstatement=cnx.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			ArticleVendu articleCourant= new ArticleVendu();
			pstatement.executeQuery();
			rs = pstatement.getGeneratedKeys();
			// Chargement de la valeur dans l'objet Article
			while(rs.next()) {
				articleCourant.setNoArticle(rs.getInt("no_article"));
				articleCourant.setNomArticle(rs.getString("nom_article"));
				articleCourant.setDescription(rs.getString("description"));
				articleCourant.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				articleCourant.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				articleCourant.setMiseAPrix(rs.getInt("prix_initial"));
				articleCourant.setPrixVente(rs.getInt("prix_vente"));
				articleCourant.setPrixVente(rs.getInt("no_utilisateur"));
				articleCourant.setCategorie(new Categorie(rs.getInt("no_categorie"),cat.selectByNo(rs.getInt("no_categorie")).getLibelle()));
				//articleCourant.setRetrait(new Retrait(rs.getInt("no_retrait"),));
				//heure_debut_encheres,heure_fin_encheres
				articleCourant.setHeureDebutEnchere(rs.getTime("heure_debut_encheres").toLocalTime());
				articleCourant.setHeureFinEnchere(rs.getTime("heure_fin_encheres").toLocalTime());
				liste.add(articleCourant);
			}
				rs.close();
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}finally {
			ConnexionProvider.seDeconnecter(pstatement,cnx);
		
		}
		return liste;
	}
	
}
