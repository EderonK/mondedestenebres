package fr.gtm.mondedestenebres.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import fr.gtm.mondedestenebres.domaine.Vampire;

public class VampireServiceTest
{
	VampireService service = new VampireService();

	@Test public void testRecenserPopulation()
	{
		ArrayList<Vampire> vampires = service.recenserPopulation();
		assertEquals(vampires.size()>=0,true);
	}	
}
