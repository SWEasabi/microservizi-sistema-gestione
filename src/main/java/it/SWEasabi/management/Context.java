package it.SWEasabi.management;

import java.util.List;

import com.google.gson.JsonObject;

import it.SWEasabi.management.DTO.Area;
import it.SWEasabi.management.DTO.Lamp;
import it.SWEasabi.management.DTO.Sensor;
import it.SWEasabi.management.kernel.AreaManager;
import it.SWEasabi.management.kernel.LampManager;
import it.SWEasabi.management.kernel.SensorManager;
import it.SWEasabi.management.services.AccessKeyService;
import it.SWEasabi.management.services.DTOBuilderService;
import it.SWEasabi.management.services.DatabaseConnectionService;
import it.SWEasabi.management.services.LocalAccessKeyService;
import it.SWEasabi.management.services.LocalDTOBuilderService;
import it.SWEasabi.management.services.LocalDatabaseConnectionService;

public class Context 
{
    static AccessKeyService keys = new LocalAccessKeyService();
    static DTOBuilderService dtobuilder = new LocalDTOBuilderService();
    static DatabaseConnectionService dbservice = new LocalDatabaseConnectionService(dtobuilder);
    static LampManager lampManager = new LampManager(dbservice);
    static SensorManager sensorManager = new SensorManager(dbservice);
    static AreaManager areaManager = new AreaManager(dbservice);
    
    public static String listener(String json)
    {
    	return null;
    }
    
    public static String getLamp(int id)
    {
    	Lamp lampada = lampManager.getLamp(id);
    	
    	JsonObject res = new JsonObject();
    	res.addProperty("id", lampada.getId());
    	res.addProperty("idmisuratore", lampada.getMeasurerId());
    	res.addProperty("idarea", lampada.getAreaId());
    	res.addProperty("longitudine", lampada.getLongitude());
    	res.addProperty("latitudine", lampada.getLatitude());
    	res.addProperty("luminosita", lampada.getBrightness());
    	
    	return res.toString();
    }
    
    public static String getLampsInArea(int idArea)
    {
    	List<Lamp> lampade = lampManager.getLampsInArea(idArea);
    	String response = "";
    	
    	for(Lamp lampada : lampade)
    	{
    		JsonObject res = new JsonObject();
        	res.addProperty("id", lampada.getId());
        	res.addProperty("idmisuratore", lampada.getMeasurerId());
        	res.addProperty("idarea", lampada.getAreaId());
        	res.addProperty("longitudine", lampada.getLongitude());
        	res.addProperty("latitudine", lampada.getLatitude());
        	res.addProperty("luminosita", lampada.getBrightness());
        	response = response + res.toString();
    	}
    	
    	return response;
    }
    
    public static boolean insertLamp(int idArea, double longitudine, double latitudine, int valore)
    {
    	return lampManager.insertLamp(idArea, longitudine, latitudine, valore);
    }
    
    public static boolean deleteLamp(int id)
    {
    	return lampManager.deleteLamp(id);
    }
    
    public static String getSensor(int id)
    {
    	Sensor sensore = sensorManager.getSensor(id);
    	
    	JsonObject res = new JsonObject();
    	res.addProperty("id", sensore.getId());
    	res.addProperty("idmisuratore", sensore.getMeasurerId());
    	res.addProperty("idarea", sensore.getAreaId());
    	res.addProperty("longitudine", sensore.getLongitude());
    	res.addProperty("latitudine", sensore.getLatitude());
    	res.addProperty("luminosita", sensore.getRadius());
    	
    	return res.toString();
    }
    
    public static boolean insertSensor(int idArea, double longitudine, double latitudine, int valore)
    {
    	return sensorManager.insertSensor(idArea, longitudine, latitudine, valore);
    }
    
    public static boolean deleteSensor(int id)
    {
    	return sensorManager.deleteSensor(id);
    }
    
    public static String getArea(int id)
    {
    	Area area = areaManager.getArea(id);
    	
    	JsonObject res = new JsonObject();
    	res.addProperty("id", area.getId());
    	res.addProperty("nome", area.getNome());
    	res.addProperty("auto", area.isAuto());
    	res.addProperty("inferiore", area.getInf());
    	res.addProperty("superiore", area.getSup());
    	
    	return res.toString();
    }
    
    public static String getAreaList()
    {
    	List<Area> aree = areaManager.getAreaList();
    	String response = "";
    	
    	for(Area area : aree)
    	{
    		JsonObject res = new JsonObject();
        	res.addProperty("id", area.getId());
        	res.addProperty("nome", area.getNome());
        	res.addProperty("auto", area.isAuto());
        	res.addProperty("inferiore", area.getInf());
        	res.addProperty("superiore", area.getSup());
        	response = response + res.toString();
    	}
    	
    	return response;
    }
    
}
