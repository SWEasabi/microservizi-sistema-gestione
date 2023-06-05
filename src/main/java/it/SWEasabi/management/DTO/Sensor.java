package it.SWEasabi.management.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sensor {
	
	private int id;
	private int measurerId;
	private int areaId;
	private double longitude;
	private double latitude;
	private int radius;
	
	public Sensor()
	{
		id = 0;
		measurerId = 0;
		areaId = 0;
		longitude = 0.0;
		latitude = 0.0;
		radius = 0;
	}
	
	public Sensor(ResultSet Sensor, ResultSet mis)
	{
		try {
		id = Sensor.getInt("id");
		measurerId = Sensor.getInt("idmisuratore");
		radius = Sensor.getInt("luminosita");
		areaId = mis.getInt("idarea");
		longitude = mis.getDouble("longitudine");
		latitude = mis.getDouble("latitudine");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Sensor(int id, int measurerId, int areaId, double longitude, double latitude, int radius) {
		super();
		this.id = id;
		this.measurerId = measurerId;
		this.areaId = areaId;
		this.longitude = longitude;
		this.latitude = latitude;
		this.radius = radius;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMeasurerId() {
		return measurerId;
	}
	public void setMeasurerId(int measurerId) {
		this.measurerId = measurerId;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}