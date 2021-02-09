package fr.eni.projetEnchere.bo;

public class Retrait {
	
	// Attributs
	private String rue;
	private int codePostal;
	private String ville;

	
	// Constructeur sans paramêtre
	public Retrait() {
	}

	
	// Constructeur
	public Retrait(String rue, int codePostal, String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	
	// Assesseurs et mutateurs :
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	
	//Méthodes :
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [rue=");
		builder.append(rue);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append("]");
		return builder.toString();
	}


	
	
}
