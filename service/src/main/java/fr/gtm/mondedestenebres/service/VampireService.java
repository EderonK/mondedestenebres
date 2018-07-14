package fr.gtm.mondedestenebres.service;

import java.util.ArrayList;
import java.util.Calendar;

import fr.gtm.mondedestenebres.dao.VampireDAO;
import fr.gtm.mondedestenebres.domaine.Humain;
import fr.gtm.mondedestenebres.domaine.Vampire;

public class VampireService implements IVampireService
{
	private VampireDAO vampireDAO;
	
	public VampireService()
	{
		this.vampireDAO = new VampireDAO();
	}
	
	public boolean diabler(Vampire vampireAgresseur, Vampire vampireVictime)
	{		
		int diffGeneration = vampireAgresseur.getGeneration() - vampireVictime.getGeneration();
		
		if(diffGeneration < 3)
		{
			if(diffGeneration > 0)
			{
				vampireAgresseur.setGeneration(vampireAgresseur.getGeneration() - diffGeneration);
				vampireDAO.modifierVampireById(vampireAgresseur.getId(), vampireAgresseur);
				vampireDAO.supprimerVampireById(vampireVictime.getId());
			}
						
			return true;
		}
		
		return false;
	}

	public void etreindre(Vampire sire, Humain humain)
	{
		Calendar.getInstance();
		Vampire neonat = new Vampire(humain.getNom(), humain.getPrenom(), sire.getClan(), 2018, sire.getGeneration()+1);
		
		vampireDAO.creerVampire(neonat);
	}

	public ArrayList<Vampire> recenserPopulation()
	{		
		return vampireDAO.toutLireVampire();
	}
}
