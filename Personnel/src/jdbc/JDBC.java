package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import serialisation.*;
import personnel.*;

public class JDBC implements Passerelle 
{
	Connection connection;

	public JDBC()
	{
		try
		{
			Class.forName(Credentials.getDriverClassName());
			connection = DriverManager.getConnection(Credentials.getUrl(), Credentials.getUser(), Credentials.getPassword());
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Pilote JDBC non installé.");
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	
	@Override
	public GestionPersonnel getGestionPersonnel() 
	{
		GestionPersonnel gestionPersonnel = new GestionPersonnel();
		try 
		{
			String requete = "select * from ligue";
			Statement instruction = connection.createStatement();
			ResultSet ligues = instruction.executeQuery(requete);
			
			while (ligues.next())
			{
				gestionPersonnel.addLigue(ligues.getInt("id_ligue"), ligues.getString("nom"));
		        PreparedStatement response = connection.prepareStatement("SELECT * FROM employe WHERE id_ligue = ?");
		        response.setInt(1, ligues.getInt("id_ligue"));
		        ResultSet employe = response.executeQuery();
		        Ligue ligue = gestionPersonnel.getLigues().last();
				while (employe.next()) 
				{
					int id = employe.getInt("id_employe");
			        String  nom = employe.getString("nomEmploye");
				    String  prenom = employe.getString("prenomEmploye");
//				    Long num_sec_soc = employe.getLong("num_sec_soc"); 
				    String	mail = employe.getString("mail");
		            String	password = employe.getString("password");
		            LocalDate dateArrivee = employe.getString("DateArrivee") != null ? LocalDate.parse(employe.getString("DateArrivee"), DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null;
		            LocalDate dateDepart = employe.getString("DateDepart") != null ? LocalDate.parse(employe.getString("DateDepart"), DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null;
				    Employe employes = ligue.addEmployeConsole(nom, prenom, mail, password, dateDepart);
					if(id == ligues.getInt("administrateur")) 
					{
						ligue.setAdministrateur(employes);
					}

				}
			}
		}

		catch (SQLException e)
		{
			System.out.println(e);
		}
		return gestionPersonnel;
	}

	@Override
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel) throws SauvegardeImpossible 
	{
		close();
	}
	
	public void close() throws SauvegardeImpossible
	{
		try
		{
			if (connection != null)
				connection.close();
		}
		catch (SQLException e)
		{
			throw new SauvegardeImpossible(e);
		}
	}
	
	@Override
	public int insertLigue(Ligue ligue) throws SauvegardeImpossible 
	{
		try 
		{
			String sql = "insert into ligue(nom) values (?)";
			PreparedStatement instruction;
			instruction = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, ligue.getNom());
			instruction.executeUpdate();
			ResultSet id = instruction.getGeneratedKeys();
			id.next();
			return id.getInt(1);
		} 
		catch (SQLException exception) 
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}		
	}
	
	@Override
public void updateLigue(Ligue ligue) throws SauvegardeImpossible {
    try {
        PreparedStatement instruction = connection.prepareStatement(
            "update ligue set nom = ? where id_ligue = ?"
        );
        instruction.setString(1, ligue.getNom());
        instruction.setInt(2, ligue.getId_ligue());
        instruction.executeUpdate();
    } catch (SQLException exception) {
        exception.printStackTrace();
        throw new SauvegardeImpossible(exception);
    }
}

	@Override
public int insertEmploye(Employe employe) throws SauvegardeImpossible {
    try {
        PreparedStatement instruction = connection.prepareStatement("insert into employe (nomEmploye, prenomEmploye, password, mail, DateArrivee, DateDepart, id_ligue) values (?, ?, ?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
        instruction.setString(1, employe.getNom());
        instruction.setString(2, employe.getPrenom());
        instruction.setString(3, employe.getPassword());
        instruction.setString(4, employe.getMail());
        instruction.setDate(5, Date.valueOf(employe.getDateArrivee()));
        instruction.setDate(6, employe.getDateDepart() == null ? null : Date.valueOf(employe.getDateArrivee()));
        instruction.setInt(7, employe.getLigue().getId_ligue());
        instruction.executeUpdate();
        ResultSet id = instruction.getGeneratedKeys();
        id.next();
        return id.getInt(1);
    } 
    catch (SQLException exception) 
    {
        exception.printStackTrace();
        throw new SauvegardeImpossible(exception);
    }
}

@Override
public void updateEmploye(Employe employe, String dataList) throws SauvegardeImpossible {
    try {
    	PreparedStatement instruction;
        instruction = connection.prepareStatement("UPDATE employe SET " + dataList + "= ? WHERE id_employe = ?");

		Map <String, String> map = new HashMap<>();
				map.put("nomEmploye", employe.getNom());
				map.put("prenomEmploye", employe.getPrenom());
				map.put("mail", employe.getMail());
				map.put("password", employe.getPassword());
				map.put("DateArrivee", String.valueOf(employe.getDateArrivee()).isEmpty() ? null : String.valueOf(employe.getDateArrivee()));
				map.put("DateDepart", String.valueOf(employe.getDateDepart()).isEmpty() ? null : String.valueOf(employe.getDateDepart()));
	instruction.setString(1, map.get(dataList));
    instruction.setInt(2, employe.getid());
	instruction.executeUpdate();
	} catch (SQLException exception) {
        exception.printStackTrace();
        throw new SauvegardeImpossible(exception);
    }
}


@Override
public void deleteLigue(Ligue ligue) throws SauvegardeImpossible {
    try {
        PreparedStatement instruction = connection.prepareStatement(
            "delete from ligue where id_ligue = ?"
        );
        instruction.setInt(1, ligue.getId_ligue());
        instruction.executeUpdate();
    } catch (SQLException exception) {
        exception.printStackTrace();
        throw new SauvegardeImpossible(exception);
    }
}


@Override
public void deleteEmploye(Employe employe) throws SauvegardeImpossible {
    try {
        PreparedStatement instruction = connection.prepareStatement(
            "delete from employe where id_employe = ?"
        );
        instruction.setInt(1, employe.getid());
        instruction.executeUpdate();
    } catch (SQLException exception) {
        exception.printStackTrace();
        throw new SauvegardeImpossible(exception);
    }
}

}
