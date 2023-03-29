package testsUnitaires;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import personnel.*;


class testGestionPersonnel {
	
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
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
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertNotNull(gestionPersonnel.getLigues());
	}
	@Test
	void addLigue() throws SauvegardeImpossible
	{
		gestionPersonnel.addLigue("Fléchettes");
		assertNotNull(gestionPersonnel.getLigues());
//		assertEquals("Fléchettes",(gestionPersonnel.getLigues()).getNom());
	}
//	@Test
//	void remove() throws SauvegardeImpossible
//	{
//		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
//		Employe employe = ligue.addEmploye ("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
//		gestionPersonnel.remove(ligue);
//		assertEquals(null, employe.getLigue());
//	}
//	void getRoot() throws SauvegardeImpossible
//	{
//		
//	}
}
