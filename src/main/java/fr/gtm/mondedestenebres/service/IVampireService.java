package fr.gtm.mondedestenebres.service;

import java.util.ArrayList;

import fr.gtm.mondedestenebres.domaine.Humain;
import fr.gtm.mondedestenebres.domaine.Vampire;

public interface IVampireService
{
	public boolean diabler(Vampire vampireAgresseur, Vampire vampireVictime); 
	public void etreindre(Vampire vampire, Humain humain);
	public ArrayList<Vampire> recenserPopulation();
}
