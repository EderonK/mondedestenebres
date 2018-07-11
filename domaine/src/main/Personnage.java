package fr.gtm.mondedestenebres.domaine;

public abstract class Personnage
{
	private String nom;
	private String prenom;

	public Personnage(String nom, String prenom)
	{
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Personnage()
	{
		this("NomGenerique", "PrenomGenerique");
	}
	
	@Override
	public String toString()
	{
		return "Humain [nom=" + nom + ", prenom=" + prenom + "]";
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}	
}
