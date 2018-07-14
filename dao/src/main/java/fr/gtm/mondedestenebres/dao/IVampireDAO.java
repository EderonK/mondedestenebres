package fr.gtm.mondedestenebres.dao;

import java.util.ArrayList;

import fr.gtm.mondedestenebres.domaine.Vampire;

public interface IVampireDAO
{
	//CRUD
	public boolean creerVampire(Vampire vampire);
	public Vampire lireVampireById(int id);
	public ArrayList<Vampire> toutLireVampire();
	public boolean modifierVampireById(int id, Vampire vampire);
	public boolean supprimerVampireById(int id);
}
