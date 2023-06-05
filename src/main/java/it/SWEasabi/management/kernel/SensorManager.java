package it.SWEasabi.management.kernel;

import it.SWEasabi.management.DTO.Sensor;
import it.SWEasabi.management.services.DatabaseConnectionService;

public class SensorManager {

	private DatabaseConnectionService dbservice;
	
	public SensorManager( DatabaseConnectionService db)
	{
		dbservice = db;
	}
	
	public Sensor getSensor(int id)
	{
		return dbservice.selectSensor(id);
	}
	
	public boolean insertSensor(int idArea, double lgt, double lat, int valore)
	{
		return dbservice.insertSensor(idArea, lgt, lat, valore);
	}
	
	public boolean deleteSensor(int id)
	{
		return dbservice.deleteSensor(id);
	}
}