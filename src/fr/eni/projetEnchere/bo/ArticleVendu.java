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
	// Type à valider avec Gregory (enchères non débuté, enchère en cours, enchère cloturé ???)
	private int etatVente;    //pas un boolean, on a cree une classe EtatVente avc 3 attributs
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


	// constructeur (sans prix de vente et mise à prix = DON)
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,LocalTime heureDebutEnchere,
			LocalDate dateFinEncheres,LocalTime heureFinEnchere, int etatVente, Retrait retrait, Categorie categorie) {
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

	public int getEtatVente() {
		return etatVente;
	}

	
	public void setEtatVente() {
	//	 NON_DEBUTEE= 0; EN_COURS= 1; TERMINEE= 2;
	// si date du jour = date de debut = date de fin on regarde l'heure
	int monEtatVente=3;
	LocalDate dateDuJour = LocalDate.now();
	LocalTime heureMaintenant = LocalTime.now();
	// 0=identique -1AvantDateDuJour 1AprèsDatedujour
	int testdateDebutEnchere=3;
	if(dateDuJour.isEqual(this.dateDebutEncheres)){
		testdateDebutEnchere=0;
	}else if (dateDuJour.isAfter(this.dateDebutEncheres)){
		testdateDebutEnchere=-1;
	}else if (dateDuJour.isBefore(this.dateDebutEncheres)) {
		testdateDebutEnchere=1;
	}
	int testdateFinEnchere=3;
	if(dateDuJour.isEqual(this.dateFinEncheres)){
		testdateFinEnchere=0;
	}else if (dateDuJour.isAfter(this.dateFinEncheres)){
		testdateFinEnchere=-1;
	}else if (dateDuJour.isBefore(this.dateFinEncheres)) {
		testdateFinEnchere=1;
	}
	System.out.println(testdateFinEnchere+"testdateFinEnchere");
	System.out.println(testdateDebutEnchere+"testdateFinEnchere");
	
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
	int e;
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
	this.etatVente=monEtatVente;
	}
	
//	int testheureDebutEnchere=3;
//	if (heureMaintenant.isAfter(this.heureDebutEnchere)){
//		testheureDebutEnchere=-1;
//	}else if (heureMaintenant.isBefore(this.heureDebutEnchere)) {
//		testheureDebutEnchere=1;
//	}
//	int testheureFinEnchere=3;
//	if (heureMaintenant.isAfter(this.heureFinEnchere)){
//		testheureFinEnchere=-1;
//	}else if (heureMaintenant.isBefore(this.heureFinEnchere)) {
//		testheureFinEnchere=1;
//	}
	
	
	
	



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


	//Méthodes :
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
		builder.append(", catagorie");
		builder.append(categorie);
		builder.append(", etatVente=");
		builder.append(etatVente);
		builder.append("]");
		return builder.toString();
	}



}
