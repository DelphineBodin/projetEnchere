package fr.eni.projetEnchere.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ArticleVendu {

	// Attributs
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalTime heureDebutEnchere;
	private LocalDate dateFinEncheres;	
	private LocalTime heureFinEnchere;
	private int miseAPrix;
	private int prixVente;
	// Type � valider avec Gregory (ench�res non d�but�, ench�re en cours, ench�re clotur� ???)
	private EtatVente etatVente;    //pas un boolean, on a cree une classe EtatVente avc 3 attributs
	private Retrait lieuRetrait = null;
	private Categorie categorie;
	private List<Enchere> listeEncheres;



	// si le lieu de retrait est l'adresse de l'utilisateur (vendeur), valeur = null

	// constructeur avec les parametres suivants :  nomArticle, description, dateDebutEncheres,dateFinEncheres,  miseAPrix,  Categorie 
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres,LocalTime heureDebutEnchere,
			LocalDate dateFinEncheres,LocalTime heureFinEnchere, int miseAPrix,  Categorie categorie) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.heureDebutEnchere=heureDebutEnchere;
		this.dateFinEncheres = dateFinEncheres;
		this.heureFinEnchere=heureFinEnchere;
		this.miseAPrix = miseAPrix;
		this.categorie = categorie;
	}


	// constructeur vide (java bean)
	public ArticleVendu() {
		this.listeEncheres = new ArrayList<Enchere>();
	}


	// constructeur (sans prix de vente et mise � prix = DON)
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,LocalTime heureDebutEnchere,
			LocalDate dateFinEncheres,LocalTime heureFinEnchere, EtatVente etatVente, Retrait retrait, Categorie categorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.heureDebutEnchere=heureDebutEnchere;
		this.dateFinEncheres = dateFinEncheres;
		this.heureFinEnchere=heureFinEnchere;
		this.etatVente = etatVente;
		this.lieuRetrait = retrait;
		this.categorie = categorie;
		this.listeEncheres = new ArrayList<Enchere>();
	}


	// Assesseurs et mutateurs :

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public EtatVente isEtatVente() {
		return etatVente;
	}

	public void setEtatVente(EtatVente etatVente) {
		this.etatVente = etatVente;
	}


	public Retrait getRetrait() {
		return lieuRetrait;
	}


	public void setRetrait(Retrait retrait) {
		this.lieuRetrait = retrait;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}


	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}


	public LocalTime getHeureDebutEnchere() {
		return heureDebutEnchere;
	}


	public void setHeureDebutEnchere(LocalTime heureDebutEnchere) {
		this.heureDebutEnchere = heureDebutEnchere;
	}


	public LocalTime getHeureFinEnchere() {
		return heureFinEnchere;
	}


	public void setHeureFinEnchere(LocalTime heureFinEnchere) {
		this.heureFinEnchere = heureFinEnchere;
	}


	//M�thodes :
	// TODO : met on retrait dans l'article vendu dans le string builder?
	// met on categorie dans l'article vendu dans le string builder?
	// met on listeEncheres dans l'article vendu dans le string builder?
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleVendu [noArticle=");
		builder.append(noArticle);
		builder.append(", nomArticle=");
		builder.append(nomArticle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", dateDebutEncheres=");
		builder.append(dateDebutEncheres);
		builder.append(", dateFinEncheres=");
		builder.append(dateFinEncheres);
		builder.append(", miseAPrix=");
		builder.append(miseAPrix);
		builder.append(", prixVente=");
		builder.append(prixVente);
		builder.append(", etatVente=");
		builder.append(etatVente);
		builder.append("]");
		return builder.toString();
	}



}
