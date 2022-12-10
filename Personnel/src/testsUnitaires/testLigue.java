package serialisation;

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
<<<<<<< HEAD
	@Test 
	void getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("rugby");
		assertEquals("rugby", ligue.getNom());
	}
	
	@Test
	void setNom() throws SauvegardeImpossible{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		ligue.setNom("Bowling");
		assertEquals("Bowling", ligue.getNom());
	}
	@Test 
	void getAdministrateur() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe administrateur = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		ligue.setAdministrateur(administrateur);
		assertEquals(administrateur, ligue.getAdministrateur());
	}
	@Test
	void setAdministrateur() throws SauvegardeImpossible{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe administrateur = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		ligue.setAdministrateur(administrateur);
		assertEquals(administrateur, ligue.getAdministrateur());
		
		
	}
	@Test
	void remove() throws SauvegardeImpossible{
		Ligue ligue = gestionPersonnel.addLigue("ligue");
		Employe employe1 = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		Employe employe2 = ligue.addEmploye("Ucles", "Marie", "marie.ucles@gmail.com", "poiuyh");
		ligue.remove();
		assertEquals(false, gestionPersonnel.getLigues().equals(ligue));
	}
	@Test
	void compareTo() throws SauvegardeImpossible{
		Ligue rugby = gestionPersonnel.addLigue("rugby");
		Ligue football= gestionPersonnel.addLigue("football");
		assertEquals(24, rugby.compareTo(rugby));
		assertEquals(15, rugby.compareTo(football));
		}
	
	@Test 
	void testToString() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("rugby");
		assertEquals("rugby", ligue.toString());
	}
}
=======
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
		assertNotEquals(employe,ligue.getEmployes());
	}
	@Test
	void removeligue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye ("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		ligue.remove();
		assertNotEquals(ligue, gestionPersonnel.getLigues());
	}
}
>>>>>>> 6fd2c5ed854f08e6a95a2c6bf290f3404c62dea4
