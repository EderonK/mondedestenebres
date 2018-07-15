package fr.gtm.mondedestenebres.dao;

import org.junit.Test;

import fr.gtm.mondedestenebres.domaine.Vampire;
import junit.framework.TestCase;

public class VampireDAOTest extends TestCase
{
	VampireDAO vampireDAO = new VampireDAO();
	
	@Test public void testEnBloc()
	{
		//Test ecrire et lire
		Vampire vampireTestCreer = new Vampire("NomVampire", "PrenomVampire", "ClanVampire", 2018, 10);
		Vampire vampireTestModifier = new Vampire("NomVampire", "PrenomVampire", "ClanVampire", -200, 4);
		
		this.vampireDAO.creerElement(vampireTestCreer);
		
		Vampire vampireTestLire = this.vampireDAO.lireElementById(1);
		
		assertEquals(vampireTestCreer.getNom(),vampireTestLire.getNom());
		assertEquals(vampireTestCreer.getPrenom(),vampireTestLire.getPrenom());
		assertEquals(vampireTestCreer.getClan(),vampireTestLire.getClan());
		assertEquals(vampireTestCreer.getEtreinte(),vampireTestLire.getEtreinte());
		assertEquals(vampireTestCreer.getGeneration(),vampireTestLire.getGeneration());
		
		//Test modifier
		this.vampireDAO.modifierElementById(1, vampireTestModifier);
		
		Vampire vampireLire = this.vampireDAO.lireElementById(1);
		
		assertEquals(vampireTestModifier.getNom(),vampireLire.getNom());
		assertEquals(vampireTestModifier.getPrenom(),vampireLire.getPrenom());
		assertEquals(vampireTestModifier.getClan(),vampireLire.getClan());
		assertEquals(vampireTestModifier.getEtreinte(),vampireLire.getEtreinte());
		assertEquals(vampireTestModifier.getGeneration(),vampireLire.getGeneration());

		//Test toutLire
		this.vampireDAO.creerElement(vampireTestCreer);
			
		Vampire vampireTestToutLire1 = this.vampireDAO.toutLireElement().get(0);
		Vampire vampireTestToutLire2 = this.vampireDAO.toutLireElement().get(1);


		assertEquals(vampireTestModifier.getNom(),vampireTestToutLire1.getNom());
		assertEquals(vampireTestModifier.getPrenom(),vampireTestToutLire1.getPrenom());
		assertEquals(vampireTestModifier.getClan(),vampireTestToutLire1.getClan());
		assertEquals(vampireTestModifier.getEtreinte(),vampireTestToutLire1.getEtreinte());
		assertEquals(vampireTestModifier.getGeneration(),vampireTestToutLire1.getGeneration());
		
		assertEquals(vampireTestCreer.getNom(),vampireTestToutLire2.getNom());
		assertEquals(vampireTestCreer.getPrenom(),vampireTestToutLire2.getPrenom());
		assertEquals(vampireTestCreer.getClan(),vampireTestToutLire2.getClan());
		assertEquals(vampireTestCreer.getEtreinte(),vampireTestToutLire2.getEtreinte());
		assertEquals(vampireTestCreer.getGeneration(),vampireTestToutLire2.getGeneration());

		//Test supprimer
		this.vampireDAO.supprimerElementById(1);
		assertEquals(this.vampireDAO.toutLireElement().size(),1);
		this.vampireDAO.supprimerElementById(2);
		assertEquals(this.vampireDAO.toutLireElement().size(),0);
	}
}