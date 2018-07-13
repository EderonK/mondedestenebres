package fr.gtm.mondedestenebres.domaine;

public class Vampire extends Personnage
{
	private int id;
	private String clan;
	private int etreinte;
	private int generation;
	
	public Vampire(String nom, String prenom, int id, String clan, int etreinte, int generation)
	{
		super(nom, prenom);
		this.id = id;
		this.clan = clan;
		this.etreinte = etreinte;
		this.generation = generation;
	}

	public Vampire(String nom, String prenom, String clan, int etreinte, int generation)
	{
		this(nom, prenom, 0, clan, etreinte, generation);
	}
	
	public Vampire()
	{
		this("NomGenerique", "PrenomGenerique", "Autarkis", 1950, 11);
	}

	@Override
	public String toString()
	{
		return "Vampire [nom=" + super.getNom() + ", prenom=" + super.getPrenom() + ", clan=" + this.clan + ", etreinte=" + this.etreinte + ", generation=" + this.generation + "]";
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getClan()
	{
		return clan;
	}
	
	public void setClan(String clan)
	{
		this.clan = clan;
	}
	
	public int getEtreinte()
	{
		return etreinte;
	}
	
	public void setEtreinte(int age)
	{
		this.etreinte = age;
	}
	
	public int getGeneration()
	{
		return generation;
	}
	
	public void setGeneration(int generation)
	{
		this.generation = generation;
	}
}
