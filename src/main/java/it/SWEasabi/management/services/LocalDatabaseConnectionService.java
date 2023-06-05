package it.SWEasabi.management.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import it.SWEasabi.management.port.DTOBuilderService;
import it.SWEasabi.management.port.LocalDTOBuilderService;

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
    
    /*private Lamp lampFormatter(ResultSet lamp, ResultSet mis)
    {
    	try {
    		int id = 0;
    		int measurerId = 0;
    		int brightness = 0;
    		int areaId = 0;
    		double longitude = 0.0;
    		double latitude = 0.0;
    		
    		id = lamp.getInt("id");
    		measurerId = mis.getInt("id");
    		brightness = lamp.getInt("luminosita");

    		areaId = mis.getInt("idarea");
        	longitude = mis.getDouble("longitudine");
        	latitude = mis.getDouble("latitudine");

    		
    		return new Lamp(id,measurerId,areaId,longitude,latitude,brightness);
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    			return new Lamp();
    		}
    }
    
    private Sensor sensorFormatter(ResultSet sensor, ResultSet mis)
    {
    	try {
    		int id = sensor.getInt("id");
    		int measurerId = sensor.getInt("idmisuratore");
    		int brightness = sensor.getInt("luminosita");
    		int areaId = mis.getInt("idarea");
    		double longitude = mis.getDouble("longitudine");
    		double latitude = mis.getDouble("latitudine");
    		return new Sensor(id,measurerId,areaId,longitude,latitude,brightness);
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    			return new Sensor();
    		}
    }*/

	public Lamp selectLamp(int id) {
		try {
		// TODO Auto-generated method stub
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
		stmt.executeQuery();
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
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM misuratore WHERE idArea = " + idArea + " AND tipo = 'lampione'");
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

	public boolean insertSensor( int areaId, double longitude, double latitude, int brightness) {
		try {
		Connection conn = connect();
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO misuratore(idArea,latitudine, longitudine,tipo) VALUES (" + areaId + ", " + latitude + ", " + longitude + ", 'sensore');");
		stmt.executeQuery();
		stmt = conn.prepareStatement("SELECT MAX(id) AS id FROM misuratore");
		ResultSet mis = stmt.executeQuery();
		int misId = 0;
		while(mis.next())
		{
			misId = mis.getInt("id");
		}
		stmt = conn.prepareStatement("INSERT INTO sensore(idMisuratore,luminosita) VALUES (" + misId + ", " + brightness + ");");
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
