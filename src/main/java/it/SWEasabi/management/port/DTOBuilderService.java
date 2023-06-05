package it.SWEasabi.management.port;

import java.sql.ResultSet;

import it.SWEasabi.management.DTO.Lamp;
import it.SWEasabi.management.DTO.Sensor;

public interface DTOBuilderService {
	public Lamp buildLampFromQueryResult(ResultSet lamp, ResultSet mis);
	public Sensor buildSensorFromQueryResult(ResultSet lamp, ResultSet mis);
}
