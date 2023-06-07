package it.SWEasabi.management.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.SWEasabi.management.DTO.Area;
import it.SWEasabi.management.DTO.Lamp;
import it.SWEasabi.management.DTO.Sensor;

public class LocalDatabaseConnectionService implements DatabaseConnectionService {
	
	private final String url = "jdbc:postgresql://localhost/gestionedb";
    private final String user = "postgres";
    private final String password = "SWEasabi123!";
    private DTOBuilderService service;
    
    public LocalDatabaseConnectionService(DTOBuilderService sv)
    {
    	service = sv;
    }
    
    public Connection connect() {
        Connection conn = null;
        try {
        	
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

	public Lamp selectLamp(int id) {
		try {
		Connection conn = connect();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM lampione WHERE id = " + id);
		ResultSet lmp = stmt.executeQuery();
		lmp.next();
		stmt = conn.prepareStatement("SELECT * FROM misuratore WHERE id = " + lmp.getInt("idmisuratore"));
		ResultSet mis = stmt.executeQuery();
		mis.next();
		conn.close();
		return service.buildLampFromQueryResult(lmp,mis);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return new Lamp();
		}
	}
	
	public List<Lamp> selectLampsInArea(int idArea)
	{
		List<Lamp> output = new ArrayList<Lamp>();
		try {
			Connection conn = connect();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM misuratore WHERE idArea = " + idArea + " AND tipo = 'lampione'");
			ResultSet misList = stmt.executeQuery();
			while(misList.next())
			{
				stmt = conn.prepareStatement("SELECT * FROM lampione WHERE idMisuratore = " + misList.getInt("id"));
				ResultSet lmp = stmt.executeQuery();
				lmp.next();
				output.add(service.buildLampFromQueryResult(lmp,misList));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return output;
	}

	public boolean insertLamp( int areaId, double longitude, double latitude, int brightness) {
		try {
		Connection conn = connect();
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO misuratore(idArea,latitudine, longitudine,tipo) VALUES (" + areaId + ", " + latitude + ", " + longitude + ", 'lampione');");
		stmt.executeUpdate();
		stmt = conn.prepareStatement("SELECT MAX(id) AS id FROM misuratore");
		ResultSet mis = stmt.executeQuery();
		int misId = 0;
		while(mis.next())
		{
			misId = mis.getInt("id");
		}
		stmt = conn.prepareStatement("INSERT INTO lampione(idMisuratore,luminosita) VALUES (" + misId + ", " + brightness + ");");
		stmt.executeUpdate();
		return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteLamp(int id) {
		try {
		Connection conn = connect();
		PreparedStatement stmt = conn.prepareStatement("SELECT idMisuratore as idmis FROM lampione WHERE id = " + id);
		ResultSet mis = stmt.executeQuery();
		int misId = 0;
		while(mis.next())
		{
			misId = mis.getInt("idmis");
		}
		stmt = conn.prepareStatement("DELETE FROM lampione WHERE id = " + id);
		stmt.executeUpdate();
		stmt = conn.prepareStatement("DELETE FROM misuratore WHERE id = " + misId);
		stmt.executeUpdate();
		return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public Sensor selectSensor(int id) {
		try {
		// TODO Auto-generated method stub
		Connection conn = connect();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM sensore WHERE id = " + id);
		ResultSet sns = stmt.executeQuery();
		sns.next();
		stmt = conn.prepareStatement("SELECT * FROM misuratore WHERE id = " + sns.getInt("idmisuratore"));
		ResultSet mis = stmt.executeQuery();
		mis.next();
		conn.close();
		return service.buildSensorFromQueryResult(sns,mis);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return new Sensor();
		}
	}
	
	public List<Sensor> selectSensorsInArea(int idArea)
	{
		List<Sensor> output = new ArrayList<Sensor>();
		try {
			Connection conn = connect();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM misuratore WHERE idArea = " + idArea + " AND tipo = 'sensore'");
			ResultSet misList = stmt.executeQuery();
			while(misList.next())
			{
				stmt = conn.prepareStatement("SELECT * FROM lampione WHERE idMisuratore = " + misList.getInt("id"));
				ResultSet lmp = stmt.executeQuery();
				lmp.next();
				output.add(service.buildSensorFromQueryResult(lmp,misList));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return output;
	}

	public boolean insertSensor( int areaId, double longitude, double latitude, int radius) {
		try {
		Connection conn = connect();
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO misuratore(idArea,latitudine, longitudine,tipo) VALUES (" + areaId + ", " + latitude + ", " + longitude + ", 'sensore');");
		stmt.executeUpdate();
		stmt = conn.prepareStatement("SELECT MAX(id) AS id FROM misuratore");
		ResultSet mis = stmt.executeQuery();
		int misId = 0;
		while(mis.next())
		{
			misId = mis.getInt("id");
		}
		stmt = conn.prepareStatement("INSERT INTO sensore(idMisuratore,raggio) VALUES (" + misId + ", " + radius + ");");
		stmt.executeUpdate();
		return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteSensor(int id) {
		try {
		Connection conn = connect();
		PreparedStatement stmt = conn.prepareStatement("SELECT idMisuratore as idmis FROM sensore WHERE id = " + id);
		ResultSet mis = stmt.executeQuery();
		int misId = 0;
		while(mis.next())
		{
			misId = mis.getInt("idmis");
		}
		stmt = conn.prepareStatement("DELETE FROM sensore WHERE id = " + id);
		stmt.executeUpdate();
		stmt = conn.prepareStatement("DELETE FROM misuratore WHERE id = " + misId);
		stmt.executeUpdate();
		return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean moveMeasurer(int idMis, int idArea) {
		try {
			Connection conn = connect();
			PreparedStatement stmt = conn.prepareStatement("UPDATE misuratore SET idarea = " + idArea + " WHERE id = " + idMis);
			stmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public Area getArea(int id) {
		try {
			Connection conn = connect();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM area WHERE id = " + id);
			ResultSet area = stmt.executeQuery();
			conn.close();
			area.next();
			return service.buildAreaFromQueryResult(area);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				
			}
		return new Area();
	}

	public List<Area> getAreaList() {
		List<Area> list = new ArrayList<Area>();
		try {
			Connection conn = connect();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM area");
			ResultSet area = stmt.executeQuery();
			while(area.next())
			{
				list.add(service.buildAreaFromQueryResult(area));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public boolean editAreaName(int id, String nome) {
		try {
			Connection conn = connect();
			PreparedStatement stmt = conn.prepareStatement("UPDATE area SET nome = " + nome + " WHERE id = " + id);
			stmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertArea(String nome, boolean auto, int inf, int sup) {
		try {
			Connection conn = connect();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO area(nome,automode,lvlinf,lvlsup) VALUES ('" + nome + "', " + auto + ", " + inf + ", " + sup + ");");
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteArea(int id) {
		try {
			Connection conn = connect();
			PreparedStatement stmt = conn.prepareStatement("SELECT id, idarea FROM misuratore WHERE idarea = " + id);
			ResultSet misList = stmt.executeQuery();
			while(misList.next())
			{
				stmt = conn.prepareStatement("UPDATE misuratore SET idarea = null WHERE id = " + misList.getInt("id"));
				stmt.executeUpdate();
			}
			stmt = conn.prepareStatement("DELETE area WHERE id = " + id);
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
    
    /*public ResultSet runSingleSelectQuery(String query)
    {
    	JsonObject json = new JsonObject();
    	try {
		Connection conn = connect();
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet res = stmt.executeQuery();
		conn.close();
		while(res.next())
		return res;
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return null;
    }

	public boolean runInsertQuery(String query) {
    	try {
		Connection conn = connect();
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		conn.close();
		return true;
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return false;
	}

	public boolean runUpdateQuery(String query) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean runDeleteQuery(String query)
	{
		try {
			Connection conn = connect();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeUpdate();
			conn.close();
			return true;
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    	return false;
	}*/
}
