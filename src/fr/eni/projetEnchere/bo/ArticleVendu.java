package fr.eni.projetEnchere.bo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class ArticleVendu {

	// Attributs
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDateTime dateHeureDebutEncheres;
	private LocalDateTime dateHeureFinEncheres;	
	private int miseAPrix;
	private int prixVente;
	// Type � valider avec Gregory (ench�res non d�but�, ench�re en cours, ench�re clotur� ???)
	private int etatVente;    //pas un boolean, on a cree une classe EtatVente avc 3 attributs
	private Retrait lieuRetrait = null;
	private Categorie categorie;
	private List<Enchere> listeEncheres;



	// si le lieu de retrait est l'adresse de l'utilisateur (vendeur), valeur = null

	// constructeur avec les parametres suivants :  nomArticle, description, dateDebutEncheres,dateFinEncheres,  miseAPrix,  Categorie 
	public ArticleVendu(String nomArticle, String description, LocalDateTime dateHeureDebutEncheres,
			LocalDateTime dateHeureFinEncheres, int miseAPrix,  Categorie categorie) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateHeureDebutEncheres = dateHeureDebutEncheres;
		this.dateHeureFinEncheres = dateHeureFinEncheres;
		this.miseAPrix = miseAPrix;
		this.categorie = categorie;
		
	}


	// constructeur vide (java bean)
	public ArticleVendu() {
		//setEtatVente();
		this.listeEncheres = new ArrayList<Enchere>();
	}


	// constructeur (sans prix de vente et mise � prix = DON)
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateHeureDebutEncheres,
			LocalDateTime dateHeureFinEncheres, int etatVente, Retrait retrait, Categorie categorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateHeureDebutEncheres = dateHeureDebutEncheres;
		this.dateHeureFinEncheres = dateHeureFinEncheres;
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

	public LocalDateTime getDateHeureDebutEncheres() {
		return dateHeureDebutEncheres;
	}

	public void setDateHeureDebutEncheres(LocalDateTime dateHeureDebutEncheres) {
		this.dateHeureDebutEncheres = dateHeureDebutEncheres;
	}

	public LocalDateTime getDateHeureFinEncheres() {
		return dateHeureFinEncheres;
	}

	public void setDateHeureFinEncheres(LocalDateTime dateHeureFinEncheres) {
		this.dateHeureFinEncheres = dateHeureFinEncheres;
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

	public int getEtatVente() {
		//	 NON_DEBUTEE= 0; EN_COURS= 1; TERMINEE= 2;
		// si date du jour = date de debut = date de fin on regarde l'heure
		int monEtatVente=3;
		LocalDateTime dateDuJour = LocalDateTime.now();
		// 0=identique -1AvantDateDuJour 1Apr�sDatedujour
		int testdateDebutEnchere=3;
		int testdateFinEnchere=3;
		if(dateDuJour.isEqual(this.dateHeureFinEncheres)){
			testdateFinEnchere=0;
		}else if (dateDuJour.isAfter(this.dateHeureFinEncheres)){
			testdateFinEnchere=-1;
		}else if (dateDuJour.isBefore(this.dateHeureFinEncheres)) {
			testdateFinEnchere=1;
		}
		if(dateDuJour.isEqual(this.dateHeureFinEncheres)){
			testdateFinEnchere=0;
		}else if (dateDuJour.isAfter(this.dateHeureFinEncheres)){
			testdateFinEnchere=-1;
		}else if (dateDuJour.isBefore(this.dateHeureFinEncheres)) {
			testdateFinEnchere=1;
		}
		//System.out.println(testdateFinEnchere+"testdateFinEnchere");
		//System.out.println(testdateDebutEnchere+"testdateFinEnchere");
		
		if(testdateFinEnchere==0&&testdateDebutEnchere==0) {
			monEtatVente=1;
		}else if(testdateFinEnchere==-1) {
			monEtatVente=2;
		}else if (testdateDebutEnchere==1) {
			monEtatVente=0;
		}else if (testdateFinEnchere==1&&testdateDebutEnchere==-1
				||testdateFinEnchere==1&&testdateDebutEnchere==0
				||testdateFinEnchere==0&&testdateDebutEnchere==-1) {
			monEtatVente=1;
		}
		int e=15;
		switch (monEtatVente) {
		case 0://System.out.println("NON_DEBUTEE");	
			e=EtatVente.NON_DEBUTEE;
			break;
		case 1://System.out.println("EN COURS");
			e=EtatVente.EN_COURS;
		break;
		case 2://System.out.println("TERMINEE");
			e=EtatVente.TERMINEE;	
		break;
		}
		return e;
	}

	
	public void setEtatVente(int monEtatVente) {
	this.etatVente=monEtatVente;
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
		builder.append(dateHeureDebutEncheres);
		builder.append(", dateFinEncheres=");
		builder.append(dateHeureFinEncheres);
		builder.append(", miseAPrix=");
		builder.append(miseAPrix);
		builder.append(", prixVente=");
		builder.append(prixVente);
		builder.append(", catagorie");
		builder.append(categorie);
		builder.append(", etatVente=");
		builder.append(etatVente);
		builder.append("]");
		return builder.toString();
	}



}
