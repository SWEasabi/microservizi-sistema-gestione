package it.SWEasabi.management.port;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.SWEasabi.management.DTO.Lamp;
import it.SWEasabi.management.DTO.Sensor;

public class LocalDTOBuilderService implements DTOBuilderService {
	
	public Lamp buildLampFromQueryResult(ResultSet lamp, ResultSet mis) {
		
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
	
public Sensor buildSensorFromQueryResult(ResultSet lamp, ResultSet mis) {
		
		try {
    		int id = 0;
    		int measurerId = 0;
    		int brightness = 0;
    		int areaId = 0;
    		double longitude = 0.0;
    		double latitude = 0.0;
    		
    		id = lamp.getInt("id");
    		measurerId = mis.getInt("id");
    		brightness = lamp.getInt("raggio");

    		areaId = mis.getInt("idarea");
        	longitude = mis.getDouble("longitudine");
        	latitude = mis.getDouble("latitudine");

    		
    		return new Sensor(id,measurerId,areaId,longitude,latitude,brightness);
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    			return new Sensor();
    	}
	}

}
