package it.SWEasabi.management.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.JsonObject;


public class DBLampManagerService implements LampManagerService {
	
	private DatabaseConnectionService ConnectionHandler;
	
	public DBLampManagerService(DatabaseConnectionService sv)
	{
		ConnectionHandler=sv;
	}

	public String getLamp(int idLampione) {
		return ConnectionHandler.runSingleSelectQuery("SELECT * FROM lampione WHERE id = " + idLampione).toString();
	}

	public boolean addLamp(int IdArea, double Latitudine, double Longitudine, int Luminosita) {
		boolean mis = ConnectionHandler.runInsertQuery("INSERT INTO misuratore(idArea,latitudine, longitudine,tipo) VALUES (" + IdArea + ", " + Latitudine + ", " + Longitudine + ", 'lampione');");
		int misID = Integer.parseInt(ConnectionHandler.runSingleSelectQuery("SELECT MAX(id) AS id FROM misuratore").get("id").toString());
		boolean lamp = ConnectionHandler.runInsertQuery("INSERT INTO lampione(idMisuratore,luminosita) VALUES (" + misID + ", " + Luminosita + ");");
		return mis && lamp;
	}

	public boolean deleteLamp(int IdLampione) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setBrightness(int IdLampione, int Luminosita) {
		// TODO Auto-generated method stub
		return false;
	}
}
