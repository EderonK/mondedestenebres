package fr.gtm.mondedestenebres.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.gtm.mondedestenebres.domaine.Vampire;

public class VampireDAO extends DAOGenerique<Vampire>
{	
	public VampireDAO()
	{
		super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/mondedestenebres", "root", "");
	}

	@Override
	public String getNomTable()
	{
		return "vampire";
	}
	
	@Override
	public String getAttributs()
	{
		return "(nom, prenom, clan, etreinte, generation)";
	}

	@Override
	public Vampire traitementLectureElement(ResultSet rs)
	{
		try
		{
			Vampire vampire = new Vampire();
			vampire.setId(rs.getInt("id"));
			vampire.setNom(rs.getString("nom"));
			vampire.setPrenom(rs.getString("prenom"));
			vampire.setClan(rs.getString("clan"));
			vampire.setEtreinte(rs.getInt("etreinte"));
			vampire.setGeneration(rs.getInt("generation"));
			
			return vampire;
		}
		catch (SQLException e)
		{
			System.out.println("Erreur SQL.");
		}
		return null;		
	}
	
	@Override
	public String getValeurs(Vampire vampire)
	{
		return "('" + vampire.getNom() + "', '" + vampire.getPrenom() +  "', '" + vampire.getClan() + "', " + vampire.getEtreinte() + ", " + vampire.getGeneration() +")";
	}

	@Override
	public String getUpdate(Vampire vampire)
	{
		return "nom = '" + vampire.getNom() + "', prenom =  '" + vampire.getPrenom() + "', clan =  '" + vampire.getClan() + "', etreinte =  " + vampire.getEtreinte() + ", generation =  " + vampire.getGeneration();		
	}
}
