package it.SWEasabi.management.services;

import java.sql.Connection;
import java.util.List;

import it.SWEasabi.management.DTO.Area;
import it.SWEasabi.management.DTO.Lamp;
import it.SWEasabi.management.DTO.Sensor;

public interface DatabaseConnectionService {
	
	public Connection connect();
	//public ResultSet runSingleSelectQuery(String query);
	//public boolean runInsertQuery(String query);
	//public boolean runUpdateQuery(String query);
	//public boolean runDeleteQuery(String query);
	
	public Lamp selectLamp(int id);
	public List<Lamp> selectLampsInArea(int idArea);
	public boolean insertLamp(int areaId, double longitude, double latitude, int brightness);
	public boolean deleteLamp(int id);
	public Sensor selectSensor(int id);
	public boolean insertSensor(int areaId, double longitude, double latitude, int brightness);
	public boolean deleteSensor(int id);
	public boolean moveMeasurer(int idMis, int idArea);
	public Area getArea(int id);
	public List<Area> getAreaList();
	public boolean editAreaName(int id, String nome);
	public boolean insertArea(String nome, boolean auto, int inf, int sup);
	public boolean deleteArea(int id);
}
