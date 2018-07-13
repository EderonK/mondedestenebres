package fr.gtm.mondedestenebres.presentation;

import java.util.ArrayList;

import fr.gtm.mondedestenebres.domaine.Humain;
import fr.gtm.mondedestenebres.domaine.Vampire;
import fr.gtm.mondedestenebres.service.VampireService;

public class Lanceur
{
	public static void main(String[] args)
	{
		VampireService vampireService = new VampireService();
		
		ArrayList<Vampire> vampires;
		Humain jean = new Humain("Jean", "Geoffroy");
		
		System.out.println("Recensement des vampires presents :");
		
		vampires = vampireService.recenserPopulation();
		for(Vampire vampire : vampires)
		{
			System.out.println(vampire);
		}
		
		System.out.println("\nOlivier decide de diabler Helene.");
		vampireService.diabler(vampires.get(0), vampires.get(1));
		
		System.out.println("Suite a cela un nouveau recensement est necessaire :");
		
		vampires = vampireService.recenserPopulation();
		for(Vampire vampire : vampires)
		{
			System.out.println(vampire);
		}
		
		System.out.println("\nSe sentant seul Olivier decide d'etreindre Jean, un humain qui passe par la.");
		System.out.println(jean);
		vampireService.etreindre(vampires.get(0), jean);
		System.out.println("\nJean est donc desormait un vampire. Comme le montre ce recensement :");
		
		vampires = vampireService.recenserPopulation();
		for(Vampire vampire : vampires)
		{
			System.out.println(vampire);
		}
	}
}