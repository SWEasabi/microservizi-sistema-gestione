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
	
	public boolean moveMeasurer(int idMis, int idArea)
	{
		return dbservice.moveMeasurer(idMis, idArea);
	}
	
	public Area getArea(int id)
	{
		return dbservice.getArea(id);
	}
	
	public List<Area> getAreaList()
	{
		return dbservice.getAreaList();
	}
	
	public boolean editAreaName(int id, String nome)
	{
		return dbservice.editAreaName(id, nome);
	}
	
	public boolean insertArea(String nome, boolean auto, int inf, int sup)
	{
		return dbservice.insertArea(nome, auto, inf, sup);
	}
	
	public boolean deleteArea(int id)
	{
		return dbservice.deleteArea(id);
	}

}
