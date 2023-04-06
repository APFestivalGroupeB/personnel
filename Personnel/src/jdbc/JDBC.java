package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
				gestionPersonnel.addLigue(ligues.getInt(1), ligues.getString(2));
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
	public int insert(Ligue ligue) throws SauvegardeImpossible 
	{
		try 
		{
			String sql = "insert into ligue(nom, administrateur) values (?,?)";
			PreparedStatement instruction;
			instruction = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, ligue.getNom());
			instruction.setString(2, ligue.getAdministrateur().getNom());
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
	public void updateLigue(Ligue ligue) throws SauvegardeImpossible
	{
		try
		{
			String sql = "update ligue set nom = ? where id_ligue = ?";
			PreparedStatement instruction;
			instruction = connection.prepareStatement(sql);
			instruction.setString(1, ligue.getNom());
//			instruction.setString(2, ligue.getAdministrateur().getNom());
			instruction.setInt(2, ligue.getid_ligue());
			instruction.executeUpdate();
		}
		catch (SQLException exception) 
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}
	}
	public void insertEmploye(Employe employe) throws SauvegardeImpossible
	{
		try
		{
			String sql = "insert into employe(nomEmploye, prenomEmploye, password, mail, DateArrivee, DateDepart, id_ligue) values (?,?,?,?,?,?,?,?)";
			PreparedStatement instruction;
			instruction = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, employe.getNom());
			instruction.setString(2, employe.getPrenom());
			instruction.setString(3, employe.);			
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
}
