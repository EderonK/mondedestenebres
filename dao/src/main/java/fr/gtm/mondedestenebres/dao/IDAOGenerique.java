package fr.gtm.mondedestenebres.dao;

import java.util.ArrayList;

public interface IDAOGenerique<ElementBase>
{
	//CRUD
	public boolean creerElement(ElementBase element);
	public ElementBase lireElementById(int id);
	public ArrayList<ElementBase> toutLireElement();
	public boolean modifierElementById(int id, ElementBase element);
	public boolean supprimerElementById(int id);
	
}
