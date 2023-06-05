package it.SWEasabi.management.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Lamp {
	
	private int id;
	private int measurerId;
	private int areaId;
	private double longitude;
	private double latitude;
	private int brightness;
	
	public Lamp()
	{
		id = 0;
		measurerId = 0;
		areaId = 0;
		longitude = 0.0;
		latitude = 0.0;
		brightness = 0;
	}
	
	public Lamp(ResultSet lamp, ResultSet mis)
	{
		try {
		id = lamp.getInt("id");
		measurerId = lamp.getInt("idmisuratore");
		brightness = lamp.getInt("luminosita");
		areaId = mis.getInt("idarea");
		longitude = mis.getDouble("longitudine");
		latitude = mis.getDouble("latitudine");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Lamp(int id, int measurerId, int areaId, double longitude, double latitude, int brightness) {
		super();
		this.id = id;
		this.measurerId = measurerId;
		this.areaId = areaId;
		this.longitude = longitude;
		this.latitude = latitude;
		this.brightness = brightness;
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
	public int getBrightness() {
		return brightness;
	}
	public void setBrightness(int brightness) {
		this.brightness = brightness;
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
