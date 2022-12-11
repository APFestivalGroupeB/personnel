package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test
	void createLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}

	@Test
	void addEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	@Test
	void getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}
	@Test
	void setNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		ligue.setNom("Bowling");
		assertEquals("Bowling",ligue.getNom());
	}
	@Test
	void getAdministrateur() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye ("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		ligue.setAdministrateur(employe);
		assertEquals(employe,ligue.getAdministrateur());
	}
	@Test
	void setAdministrateur() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye ("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		ligue.setAdministrateur(employe);
		assertEquals(employe,ligue.getAdministrateur());
	}
	@Test
	void getEmployes() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe1 = ligue.addEmploye ("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		Employe employe2 = ligue.addEmploye ("Michel", "Jean", "j.michel@gmail.com", "azerty");
		assertEquals(employe1, ligue.getEmployes().first());
		assertEquals(employe2, ligue.getEmployes().last());
	}
	@Test
	void removeemploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye ("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		Employe employe2 = ligue.addEmploye ("Michel", "Jean", "j.michel@gmail.com", "azerty");
		employe.remove();
		assertEquals(employe2,ligue.getEmployes().first());
		assertEquals(employe2,ligue.getEmployes().last());
	}
	@Test
	void removeligue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye ("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		Ligue ligue2 = gestionPersonnel.addLigue("Bowling");
		ligue.remove();
		assertEquals(ligue2, gestionPersonnel.getLigues().first());
	}
	@Test
	void compareTo() throws SauvegardeImpossible
	{
		Ligue ligue1 = gestionPersonnel.addLigue("Bowling");
		Ligue ligue2 = gestionPersonnel.addLigue("Flechettes");
		assertEquals(-4, ligue1.compareTo(ligue2));
	}
	@Test 
	void ToString() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.toString());
	}
}
