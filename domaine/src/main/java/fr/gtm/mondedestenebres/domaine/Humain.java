package fr.gtm.mondedestenebres.domaine;

public class Humain extends Personnage
{
	private int reserveSang;
	
	public Humain(String nom, String prenom, int reserveSang)
	{
		super(nom, prenom);
		this.reserveSang = reserveSang;
	}
	
	public Humain(String nom, String prenom)
	{
		this(nom, prenom, 10);
	}
	
	public Humain()
	{
		this("NomGenerique", "PrenomGenerique");
	}
	
	@Override
	public String toString()
	{
		return "Humain [nom=" + super.getNom() + ", prenom=" + super.getPrenom() + ", reserveSang=" + reserveSang + "]";
	}

	public int getReserveSang()
	{
		return reserveSang;
	}

	public void setReserveSang(int reserveSang)
	{
		this.reserveSang = reserveSang;
	}
}
