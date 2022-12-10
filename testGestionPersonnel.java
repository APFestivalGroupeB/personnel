package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import personnel.*;


class testGestionPersonnel {
	
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test
	void getGestionPersonnel() throws SauvegardeImpossible
	{
		
	}
	@Test
	void GestionPersonnel() throws SauvegardeImpossible
	{
		
	}
	@Test 
	void getLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye ("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		ligue.setAdministrateur(employe);
		assertEquals(ligue, employe.getLigue());
	}
	@Test
	void getLigues() throws SauvegardeImpossible
	{
		
	}
	@Test
	void addLigue() throws SauvegardeImpossible
	{
		 
	}
	@Test
	void remove() throws SauvegardeImpossible
	{
		
	}
	@Test
	void insert() throws SauvegardeImpossible
	{
		
	}
	@Test
	void getRoot() throws SauvegardeImpossible
	{
		
	}
}
