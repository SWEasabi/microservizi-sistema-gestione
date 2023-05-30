package it.SWEasabi.management.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.google.gson.JsonObject;

public class LocalDatabaseConnectionService implements DatabaseConnectionService {
	
	private final String url = "jdbc:postgresql://localhost/gestionedb";
    private final String user = "postgres";
    private final String password = "SWEasabi123!";
    
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
    
    public JsonObject runSingleSelectQuery(String query)
    {
    	JsonObject json = new JsonObject();
    	try {
		Connection conn = connect();
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet res = stmt.executeQuery();
		int column;
		ResultSetMetaData md;
		while(res.next())
		{
			md = res.getMetaData();
			column = md.getColumnCount();
			for(int i=1;i<column+1;++i)
			{
				json.addProperty(md.getColumnName(i), res.getInt(md.getColumnName(i)));
			}
		}
		conn.close();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return json;
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
}
