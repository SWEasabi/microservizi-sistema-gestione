package it.SWEasabi.management.services;

import java.sql.Connection;

import com.google.gson.JsonObject;

public interface DatabaseConnectionService {
	
	public Connection connect();
	public JsonObject runSingleSelectQuery(String query);
	public boolean runInsertQuery(String query);
	public boolean runUpdateQuery(String query);
}
