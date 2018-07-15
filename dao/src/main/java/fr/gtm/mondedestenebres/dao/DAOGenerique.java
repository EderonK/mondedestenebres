package fr.gtm.mondedestenebres.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class DAOGenerique<ElementBase> implements IDAOGenerique<ElementBase>
{
	public boolean creerElement(ElementBase element)
	{
		Connection con = null;
		Statement stmt = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondedestenebres", "root", "");
			
			stmt = con.createStatement();			
			
			String requete = "INSERT INTO " + this.getNomTable() + " " + this.getAttributs() + " VALUES " + this.getValeurs(element) + ";";
			//System.out.println(requete);
			
			stmt.executeUpdate(requete);
			
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
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
		
		return false;
	}
	
	public ElementBase lireElementById(int id)
	{
		Connection con = null;
		Statement stmt = null;
		
		try
		{	
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondedestenebres", "root", "");
			
			stmt = con.createStatement();
			
			String requete = "SELECT * FROM " + this.getNomTable() +" WHERE id=" + id + ";";
			//System.out.println(requete);
			
			ResultSet rs = stmt.executeQuery(requete);
			
			rs.next();
			
			return this.traitementLectureElement(rs);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
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
	
	public ArrayList<ElementBase> toutLireElement()
	{
		Connection con = null;
		Statement stmt = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondedestenebres", "root", "");
			
			stmt = con.createStatement();
			
			String requete = "SELECT * FROM " + this.getNomTable() + ";";
			//System.out.println(requete);
			
			ResultSet rs = stmt.executeQuery(requete);
			
			ArrayList<ElementBase> elements = new ArrayList<ElementBase>();
			
			while(rs.next())
			{
				elements.add(this.traitementLectureElement(rs));
			}
			
			return elements;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
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
	
	public boolean modifierElementById(int id, ElementBase element)
	{
		Connection con = null;
		Statement stmt = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondedestenebres", "root", "");
			
			stmt = con.createStatement();			
			
			String requete = "UPDATE " + this.getNomTable() +" SET "+ this.getUpdate(element) + " WHERE id=" + id + ";";
			//System.out.println(requete);
			
			stmt.executeUpdate(requete);
			
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
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
		
		return false;
	}
	
	public boolean supprimerElementById(int id)
	{
		Connection con = null;
		Statement stmt = null;
		
		try
		{	
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondedestenebres", "root", "");
			
			stmt = con.createStatement();
			
			String requete = "DELETE FROM " + this.getNomTable() + " WHERE id=" + id + ";";
			//System.out.println(requete);
			
			stmt.executeUpdate(requete);
			
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
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
		return false;
	}
	
	public abstract String getNomTable();
	public abstract String getAttributs();
	public abstract String getValeurs(ElementBase element);
	public abstract String getUpdate(ElementBase element);
	public abstract ElementBase traitementLectureElement(ResultSet rs);
}
