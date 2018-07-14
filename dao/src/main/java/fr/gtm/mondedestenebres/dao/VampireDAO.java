package fr.gtm.mondedestenebres.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.gtm.mondedestenebres.domaine.Vampire;

public class VampireDAO implements IVampireDAO
{
	public boolean creerVampire(Vampire vampire)
	{
		Connection con = null;
		Statement stmt = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondedestenebres", "root", "");
			
			stmt = con.createStatement();			
			
			String requete = "INSERT INTO vampire (nom, prenom, clan, etreinte, generation) VALUES ('" + vampire.getNom() + "', '" + vampire.getPrenom() +  "', '" + vampire.getClan() + "', " + vampire.getEtreinte() + ", " + vampire.getGeneration() +");";
			//System.out.println(requete);
			
			stmt.executeUpdate(requete);
			
			return true;
		}
		catch (SQLException e)
		{
			System.out.println("Erreur SQL.");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Erreur en lien avec le driver MySQL.");
		}
		finally
		{
			try
			{
				stmt.close();
				con.close();
			}
			catch (SQLException e)
			{
				System.out.println("Erreur SQL.");
			}
		}
		
		return false;
	}
	
	public Vampire lireVampireById(int id)
	{
		Connection con = null;
		Statement stmt = null;
		
		try
		{	
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondedestenebres", "root", "");
			
			stmt = con.createStatement();
			
			String requete = "SELECT * FROM vampire WHERE id=" + id + ";";
			//System.out.println(requete);
			
			ResultSet rs = stmt.executeQuery(requete);
			
			Vampire vampire = new Vampire();
			
			rs.next();
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
		catch (ClassNotFoundException e)
		{
			System.out.println("Erreur en lien avec le driver MySQL.");
		}
		finally
		{
			try
			{
				stmt.close();
				con.close();
			}
			catch (SQLException e)
			{
				System.out.println("Erreur SQL.");
			}
		}
		return null;
	}

	public ArrayList<Vampire> toutLireVampire()
	{
		Connection con = null;
		Statement stmt = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondedestenebres", "root", "");
			
			stmt = con.createStatement();
			
			String requete = "SELECT * FROM vampire;";
			//System.out.println(requete);
			
			ResultSet rs = stmt.executeQuery(requete);
			
			ArrayList<Vampire> vampires = new ArrayList<Vampire>();
			Vampire vampire = null;
			
			while(rs.next())
			{
				vampire = new Vampire();
				vampire.setId(rs.getInt("id"));
				vampire.setNom(rs.getString("nom"));
				vampire.setPrenom(rs.getString("prenom"));
				vampire.setClan(rs.getString("clan"));
				vampire.setEtreinte(rs.getInt("etreinte"));
				vampire.setGeneration(rs.getInt("generation"));
				
				vampires.add(vampire);
			}
			
			return vampires;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Erreur en lien avec le driver MySQL.");
		}
		finally
		{
			try
			{
				stmt.close();
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean modifierVampireById(int id, Vampire vampire)
	{
		Connection con = null;
		Statement stmt = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondedestenebres", "root", "");
			
			stmt = con.createStatement();			
			
			String requete = "UPDATE vampire SET nom = '" + vampire.getNom() + "', prenom =  '" + vampire.getPrenom() + "', clan =  '" + vampire.getClan() + "', etreinte =  " + vampire.getEtreinte() + ", generation =  " + vampire.getGeneration() + " WHERE id=" + id + ";";
			//System.out.println(requete);
			
			stmt.executeUpdate(requete);
			
			return true;
		}
		catch (SQLException e)
		{
			System.out.println("Erreur SQL.");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Erreur en lien avec le driver MySQL.");
		}
		finally
		{
			try
			{
				stmt.close();
				con.close();
			}
			catch (SQLException e)
			{
				System.out.println("Erreur SQL.");
			}
		}
		
		return false;
	}

	public boolean supprimerVampireById(int id)
	{
		Connection con = null;
		Statement stmt = null;
		
		try
		{	
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondedestenebres", "root", "");
			
			stmt = con.createStatement();
			
			String requete = "DELETE FROM vampire WHERE id=" + id + ";";
			//System.out.println(requete);
			
			stmt.executeUpdate(requete);
			
			return true;
		}
		catch (SQLException e)
		{
			System.out.println("Erreur SQL.");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Erreur en lien avec le driver MySQL.");e.printStackTrace();
		}
		finally
		{
			try
			{
				stmt.close();
				con.close();
			}
			catch (SQLException e)
			{
				System.out.println("Erreur SQL.");
			}
		}
		return false;
	}
}
