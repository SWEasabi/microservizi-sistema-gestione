package it.SWEasabi.management.kernel;

import java.util.List;

import it.SWEasabi.management.DTO.Lamp;
import it.SWEasabi.management.services.DatabaseConnectionService;

public class LampManager {

	private DatabaseConnectionService dbservice;
	
	public LampManager( DatabaseConnectionService db)
	{
		dbservice = db;
	}
	
	public Lamp getLamp(int id)
	{
		return dbservice.selectLamp(id);
	}
	
	public List<Lamp> getLampsInArea(int idArea)
	{
		return dbservice.selectLampsInArea(idArea);
	}
	
	public boolean insertLamp(int idArea, double lgt, double lat, int valore)
	{
		return dbservice.insertLamp(idArea, lgt, lat, valore);
	}
	
	public boolean deleteLamp(int id)
	{
		return dbservice.deleteLamp(id);
	}
}
