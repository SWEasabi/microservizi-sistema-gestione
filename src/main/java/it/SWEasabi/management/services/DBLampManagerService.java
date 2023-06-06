package it.SWEasabi.management.services;

/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.JsonObject;*/

import it.SWEasabi.management.DTO.Lamp;


public class DBLampManagerService implements LampManagerService {
	
	private DatabaseConnectionService ConnectionHandler;
	private DTOBuilderService builder;
	
	public DBLampManagerService(DatabaseConnectionService sv, DTOBuilderService bd)
	{
		ConnectionHandler=sv;
		builder=bd;
	}

	@Override
	public Lamp getLamp(int IdLampione) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addLamp(int IdArea, double Latitudine, double Longitudine, int Luminosita) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLamp(int IdLampione) {
		// TODO Auto-generated method stub
		return false;
	}

	/*public Lamp getLamp(int idLampione) {
		try {
		ResultSet lamp = ConnectionHandler.runSingleSelectQuery("SELECT * FROM lampione WHERE id = " + idLampione);
		
		ResultSet mis = ConnectionHandler.runSingleSelectQuery("SELECT * FROM misuratore WHERE id = " + lamp.getInt("idmisuratore"));
		
		return builder.buildLampFromQueryResult(lamp,mis);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return new Lamp(0,0,0,0.0,0.0,0);
		}
		
	}

	public boolean addLamp(int IdArea, double Latitudine, double Longitudine, int Luminosita) {
		try {
		boolean mis = ConnectionHandler.runInsertQuery("INSERT INTO misuratore(idArea,latitudine, longitudine,tipo) VALUES (" + IdArea + ", " + Latitudine + ", " + Longitudine + ", 'lampione');");
		
		int misID = ConnectionHandler.runSingleSelectQuery("SELECT MAX(id) AS id FROM misuratore").getInt("id");
		
		boolean lamp = ConnectionHandler.runInsertQuery("INSERT INTO lampione(idMisuratore,luminosita) VALUES (" + misID + ", " + Luminosita + ");");
		return mis && lamp;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteLamp(int IdLampione) {
		
		try {
		
		ResultSet lamp = ConnectionHandler.runSingleSelectQuery("SELECT * FROM lampione WHERE id = " + IdLampione);
		boolean lampRes = ConnectionHandler.runDeleteQuery("DELETE FROM lampione WHERE id = " + IdLampione);
		
		int misId = lamp.getInt("idmisuratore");
		
		boolean misRes = ConnectionHandler.runDeleteQuery("DELETE FROM misuratore WHERE id = " + lamp.getInt("idmisuratore"));
		
		return lampRes & misRes;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}*/
}
