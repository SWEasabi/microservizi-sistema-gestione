package it.SWEasabi.management.services;

import java.sql.ResultSet;

import it.SWEasabi.management.DTO.Area;
import it.SWEasabi.management.DTO.Lamp;
import it.SWEasabi.management.DTO.Sensor;

public interface DTOBuilderService {
	public Lamp buildLampFromQueryResult(ResultSet lamp, ResultSet mis);
	public Sensor buildSensorFromQueryResult(ResultSet lamp, ResultSet mis);
	public Area buildAreaFromQueryResult(ResultSet area);
}
