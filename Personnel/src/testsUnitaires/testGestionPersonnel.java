package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import personnel.*;


class testGestionPersonnel {
	
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	private Ligue Fléchettes;
	private Employe Bouchard;
	
	@Test
	void getGestionPersonnel() throws SauvegardeImpossible
	{
		
	}
	@Test
	void GestionPersonnel() throws SauvegardeImpossible
	{
		
	}
	@Test 
	void addLigue() throws SauvegardeImpossible
	{
		assertEquals(1, gestionPersonnel.getLigues().size());
		Ligue foot = gestionPersonnel.addLigue("Fléchettes");
		assertEquals(2, gestionPersonnel.getLigues().size());
		assertTrue(gestionPersonnel.getLigues().contains(foot));
		foot.remove();
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
		assertEquals(null ,gestionPersonnel.getLigue(Bouchard));
		tennis.setAdministrateur(Bouchard);
		assertEquals(tennis ,gestionPersonnel.getLigue(Bouchard));
	}

	@Test
	void remove() throws SauvegardeImpossible
	{
		SortedSet<Ligue> ligues = gestionPersonnel.getLigues();
		assertEquals(1, ligues.size());
		assertEquals(0, ligues.size());
	}
	
	@Test
	void getRoot() throws SauvegardeImpossible
	{
		
	}
}
