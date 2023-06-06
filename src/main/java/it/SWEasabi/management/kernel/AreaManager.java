package it.SWEasabi.management.kernel;

import java.util.List;

import it.SWEasabi.management.DTO.Area;
import it.SWEasabi.management.services.DatabaseConnectionService;

public class AreaManager {
	
	private DatabaseConnectionService dbservice;
	
	public AreaManager( DatabaseConnectionService db)
	{
		dbservice = db;
	}
	
	public Area getArea(int id)
	{
		return dbservice.getArea(id);
	}
	
	public List<Area> getAreaList()
	{
		return dbservice.getAreaList();
	}

}
